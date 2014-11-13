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
		int[] sorted = new int[array.length];
		sorted = array;
		// number of iterations for optimization purposes
		int n = 1;
		//if a swap has occurred and must rerun code
		boolean swap = true;

		while (swap) {
			swap = false;
			for(int i = 0; i < sorted.length - n; i++) {
				if(sorted[i] > sorted[i+1]) {
					swap = true;
					int temp = sorted[i];
					sorted[i] = sorted[i+1];
					sorted[i+1] = temp;
				}
			}
		}
		return sorted;
	}

	public static int[] insertionSort(int[] array) {
		int[] sorted = new int[array.length];
		sorted = array;
		return sorted;
	}

	public static int[] selectionSort(int[] array) {
		int[] sorted = new int[array.length];
		sorted = array;
		return sorted;
	}

	public static void printArr(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]+" ");
		}
	}
}
