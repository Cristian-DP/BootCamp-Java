package filaCollections;

public class Main {

	public static void main(String[] args) {
		FilaCollections<Integer> f = new FilaCollections<Integer>();
		
		f.encolar(10);
		f.encolar(11);
		f.encolar(12);
		f.encolar(13);
		f.encolar(14);
		
		System.out.println(f.desencolar());
		System.out.println(f.desencolar());
		System.out.println(f.desencolar());
		System.out.println(f.desencolar());
		System.out.println(f.desencolar());
		System.out.println(f.desencolar());

		f.encolar(15);
		
		System.out.println(f.desencolar());
		System.out.println(f.desencolar());
	}

}
