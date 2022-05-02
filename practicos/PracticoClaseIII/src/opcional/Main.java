package opcional;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	private List <Integer> lsum  = new ArrayList<Integer>(); 
	private int number;
	
	public boolean esSumaDeConsecutivosR(Integer number){
		this.number= number;
		
		lsum.clear();
		successiveSum(1, 1, number);
		
		return !lsum.isEmpty();
	}
	
	public boolean esSumaDeConsecutivosI(Integer number){
		this.number= number;
		
		lsum.clear();
		successiveSumI(number);
		
		return !lsum.isEmpty();
	}
	
	private void successiveSum (Integer base, Integer sum, Integer number) {

		if (base == number) {
			lsum.clear();
			return;
		}
		if (sum() == number)
			return;
		else if(sum() < number) {
			lsum.add(sum);
			successiveSum(base, sum+1, number);
		}
		else {
			lsum.clear();
			successiveSum(base+1, base+1, number);
			return;
		}
		
		return;
		
	}
	private void successiveSumI (Integer number) {
		int base;
		int suma;
		int idx;
		
		for (base = 1; base < number; base++) { 
			idx = base;

			while (true) {
				suma = sum();
				if (suma < number) {
					lsum.add(idx++);
				}
				else if(suma == number)
					return;
				else {
					lsum.clear();
					break;
				}
			}
		}
		
	}
	
	public int sum() {
		if (lsum.size() == 0)
			return 0;
		
		int suma = 0;
		for (int i = 0; i < lsum.size(); i++)
			suma += lsum.get(i);
		
		return suma;
	}
	
	public void print () {
		System.out.print(number + " =");
		for (Integer integer : lsum) {
			System.out.print(" " + integer);
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		Main m = new Main();
		long startTime, endTime;
		
		// ------------ recursivo ------------
	    startTime = System.currentTimeMillis();
		
		if (m.esSumaDeConsecutivosR(10000))
			m.print();
		
		endTime = System.currentTimeMillis() - startTime;
		
		System.out.println("Duración " + endTime + " milisegundos.\n");
		 
		// ------------ iterativo ------------
		startTime = System.currentTimeMillis();
		
		if (m.esSumaDeConsecutivosI(10000))
			m.print();

		endTime = System.currentTimeMillis() - startTime;
		System.out.println("Duración " + endTime + " milisegundos.\n");
		 
	}

}
