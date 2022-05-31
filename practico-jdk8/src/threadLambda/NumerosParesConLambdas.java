package threadLambda;

import java.util.function.Function;
import java.util.ArrayList;
import java.util.List;

/*
 * Predicate<T> 	--> test(T): boolean
 * Supplier<T> 		--> get():T
 * Consumer<T> 		--> accept(T):void
 * Function<T,R>	--> apply(T): R
 * 
 * 
 * */

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class NumerosParesConLambdas  implements Runnable {
	
	private Supplier<String> name;
	
	private Supplier<Integer> min_supplier;
	private Supplier<Integer> max_supplier;
	private Supplier<Integer> delay_supplier;
	
	private Predicate<Integer> p;
	private Function<Integer, Integer> add_one;
	private BiFunction<Integer, Integer, Integer> biadd_one;
	
	private List <Integer> list;
	
	public NumerosParesConLambdas () {
		initialized_lamdbas(1, 10, 3, "");
	}
	
	public NumerosParesConLambdas(int min, int max, int delay, String name) {
		if (min > max || delay < 0)
			return;
	
		initialized_lamdbas(min,max, delay, name);
	}
	
	private void initialized_lamdbas (int min, int max, int delay, String name) {

		min_supplier = ()-> min;
		max_supplier = ()-> max;
		delay_supplier = ()-> delay;
		
		this.name = ()-> name.toString();
		p = (x) -> x%2 == 0;
		add_one = (x) -> x = x+1;
		biadd_one = (x,y) -> x += y;
		
		list = new ArrayList<Integer>();
	}

	@Override
	public void run() {
		int aux, suma;
		
		aux = this.min_supplier.get();
		suma = 0;
		while (aux <= max_supplier.get()) {
			if (p.test(aux) == true) {
				suma = biadd_one.apply(suma, aux);
				list.add (aux);
			}
			aux = add_one.apply(aux);
			sleepSec();
		}
		
		print(suma, 
				"[suma par " + min_supplier.get() + "-" +
				max_supplier.get() + "]");
	}
	
	public List<Integer> getList() {
		return this.list;
	}

	private void print (int num, String msg) {
		System.out.println(msg + " " +
				Thread.currentThread().getName() + 
					" - " + num);
	}
	
	private void sleepSec () {
		try {
			Thread.sleep(delay_supplier.get()*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}

