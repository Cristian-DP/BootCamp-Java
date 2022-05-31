package filaCollections;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Clase
 *
 * @param <T>
 */
public class FilaCollections<T> {
	
	List <T> list = new ArrayList<T>();
	int index = 0;
	
	/* encolar */
	public void encolar (T data) {
		if (data == null)
			return;
		
		list.add(data);
	}
	
	/* desencolar */
	/* index se actualiza a += 1 cuando desencolo */
	public T desencolar () {
		if (isFilaVacia())
			return null;
		
		index++;
		return list.get(index -1);	
		// return list.get(index++);	
	}
	
	/* isFilaVacia */
	public boolean isFilaVacia () {
		return index >= list.size();
	}

}
