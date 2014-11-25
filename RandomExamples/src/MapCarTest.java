import java.util.*;


public class MapCarTest extends MapCar<Integer, Integer> {
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		MapCarTest test = new MapCarTest();
		for(Integer element: test.mapcar(list)) {
			System.out.println(element);
		}
	}
	//Adds 1 to each element
	@Override
	public Integer method(Integer input) {
		return input + 1;
	}

}
