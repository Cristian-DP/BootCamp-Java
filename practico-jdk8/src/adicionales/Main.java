package adicionales;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main implements Bipredicate<Integer, Integer>{
	/*	Construir un Stream de numeros naturales que contenga 
	 * todos los números pares mayores o iguales a 10 y 
	 * menores o iguales a 20.  
	 * Presentar en una lista de Integer en forma ordenada. 
	 * Existen varias formas de realizar esto y me gustaría 
	 * ver todas las opciones que se les ocurren.*/
	private void pares (int min, int max) {		
		System.out.println("sin lista");
		Stream.iterate(0, x -> x + 1)
				.limit(max+1)
				.skip(min)
				.filter (x -> x%2 == 0)
				.forEach(x -> System.out.print(x + " "));
		System.out.println();
		/************************************************/
		
		System.out.println("seteando lista externa ");
		final List<Integer> l = new ArrayList<Integer>();
		Stream.iterate(0, x -> x + 1)
				.limit(max+1)
				.skip(min)
				.filter (x -> x%2 == 0)
				.forEach(x -> l.add(x));
		System.out.println(l);
		/************************************************/

		System.out.println("Obteniendo lista con collect");
		List<Integer> l2 = new ArrayList<Integer>();
		l2 = 
			Stream.iterate(0, x -> x + 1)
					.limit(max+1)
					.skip(min)
					.filter(x -> x%2==0)
					.collect(Collectors.toList());
		System.out.println(l2);
		/************************************************/

		System.out.println("Obteniendo lista con collect sin skip");
		List<Integer> l3 = new ArrayList<Integer>();
		l3 = 
			Stream.iterate(0, x -> x + 1)
					.limit(max+1)
					.filter(x -> x%2==0 && x >= min)
					.collect(Collectors.toList());
		System.out.println(l3);
	}
	/*	Si pudieron realizar correctamente el anterior, 
	 * ahora creemos un método como el siguiente:
	 * 
	 * List<Integer> obtenerListaSecuencialCondicionada(Integer desde, Integer hasta, Predicate<Integer> condicion)
	 * 
	 * 	Como ven, estoy generalizando el ejercicio anterior. 
	 * Y, como establecerían la posibilidad de recibir múltiples 
	 * predicados condicionales?
	 * 
	 * 		List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, List<Predicate<Integer>> condiciones)
	 * 		List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, Predicate<Integer>[] condiciones)		
	 * 		List<Integer> obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, Predicate<Integer> ... condicion)		
	 * Desarrollar los 3 por favor. 
	 * Es posible, por que? Si no es posible, defina 2.
	 * - Rta: no es posible ya que Predicate<Integer>... es igual a Predicate<Integer>[]
	 * 
	 * Ahora pensemos que cualquiera de los parámetros 
	 * (desde, hasta, condicion) podrían ser nulos.  
	 * Como lo resolverían.  Incluso, implementemos el metodo.
	 * 		List<Integer> obtenerListaSecuencial(Integer desde, Integer hasta)  
	 * reutilizando el metodo anterior!!! */
	
	List<Integer> 
	obtenerListaSecuencialCondicionada(Integer desde, Integer hasta, 
											Predicate<Integer> condicion){
		return Stream.iterate(0, x -> x+1)
				.limit(hasta + 1)
				.skip(desde)
				.filter(condicion)
				.collect(Collectors.toList());
	}
	
	List<Integer> 
	obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, 
													List<Predicate<Integer>> condiciones){
		
		return null;			
	}
	
	@Override
	public boolean test(Integer x, List<Predicate<Integer>> l) {
			
		return false;
	}

	List<Integer> 
	obtenerListaSecuencialCondicionadaMultiple(Integer desde, Integer hasta, 
													Predicate<Integer>[] condiciones){
		return  null;
	}
	
	List<Integer>
	obtenerListaSecuencial (Integer desde, Integer hasta){
		return
			(List<Integer>) Stream.iterate(0, x -> x+1)
			.filter(x -> desde != null)
			.filter(x -> hasta != null)
			.filter(x -> desde < hasta)
			.limit(hasta + 1)
			.skip(desde)
			.collect(Collectors.toList());
	}
	
	List<String>
	obtenerListaSecuencialString (Integer desde, Integer hasta){		
		return
			(List<String>) Stream.iterate(0, x -> x+1)
			.filter(x -> desde != null)
			.filter(x -> hasta != null)
			.limit(hasta + 1)
			.skip(desde)
			.map(x -> {
				if (x == hasta)
					return Integer.toString(x);
				else
					return Integer.toString(x) + " -> ";
			})
			.collect(Collectors.toList());
	}
	
	List<String>
		obtenerListaSecuencialStringConcat (Integer desde, Integer hasta){
		return (List<String>) 
				Stream.iterate(0, x -> x+1)
						.limit(hasta + 1)
						.skip(desde)
						.map(x -> {
							String s = "";
							for (int i = 0; i < x; i++) 
								s += Integer.toString(x);
							return s;
						})
						.collect(Collectors.toList());
	}
	
	HashMap<Integer, List<String>>
		obtenerMapaDePalabras (String texto){
		HashMap<Integer, List<String>> mapa = new HashMap<Integer, List<String>>();
		String[] txt = this.remplaceChar(texto, "").split(" ");
		
		Stream.of(txt)
				.filter(x -> !mapa.containsKey(x.length()))
				.forEach(x ->{
					List<String> palabras = new ArrayList<String>();	
					
					Stream.of(txt)
							.filter( y -> x.length() == y.length())
							.forEach(y -> palabras.add(y));
					
					mapa.put(x.length(), palabras);
				});
		return mapa;
	}
	
	HashMap<Integer, List<String>>
	obtenerMapaDePalabrasSinRepeticiones (String texto){
	HashMap<Integer, List<String>> mapa = new HashMap<Integer, List<String>>();
	String[] txt = this.remplaceChar(texto, "").split(" ");
	
	Stream.of(txt)
			.filter(x -> !mapa.containsKey(x.length()))
			.forEach(x ->{
				List<String> palabras = new ArrayList<String>();	
				
				Stream.of(txt)
						.filter( y -> x.length() == y.length())
						.distinct()
						.forEach(y -> palabras.add(y));
				
				mapa.put(x.length(), palabras);
			});
	return mapa;
}
	String remplaceChar (String texto,String replaceChar){
		return texto.replaceAll("[?¿)({}¡!\\,\\.\\~\\^\\[\\]\\-]",
										replaceChar);
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		
		/************** Pares mayores a 10 y menores a 20 *****************/
		System.out.println(" **Pares mayores a 10 y menores a 20 **");
		m.pares(10, 20);
		/******************************************************************/

		/*********************  Lista secuencial condicionada *************/
		System.out.println("\n **Lista secuencial condicionada **");
		System.out.println( "condicionada simple \n" +
				m.obtenerListaSecuencialCondicionada(10, 20, x-> x%2==0)
				);
		/******************************************************************/
		
		/*********************  Lista secuencial condicionada multiple ***/
		List<Predicate<Integer>> list = new ArrayList<Predicate<Integer>>();
		
		list.add(x -> x%2 == 0);
		list.add(x -> x != 15);
		System.out.println( "condicionada multiple \n" +
				m.obtenerListaSecuencialCondicionadaMultiple(10, 20, list)
				);
		/******************************************************************/
		
		/********************* Lista secuencial integer *******************/
		System.out.println("\n **Lista secuencial integer**");
		System.out.println(
				m.obtenerListaSecuencial(10, 20)
				);
		/******************************************************************/
		
		/********************* Lista secuencial String ********************/
		System.out.println("\n **Lista secuencial string **");
		System.out.println("" + 
				m.obtenerListaSecuencialStringConcat(2, 4));
		/******************************************************************/

		/************************ Mapa de palabras ***********************/
		String texto = "Algunas ^veces ?¿)({}¡!tiene sentido ¡abilitar la perforación, porque sitios donde lo vas a poner (por ej., Facebook) pueden tener distancias grandes entre las lineas y la perforación añadirá distancias verticales para contrarestar las verticales y hacer un estilo unico. Intentalo.";
		
		System.out.println("\n** Texto sin simbolos **");
		System.out.println("[Original] \n" + texto);
		System.out.println("[Sin simbolos] \n" + m.remplaceChar(texto, ""));
		
		System.out.println("\n** Mapa de palabras **");
		System.out.println("Con Repeticiones ");
		m.obtenerMapaDePalabras(texto)
				.forEach((k,v) -> {
					System.out.println(k +" Letras [" + v.size() + "]:");
					v.stream().forEach(x -> System.out.println(x));
				});

		System.out.println("\nSin Repeticiones ");
		m.obtenerMapaDePalabrasSinRepeticiones(texto)
				.forEach((k,v) -> {
					System.out.println(k +" Letras [" + v.size() + "]:");
					v.stream().forEach(x -> System.out.println(x));
				});
		/******************************************************************/

		
	}

}
