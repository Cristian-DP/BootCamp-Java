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
		
		String numberString;
		int idxLeft, idxRight;
		
		/* Inicializo variables */
		numberString = Integer.toString(number);
		idxRight = numberString.length() - 1;
		idxLeft = 0;
		
		/* Mas de un digito */
		for (; idxRight >= idxLeft; idxLeft++, idxRight--)
			if (numberString.charAt(idxLeft) != numberString.charAt(idxRight))
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
	public long getFactorialWithRecursion(int number) {
		
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
	public long getFactorialWithoutRecursion(int number) {
		
		if (number < 0)
			return -1;
		
		long factorial = 1;
		
		for (long n = (long)number; n > 0; n--)
			factorial *= n;
		
		return factorial;
	}
	
	/**
	 * 
	 * @param number
	 * @return double
	 */
	public double intToBinaryV1 (int number) {
		if (number < 0)
			return -1.0;
		
		int n_bits, cociente;
		String[] stringBinary;
		String concat;
		
		/* obtengo la cantidad de bits del binario*/
		for (n_bits = 0; Math.pow((double)n_bits, 2) <= number; n_bits++) {}
		
		stringBinary = new String[n_bits];
		
		/* armo el binario en formato string cadena*/
		cociente = number;
		for (int idx = n_bits - 1; idx >= 0; idx--) {
			if (idx == 0)
				stringBinary[0] = Integer.toString(cociente);
			else {
				stringBinary[idx] = Integer.toString(cociente%2);
				cociente = cociente/2;
			}
		}
		
		/* concateno en un solo string el binario*/
		concat = "";
		for (int i = 0; i < stringBinary.length; i++) {
			concat += stringBinary[i];
		}
		
		return Double.parseDouble(concat);
	}
	
	public double intToBinaryV2 (int number) {
		return Double.parseDouble( Integer.toBinaryString(number) ); 
	}
	
	/**
	 * 
	 * @param number
	 * @return int
	 */
	public int binaryToInt (double number) {
		String binary;
		int decimal, bit, idx;
		
		/* convierto el double en int y luego a String*/
		binary = Integer.toString( (int) number );
		
		/* me posiciono al final del String */
		idx = binary.length()-1;
		
		/* convierto a decimal */
		decimal = 0;
		for (int i = 0; idx >= 0; idx--, i++) { 
			bit =  (int)Double.parseDouble("" + binary.charAt(idx)) ;
			decimal += (int) Math.pow( 2, i ) * bit;
		}
	
		return decimal;
	}
	
	public static void main(String[] args) {
		
		Main m = new Main();
		int number;
		double numberDouble;
		
		/* Prueba capicua */
		number = 100001;
		System.out.println("--------- Capicua -------------- ");
		System.out.println( number+ " -> " + (m.isCapicua(number) ? "true" : "false") );
		
		/* Prueba factorial */
		number = 5;
		System.out.println("--------- Factorial -------------- ");
		System.out.println( number + " -> " + m.getFactorialWithRecursion(number) + " [R]");
		System.out.println( number + " -> " + m.getFactorialWithoutRecursion(number));
		
		/* Prueba entero a Binario */
		number = 7;
		System.out.println("--------- Entero a Binario ------- ");
		System.out.println( number+ " -> " + m.intToBinaryV1(number));
		System.out.println( number+ " -> " + m.intToBinaryV2(number));
		
		/* Prueba binario a entero */
		numberDouble = 10000.0;
		System.out.println("--------- Binario a Entero ------- ");
		System.out.println( numberDouble + " -> " + m.binaryToInt(numberDouble));
		
	}

}
