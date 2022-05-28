package thread;

public class NumerosPares implements Runnable{
	private int min;
	private int max;
	private int delay;
	
	public NumerosPares () {
		setMax(10);
		setMin(1);
		setDelay(3);
	}
	
	public NumerosPares (int min, int max, int delay) {
		if (min > max || delay < 0)
			return;
		
		setMin(min);
		setMax(max);
		setDelay(delay);
	}
	
	public int getDelay() {
		return delay;
	}

	public void setDelay(int delay) {
		this.delay = delay;
	}

	@Override
	public void run() {
		int aux, suma;
		
		aux = this.min;
		suma = 0;
		while (aux <= max) {
			if (aux%2 == 0) {
				print(aux, "");
				suma += aux;
			}
			aux++;
			sleepSec();
		}
		
		print(suma, "[suma]");
	}
	
	private void print (int num, String msg) {
		System.out.println(msg + " " +
				Thread.currentThread().getName() + 
					" - " + num);
	}
	
	private void sleepSec () {
		try {
			Thread.sleep(getDelay()*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

}

