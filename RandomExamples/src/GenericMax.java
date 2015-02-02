import java.util.*;

public class GenericMax {
	public static void main(String[] args) {
		//Creates an arraylist for testing
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(5);
		list.add(3);
		list.add(6);
		list.add(4);
		
		//Prints out the result of the generic max function
		System.out.println(max(list));
	}
	
	//A function that finds the max of any collection so long as the type contained in the collection
	//Is comparable
	public static <E extends Comparable<E>> E max(Collection<E> collection) {
		Iterator<E> iter = collection.iterator();
		E currentMax = iter.next();

		while(iter.hasNext()) {
			//Next value from the iterator (since each call of iter.next() automatically moves it down the list)
			E nextVal = iter.next();
			//If the current max is less than the next element in the array, replace it, otherwise keep it the same
			currentMax = (currentMax.compareTo(nextVal) < 0) ? nextVal : currentMax;
		}
		return currentMax;
	}
}
