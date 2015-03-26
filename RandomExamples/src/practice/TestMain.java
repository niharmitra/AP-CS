package practice;

public class TestMain {
	public static void main(String[] args) {
		System.out.println(fibonacci(0, 3, 4));
	}
	public static int fibonacci(int prev, int a, int b) {
		if(prev==0) {
			return a;
		}
		if(prev==1) {
			return b;
		}
		else {
			return fibonacci(a+b, a-1, a);
		}
	}
}
