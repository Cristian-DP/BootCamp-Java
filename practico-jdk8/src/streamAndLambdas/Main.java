package streamAndLambdas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * Cree un Lista y carge un numero considerable de alumnos 
 * para que el ejercicio sea viable (15 o mas) con valores a azar.

a) Muestre todos los alumnos de la lista
b) Muestre todos los alumnos ordenados de menor a mayor por edad
c) Muestre aquellos alumnos cuyo nombre empieza con un caracter 
	dado (elegir el caracter en base a la lista de nombre que 
	se utilizo)
d) Sume la edad de todos los alumnos
e) Obtenga un mapa donde la clave sea la nota y 
	el valor sea una lista de alumnos que tienen esa nota
 */
public class Main {

	public static void main(String[] args) {
		List<Alumnos> l = new ArrayList<Alumnos>();
		/* l2 está declarada porque salta error en 
		 * seteo del mapa. Usando l alli, me dice que l 
		 * debe estar declarada como final. 
		 * Si declaro l como final, cuando genero los
		 * alumnos aleatoriamente, salta error */
		 List<Alumnos> l2 = new ArrayList<Alumnos>();
		
		/* Genero Alumnos randomicamente */
		int i = 0;
		l = (ArrayList<Alumnos>)
			Stream.iterate(1, cant -> cant+1)
					.limit(15)
					.map(id -> {
						Random rand = new Random();
						Alumnos a = new Alumnos(id, rand.nextInt(15), 
											""+rand.nextInt(400000) , 
											rand.nextInt(15) + "nom"+ i, 
											rand.nextInt(15) + "ap"+i, 
											"BootCamp", 
											rand.nextInt(10));
						return a;
					})
					.collect(Collectors.toList());
		
		/*Se muestran todos los alumnos de la lista*/
		System.out.println("*********** Listado de alumnos ***********");
		Stream.of(l)
			// .map(x->x) Sigo mirando la lista
			// Ingreso con una lista l y la desarmo en sus elementos
			.flatMap(x -> x.stream())
			// aqui ya tengo al objeto Alumnos
			.forEach(System.out::println);
		/****************************************************************/

		/*Se muestran todos los alumnos ordenados por edad*/
		/*
		 * Obtengo el primer alumno
		 * veo la edad
		 */
		System.out.println("\n*********** Ordenados por edad ***********");
		//l.stream().sorted().forEach(System.out::println);
		
		Stream.of(l)
					.flatMap(x->x.stream())
					.sorted()
					.forEach(System.out::println);
		
		System.out.println("\n**** Alumnos cuyo nombre empiecen con caract  -7- *****");
		Stream.of(l)
					/* obtengo cada elemento de la lista*/
					.flatMap(x -> x.stream())
					/* aplico filtro para los que comienzan con char definido */
					.filter(x -> x.getNombre().startsWith("7"))
					/* imprimo los que pasaron el filtro */
					.forEach(System.out::println);
		/****************************************************************/

		System.out.println("\n**** Suma de las edades *****");
		
		System.out.println( "usando mapToInt: " +
					l.stream().mapToInt(x -> x.getEdad()).sum() );
		
		System.out.println(	"usando reduce simple: " +
					l.stream().map(x -> x.getEdad())
								.reduce((x,y) -> x + y)
								.orElse(0));
		
		System.out.println(	"usando reduce con base: " +
				l.stream().map(x -> x.getEdad())
							.reduce(0, (x,y) -> x + y));
		
		System.out.println(	"usando reduce complejo sin parallel: " +
				l.stream().map(x -> x.getEdad())
							.reduce(0, (x,y) -> x + y, (x,y) -> x + y));
		
		System.out.println(	"usando reduce complejo con parallel: " +
				l.stream().map(x -> x.getEdad())
							.parallel()
							.reduce(0, (x,y) -> x + y, (x,y) -> x + y));
		/****************************************************************/
		
		System.out.println("\n**** Mapa de notas - listaDeAlumnos *****");
		HashMap<Double, List<Alumnos>> mapa = new HashMap<Double, List<Alumnos>>();
		
		/* seteo el mapa */
		l.stream().forEach(x -> l2.add(x));
		l.stream()
				/* pregunto si la nota ya es clave en el mapa*/
				.filter(x -> !mapa.containsKey(x.getNota()))
				/* si no es clave, sigo con forEach */
				.forEach(x -> {/* vuelvo a mirar a todos lo elementos de la lista
					 * para buscar aquellos que tiene la misma nota que
					 * el elemento -x- que paso el filtro */
					ArrayList<Alumnos> al =
						(ArrayList<Alumnos>) l2.stream()
								/* pregunto si el elemento -y- tiene la misma
								 * nota que el elemento -x- */
								.filter(y -> y.getNota() == x .getNota())
								/* si tiene la misma nota, agrego al elemento -y-
								 * a la lista de los alumnos que tiene la misma
								 * nota que el elemento -x-*/
								.collect(Collectors.toList());
					/* agrego la lista obtenida de los Alumnos con las mismas notas,
					 * al mapa con clave del elemento -x- */
					mapa.put(x.getNota(), al);
				});
		/****************************************************************/
		
		/* imprimo mapa */
		mapa.forEach((k,v)-> {
					System.out.println("[" + k + "]");
					v.stream().forEach(x -> System.out.println(x));
				});
		/****************************************************************/
	}
}
