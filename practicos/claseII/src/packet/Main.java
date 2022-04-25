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
		if (number < 10)
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
	
	public static void main(String[] args) {
		
		Main m = new Main();
		
		/* Prueba capicua */
		System.out.println( m.isCapicua(44) ? "true" : "false" );
		System.out.println( m.isCapicua(1001) ? "true" : "false" );
		System.out.println( m.isCapicua(1100) ? "true" : "false" );
		System.out.println( m.isCapicua(25632) ? "true" : "false" );
		
	}

}
