package recursion;

public class ProductoRecursion {
	
	private int producto;
	
	private int multiplicar (int factor1, int factor2) {
		producto = 0;
		
		/* signos iguales */
		if (Integer.signum(factor1) == Integer.signum(factor2)) {
			if (Integer.signum(factor1) == -1)
				multiplicarR (1, -1*factor1, -1*factor2);
			else
				multiplicarR (1, factor1, factor2);
		}
		/* signos no iguales */
		else {
			if (Integer.signum(factor1) == -1)
				multiplicarR (1, factor2, factor1);
			else if (Integer.signum(factor2) == -1)
				multiplicarR (1, factor1, factor2);
		}
		
		return producto;
	}
	
	/**
	 * 
	 * @param cont
	 * @param factor1: numero menor
	 * @param factor2: numero mayor
	 */
	private void multiplicarR (int cont, int factor1, int factor2) {
		if (cont > factor1)
			return;
		else
			producto += factor2;
		
		multiplicarR(++cont, factor1, factor2);
	}
	
	public static void main(String[] args) {
		ProductoRecursion p = new ProductoRecursion();
		
		System.out.println("-5 * -20 = " + p.multiplicar(-5, -20));
		System.out.println(" 5 * -20 = " + p.multiplicar(5, -20));
		System.out.println("-5 *  20 = " + p.multiplicar(-5, 20));
		System.out.println(" 5 *  20 = " + p.multiplicar(5, 20));

	}

}
