package stack;

public class Main {

	public static void main(String[] args) {
		Stack<String> s = new Stack<String>();
		
		System.out.println("---------- isEmpty ------");
		if (s.isEmpty())
			System.out.println("empty");
		else
			System.out.println("not empty");

		System.out.println("---------- push ------");
		s.push("Boot");
		s.push("camp");
		s.push("Java");
		s.printStack();

		System.out.println("---------- isEmpty ------");
		if (s.isEmpty())
			System.out.println("empty");
		else
			System.out.println("not empty");

		System.out.println("---------- pop ------");
		s.pop();
		s.printStack();
		System.out.println("---------- pop ------");
		s.pop();
		s.printStack();
		System.out.println("---------- pop ------");
		s.pop();
		s.printStack();
		
		System.out.println("---------- pop empty------");
		s.pop();
		s.printStack();
		
		System.out.println("---------- push ------");
		s.push("Last");
		s.printStack();
	}

}
