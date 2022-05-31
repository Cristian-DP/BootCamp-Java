package threadLambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		NumerosParesConLambdas n = new NumerosParesConLambdas(
							1, 20, 0, "name1");
		NumerosImparesConLambda i = new NumerosImparesConLambda(
				1, 20, 0, "name2");

		Thread t = new Thread (n);
		Thread t2 = new Thread (i);
		
		t.start();
		t2.start();
		
		t.join();
		t2.join();
		
		/* optional */
		System.out.println("\nlist par");
		Optional.ofNullable(n.getList())
				.ifPresent(l->System.out.println(l.toString()));
		System.out.println("*********************************");
		
		System.out.println("\nlist impar");
		Optional.ofNullable(i.getList())
					.filter(l-> l.size() > 0)
					.ifPresent(l->System.out.println(l.toString()));
					
		System.out.println("*********************************");
								
		System.out.println("\nlist impar con stream");
		Optional.ofNullable(i.getList())
				.filter(l -> l.size() > 0)
				.ifPresent(System.out::println);
		System.out.println("*********************************");

		System.out.println("\nlist multiplos impar de tres con stream ");
		List<Integer> list = 
				Optional.ofNullable(i.getList())
						.filter(l -> l.size() > 0)
						.map(
								l -> l.stream()
								    .filter(x-> (x%3)==0)
									.collect(Collectors.toList())
							)
						.orElseGet(ArrayList::new);
							
		list.stream().forEach(System.out::println);
		System.out.println("*********************************");
	}

}
