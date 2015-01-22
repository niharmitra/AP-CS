package vocab;
/*
 * Public Interface: The public interface of this class is all the public methods it has
 * There are no public variables
 * Interface: This class meets the interface "Interface" 
 * Encapsulation: The printAll method is encapsulated into multiple print methods
 * Invariant: The sum of the integers is an invariant
 */
public class Vocab3 implements Interface {
	private int a = 1;
	private int b = 2;
	private int c = 3;
	
	private String A = "a";
	private String B = "b";
	private String C = "c";
	
	public static void main(String[] main) {
		Vocab3 test = new Vocab3();
		test.printAll();
		test.swapRandomNums();
		test.printAll();
	}
	
	@Override
	public void printAll() {
		//Encapsulates the printing methods into other methods
		printNums();
		printSum();
		printStrings();
	}
	
	//The sum is an invariant
	private void printSum() {
		System.out.println(a+b+c);
	}

	@Override
	//Swaps two values of the integer variables, but sum remains invariant
	public void swapRandomNums() {
		double rand = Math.random();
		int temp;
		if(rand < 1/3) {
			temp = a;
			a = b;
			b = temp;
			return;
		}
		else if(rand < 2/3) {
			temp = b;
			b = c;
			c = temp;
		}
		else {
			temp = a;
			a = c;
			c = temp;
		}
	}
	
	//Encapsulated code for printing the variables
	private void printNums() {
		System.out.println(a+","+b+","+c);
	}
	
	private void printStrings() {
		System.out.println(A+","+B+","+C);
	}

}
