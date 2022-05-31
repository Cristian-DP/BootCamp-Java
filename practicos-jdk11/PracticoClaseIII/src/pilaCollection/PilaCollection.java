package pilaCollection;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Clase
 *
 * @param <T>
 */
public class PilaCollection<T> {
	
	List <T> l ;
	
	public PilaCollection(){
		l = new ArrayList<T>();
	}
	
	public void push (T value) {
		if (value != null)
			l.add(value);
	}
	
	public T pop() {
		if (l.isEmpty())
			return null;
		
		return l.remove(l.size() - 1);
	}
}
