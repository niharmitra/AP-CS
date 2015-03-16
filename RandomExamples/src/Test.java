import java.util.ArrayList;

/*
 * Random test programs to see various quirks of Java
 */
public class Test {
	public static void main(String[] args) {
		ArrayList<String> strings = new ArrayList<String>();
		strings.add("Hello");
		strings.add("Goodbye");
		strings.add("Maybe");
		
		for(String e: strings) {
			strings.remove(e);
		}
		System.out.println(strings);
	}
}
