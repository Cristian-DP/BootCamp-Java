package opcional;

import java.util.ArrayList;
import java.util.List;

public class SuccessiveSum {
	
	private Integer number;
	List <Integer> lsum ; 

	public SuccessiveSum() {
		number 	= 0;
		lsum = new ArrayList<Integer>(); 
	}
	
	public SuccessiveSum(Integer number) {
		this.number = number;
		lsum = new ArrayList<Integer>(); 
	}

	public List<Integer> getLsum() {
		return lsum;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}
	
	public void runSuccessiveSum(){
		successiveSum(1, number);
	}
	
	public void runSuccessiveSum(Integer number){
		this.number = number;
		int i;
		
		i = 1;
		for (; i<number; i++)
			if (successiveSum(i, number))
				break;
	}
	
	private boolean successiveSum (Integer sum, Integer number) {

		lsum.add(sum);
		
		if (sum() == number) {
			return true;
		}
		else if(sum() < number) {
			successiveSum(sum+1, number);
		}
		else {
			lsum.clear();
			successiveSum(sum+1, number);
			return false;
		}
		
		return true;
			
	}
	
	public int sum() {
		if (lsum.size() == 0)
			return 0;
		
		int suma = 0;
		for (int i = 0; i < lsum.size(); i++)
			suma += lsum.get(i);
		
		return suma;
	}
	
	public void print() {
		
		System.out.print(number + " =");
		for (Integer integer : lsum) {
			System.out.print(" " + integer);
		}
	}
}
