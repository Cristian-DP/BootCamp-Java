package recursion;

public class FactorialRecursion {
	
	public long factorialRecursion (int number) {
		if (number == 1)
			return 1;
		
		return number * factorialRecursion(number-1);
	}
	
	public static void main(String[] args) {
		FactorialRecursion f = new FactorialRecursion();
		
		System.out.println( 4 + " -> " + f.factorialRecursion(4));
		System.out.println( 5 + " -> " + f.factorialRecursion(5));
		System.out.println( 40 + " -> " + f.factorialRecursion(40));
		

	}

}
