import java.util.*;


public abstract class MapCar<T, E> {
	
	public ArrayList<T> mapcar(ArrayList<E> list) {
		ArrayList<T> retVal = new ArrayList<T>();
		
		for(E element: list) {
			retVal.add(method(element));
		}
		return retVal;
	}
	
	public abstract T method(E input);
}