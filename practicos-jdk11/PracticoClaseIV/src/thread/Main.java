package thread;

public class Main {

	/*
	 * Enunciado:
	 *  1) Mostrar los numeros del 1 al 20 con un retardo de 3 segundos entre cada numero
		2) Generar un Thread o una Implementacion de Runnable que imprima numeros pares (1 al 10) y calcule la suma.  
		Lanzar junto a otro Thread o Runnable que imprima impares (1 al 10) y calcula la suma.  
		Cada Thread muestra la suma resultante cuando finaliza.  
		Utilizar las pausas necesarias para que se observe el paralelismo.
	 */
	public static void main(String[] args) {
		/* instnacia imprimir numeros */
		PrintNumber printNum = new PrintNumber (1, 20, 3);
		
		/* instancia de numeros pares*/
		NumerosPares numPar = new NumerosPares(	1, 10, 3);
		
		/* instancia de numero impares*/
		NumerosImpares numImpar = new NumerosImpares(1, 10, 3);
		
		/* instancia de Thread*/
		Thread th_printNum = new Thread (printNum, "printNum");
		Thread th_numPar = new Thread (numPar, "numPar");
		Thread th_numImpar = new Thread (numImpar, "numImpar");
		
		th_printNum.start();
		th_numPar.start();
		th_numImpar.start();
		
		System.out.println(
		  Thread.currentThread().getName().toString());
	}


}
