package search;

public class ExponentialSearch {

	public static int exponentialSearch(int[] array, int length, int key) {
		int index = -1, i = 1;
		while (i < length && array[i] < key)
			i *= 2;
		index = BinarySearch.binarySearch(array, i / 2, Math.min(length, i), key);
		return index;
	}

	public static void main(String[] args) {
		int index = exponentialSearch(new int[] { 1, 2, 3, 4, 4, 5, 5 }, 6, 5);
		System.out.printf("Found at indes: %d", index);
	}
}
