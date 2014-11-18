package sorting;

public class Sort {
	private static int[] array = {6, 5, 3, 1, 8, 7, 2, 4 };

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
		//Keep inserting a term until each term is inserted
		for (int i = 0; i < sorted.length; i++) {
			int insert = array[i];
			int j;
			//Shifts all terms forward to make space
			for(j=i-1; j>=0 && insert < sorted[j]; j--) {
				sorted[j+1] = sorted[j];
			}
			sorted[j+1] = insert;
		}
		return sorted;
	}
	
	//Iterate through the array and keep adding the minimum value to the front of the list so that the first x terms are sorted
	public static int[] selectionSort(int[] array) {
		int[] sorted = array.clone();
		//for each element in the array, find minimum and swap it with the first element
		for(int i=0; i<sorted.length-1; i++) {
			//minimum value
			int min = array[i];
			//index of minimum value
			int minIndex = i;
			
			for(int j = i+1; j < sorted.length; j++) {
				if(sorted[j] < min) {
					minIndex = j;
					min = sorted[j];
				}
			}
			
			//If a lower minimum has been found, swap with current index
			if(minIndex != i) {
				sorted[minIndex] = sorted[i];
				sorted[i] = min;
			}
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
