package opcional;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		SuccessiveSum s1 = new SuccessiveSum();
		SuccessiveSum s2 = new SuccessiveSum(15);
				
		s2.runSuccessiveSum();
		
		s2.print ();
	}

}
