package sorting;

public class Sort {
	private static int[] array = { 6, 5, 3, 1, 8, 7, 2, 4 };

	public static void main(String[] args) {
		System.out.println("Original: ");
		printArr(array);
		System.out.println("Bubble:");
		printArr(bubbleSort(array));
		System.out.println("Insertion:");
		printArr(insertionSort(array));
		System.out.println("Selection:");
		printArr(selectionSort(array));
	}

	public static int[] bubbleSort(int[] array) {
		// return array
		int[] sorted = array.clone();
		// number of iterations for optimization purposes
		int n = 1;
		// if a swap has occurred and must rerun code
		boolean swap = true;

		while (swap) {
			swap = false;
			for (int i = 0; i < sorted.length - n; i++) {
				if (sorted[i] > sorted[i + 1]) {
					swap = true;
					swap(sorted, i, i + 1);
				}
			}
		}
		return sorted;
	}

	public static int[] insertionSort(int[] array) {
		int[] sorted = new int[array.length];
		sorted[0] = array[0];
		for(int i=0; i<sorted.length; i++) {
			int insert = array[i];
			int k=i;
			
			while(sorted[k] > insert) {
				sorted[k] = sorted[k-1];
				k--;
			}
			sorted[k] = insert;
		}
		return sorted;
	}

	public static int[] selectionSort(int[] array) {
		int[] sorted = array.clone();
		for (int i = 0; i < sorted.length; i++) {

		}
		return sorted;
	}

	private static int[] swap(int[] arr, int i, int f) {
		int temp = arr[i];
		arr[i] = arr[f];
		arr[f] = temp;
		return arr;
	}

	public static void printArr(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("");
	}
}
