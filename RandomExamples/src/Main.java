
public class Main {
	public static void main(String[] args) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>();
		
		queue.add(1);
		queue.add(2);
		queue.add(5);
		queue.add(3);
		queue.print();
		queue.reverseComparator();
		queue.print();
	}
}
