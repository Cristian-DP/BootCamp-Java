package arbolBinario;

public class Main {

	public static void main(String[] args) {
		ArbolBinario<Integer> tree = new ArbolBinario<Integer>();
		Integer[] data = {2,3,-10,-1,10,5};

		System.out.print("data: ");
		for (Integer i : data) {
			tree.agregarNodo(i);
			System.out.print(i + " ");
		}
		
		System.out.println();
		System.out.println("------- inOrden ------");
		tree.recorrer("inOrden");
		
		System.out.println("------ preOrden -------");
		tree.recorrer("preOrden");
		
		System.out.println("------ postOrden -------");
		tree.recorrer("postOrden");
	}

}
