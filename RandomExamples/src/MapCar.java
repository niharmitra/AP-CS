import java.util.*;
import java.util.concurrent.Callable;


public class MapCar {

	public static void main(String[] args) {
		
	}
	
	public <V, E> Collection<V> mapcar(Collection<E> list, Callable<V> method) {
		Collection<V> retVal = null;
		try {
			retVal = (Collection<V>)list.getClass().newInstance();
			for(E elephant : list) {
				try {
					retVal.add(method.call());
				} catch (Exception e) {
					System.out.println("Couldn't call method qq");
					e.printStackTrace();
				}
			}
			return retVal;
		} catch (InstantiationException | IllegalAccessException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return retVal;
	}
	
	
}