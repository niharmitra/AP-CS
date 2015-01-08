import java.util.*;

public class PriorityQueue<E extends Comparable> {
	private ArrayList<E> queue = new ArrayList<E>();

	// O(1)
	public int size() {
		return queue.size();
	}

	// O(ln n) adds an element at the correct point
	public boolean add(E c) {
		for(int i = 0; i< queue.size(); i++) {
			//don't add duplicate elements
			if(queue.get(i).compareTo(c) == 0) {
				return false;
			}
			else if(queue.get(i).compareTo(c)<0) {
				queue.add(i, c);
				return true;
			}
		}
		return false;
	}

	public PriorityQueue() {

	}

	// O(n)
	public boolean remove(E o) {
		if (queue.remove(o)) {
			return true;
		}
		return false;
	}

	// O(ln n). Returns the top value, and removes it from the queue
	public E poll() {
		E retval = this.peek();
		queue.remove(0);
		return retval;
	}

	// O(n) clear all elements in the queue
	public void clear() {
		queue.clear();
	}

	// O(n)
	public void reverseComparator() {
		
	}

	// O(n)
	public boolean contains(E c) {
		return false;
	}

	// O(ln n), returns the top value but doesn't remove it
	public E peek() {
		if (queue.size() == 0) {
			return null;
		}
		return queue.get(0);
	}

	// Merges a second queue to this one
	public void merge(PriorityQueue qq) {

	}
}
