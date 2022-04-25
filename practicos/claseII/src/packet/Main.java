/**
 * @author cristian pereyra
 * @github https://github.com/Cristian-DP/BootCamp-Java.git 
 *  
 */

package packet;

public class Main {
	
	/**
	 * Al recibir un numero entero, se convierte a String. 
	 * Se recorre el String an ambas direcciones 
	 * (de derecha a izquierda y de izquierda a derecha).
	 * Si no se cumple la condicion de igualdad en cada lectura, se retorna false.
	 * 
	 * @param number
	 * @return boolean
	 */
	private boolean isCapicua (int number) {
		
		/* Un digito*/
		if (number < 10 && number >= 0)
			return true;
		
		String s;
		int i, j;
		
		/* Inicializo variables */
		s = Integer.toString(number);
		j = s.length() - 1;
		i = 0;
		
		/* Mas de un digito */
		for (; i != j && j > i; i++, j--)
			if (s.charAt(i) != s.charAt(j))
				return false;
		
		return true;
	}
	
	/**
	 * Al recibir un numero entero, se multiplica por los n-1 valores
	 * anteriores.
	 * Se resuelve de forma recursiva
	 * 
	 * @param number
	 * @return int
	 */
	public int getFactorialWithRecursion(int number) {
		
		if (number < 0) return -1;
		else if (number == 0) return 1;
		
		return number * getFactorialWithRecursion(number-1);
	}

	/**
	 * Al recibir un numero entero, se multiplica por los n-1 valores
	 * anteriores.
	 * Se resuelve de forma repetitiva
	 * 
	 * @param number
	 * @return int
	 */
	public int getFactorialWithoutRecursion(int number) {
		
		if (number < 0)
			return -1;
		
		int factorial = 1;
		
		for (int n = number; n >= 0; n--)
			if(n == 0)	factorial *= 1;
			else		factorial *= n;
		
		return factorial;
	}
	
	public static void main(String[] args) {
		
		Main m = new Main();
		int number;
		
		/* Prueba capicua */
		number = 22;
		System.out.println("--------- Capicua -------------- ");
		System.out.println( number+ " -> " + (m.isCapicua(number) ? "true" : "false") );
		
		/* Prueba factorial */
		number = 5;
		System.out.println("--------- Factorial -------------- ");
		System.out.println(  number + " -> " + m.getFactorialWithRecursion(number));
		System.out.println(  number + " -> " + m.getFactorialWithoutRecursion(number));
		
		
	}

}
