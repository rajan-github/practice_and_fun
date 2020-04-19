package search;

/**
 * Perform binary search on the rotated array.
 * @author rajan-c
 *
 */
public class SearchOnRotatedArray {

	public static int searchInRotatedArray(int[] array, int key) {
		int pivot = findPivot(array, 0, array.length - 1);
		if (pivot < 0)
			return binarySearch(array, key, 0, array.length - 1);
		else {
			int leftIndex = binarySearch(array, key, 0, pivot);
			return leftIndex >= 0 ? leftIndex : binarySearch(array, key, pivot + 1, array.length - 1);
		}
	}

	private static int binarySearch(int[] array, int key, int left, int right) {
		if (left <= right) {
			int middle = (left + right) / 2;
			if (array[middle] == key)
				return middle;
			else if (array[middle] > key)
				return binarySearch(array, key, left, middle - 1);
			else
				return binarySearch(array, key, middle + 1, right);
		}
		return -1;
	}

	private static int findPivot(int[] array, int left, int right) {
		if (left <= right) {
			int middle = (left + right) / 2;

			if (middle < array.length - 1 && array[middle] > array[middle + 1])
				return middle;
			else if (array[middle] > array[array.length - 1])
				return findPivot(array, middle + 1, right);
			else
				return findPivot(array, left, middle - 1);
		}
		return -1;
	}

	public static void main(String[] array) {
		System.out.println(searchInRotatedArray(new int[] { 7, 8, 9, 10 }, 3));
		System.out.println(searchInRotatedArray(new int[] { 7, 8, 9, 10 }, 10));
		System.out.println(searchInRotatedArray(new int[] { 7, 8, 9, 10 }, 7));
		System.out.println(searchInRotatedArray(new int[] { 7, 8, 9, 10, 1, 2, 3, 4, 5, 6 }, 3));
	}
}
