package recursion;

public class StringRecursion {
	
	private String palabraInvertida = "";

	public String invertirStringR(String palabra) {	
		palabraInvertida = "";
		return invertirStringR (palabra.length()-1, palabra);
	}
	
	private String invertirStringR (int idxo, String origen) {
		
		if (idxo < 0) {
			return palabraInvertida;
		}else {
			palabraInvertida += origen.charAt(idxo) ;
			invertirStringR(--idxo, origen);
		}
		
		return palabraInvertida;
	}
	
	public static void main(String[] args) {
		String palabra;
		StringRecursion s = new StringRecursion();
		
		System.out.println("---- Antes de invertir ---- ");
		palabra = "hola";
		System.out.println(palabra);

		System.out.println("---- despues de invertir ---- ");
		palabra = s.invertirStringR(palabra);
		System.out.println(palabra);

		System.out.println("---- Antes de invertir ---- ");
		palabra = "Hola Como estas?";
		System.out.println(palabra);

		System.out.println("---- despues de invertir ---- ");
		palabra = s.invertirStringR(palabra);
		System.out.println(palabra);
		
		System.out.println("----------------------------- ");
	}


}
