package search;

public class BinarySearch {

	public static int binarySearch(int[] array, int left, int right, int key) {
		if (left <= right) {
			int middle = (left + right) / 2;
			if (array[middle] == key)
				return middle;
			else if (array[middle] < key)
				return binarySearch(array, middle + 1, right, key);
			else
				return binarySearch(array, left, middle - 1, key);
		} else
			return -1;
	}

	public static void main(String[] args) {
		int index = binarySearch(new int[] { 1, 2, 3, 4, 4, 5, 5 }, 0, 6, -1);
		System.out.printf("Found at indes: %d", index);
	}

}
