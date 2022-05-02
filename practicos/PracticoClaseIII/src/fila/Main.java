package fila;

import stack.Stack;

public class Main {

	public static void main(String[] args) {
		Fila<String> f = new Fila<String>();
		
		System.out.println("---------- isEmpty ------");
		if (f.isEmpty())
			System.out.println("empty");
		else
			System.out.println("not empty");
		
		System.out.println("---------- add ------");
		f.add("Boot");
		f.add("camp");
		f.add("Java");
		f.printFila();

		System.out.println("---------- isEmpty ------");
		if (f.isEmpty())
			System.out.println("empty");
		else
			System.out.println("not empty");

		System.out.println("---------- size ------");
		System.out.println(f.size());
		
		System.out.println("---------- remove 1------");
		f.remove(1);
		f.printFila();
		System.out.println("---------- remove 2------");
		f.remove(2);
		f.printFila();
		System.out.println("---------- remove 2------");
		f.remove(2);
		f.printFila();
		
	}

}
