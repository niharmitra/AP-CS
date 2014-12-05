import sorting.Sort;

/*
 * Uses quicksort to find the median of an int[]
 * Is faster than quicksort
 * Original quicksort implementation from java2novice.com
 */
public class medianFinder {
	private boolean firstSort = false;
	private boolean secondSort = false;

	public static void main(String[] args) {
		medianFinder sorter = new medianFinder();
		int[] input = { 24, 2, 45, 20, 56, 75, 2, 56, 99, 53, 12, 10};
		Sort.printArr(Sort.insertionSort(input));
		System.out.println(sorter.findMedian(input));
	}

	private int[] array;
	private int length;
	/**
	 * The algorithm uses modified quicksort in order to find the median
	 * This leaves the extremities of the array unsorted, which is irrelevant to the median
	 * After it partitions the array, it sorts the middle 2 quartiles, and then returns the median
	 * @param inputArr Input array to find the median of
	 * @return median of the data
	 * @see partition()
	 */
	public double findMedian(int[] inputArr) {
		if (inputArr == null || inputArr.length == 0) {
			return -1;
		}
		array = inputArr;
		length = inputArr.length-1;
		//Array is sorted relative to middle index (for all i > middle, array[i] > all array[j] for j<middle
		partition();
		int quarterOne = length/4;
		int quarterThree = length - length/4 - 1;
		int middle = length/2;
		quickSort(quarterOne, quarterThree);
		
		//Note that length is actually gives the wrong modulo because it is -1
		//If odd, the middle value is the median
		if(length%2 == 0) {
			return array[middle];
		}
		//Average the two middle values (Java rounds down so middle+1)
		else { 
			return (array[middle]+array[middle+1])/2d;
		}
	}

	/**
	 * Organizes the array so that it is sorted relative to the middle
	 * Thus all the lowest values are in the first half of the array
	 */
	private void partition() {
		int i = 0;
		int j = array.length - 1;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[(array.length - 1) / 2];
		// Divide into two arrays
		while (i <= j) {
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				// move index to next position on both sides
				i++;
				j--;
			}
		}
	}

	private void quickSort(int lowerIndex, int higherIndex) {
		int i = lowerIndex;
		int j = higherIndex;
		// calculate pivot number, I am taking pivot as middle index number
		int pivot = array[lowerIndex + (higherIndex - lowerIndex) / 2];
		// Divide into two arrays
		while (i <= j) {
			/**
			 * In each iteration, we will identify a number from left side which
			 * is greater then the pivot value, and also we will identify a
			 * number from right side which is less then the pivot value. Once
			 * the search is done, then we exchange both numbers.
			 */
			while (array[i] < pivot) {
				i++;
			}
			while (array[j] > pivot) {
				j--;
			}
			if (i <= j) {
				exchangeNumbers(i, j);
				// move index to next position on both sides
				i++;
				j--;
			}
		}
		// call quickSort() method recursively
		if (lowerIndex < j)
			quickSort(lowerIndex, j);
		if (i < higherIndex)
			quickSort(i, higherIndex);
	}

	private void exchangeNumbers(int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}