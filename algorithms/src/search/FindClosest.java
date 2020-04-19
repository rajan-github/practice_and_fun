package search;

public class FindClosest {
	/**
	 * Sorted array and find the key or closest to the key.
	 * 
	 * @param array
	 * @param key
	 * @return
	 */
	public static int findClosest(int[] array, int key, int start, int end) {
		if (end >= start) {
			int middle = (start + end) / 2;
			if (array[middle] == key)
				return middle;
			else if (middle < end - 1 && array[middle] < key && key < array[middle + 1])
				return middle - 1;
			else if (start == middle && start == end)
				return middle;
			else if (middle - 1 >= start && array[middle] > key && key > array[middle - 1])
				return middle - 1;
			else if (array[middle] > key)
				return findClosest(array, key, start, middle - 1);
			else
				return findClosest(array, key, middle + 1, end);
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findClosest(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 5, 0, 8));
		System.out.println(findClosest(new int[] { 1, 3, 3, 4, 5, 6, 7, 8, 9 }, 10, 0, 8));
		System.out.println(findClosest(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 0, 0, 8));
		System.out.println(findClosest(new int[] { 1, 2, 3, 4, 5, 5, 7, 8, 9 }, 6, 0, 8));
		System.out.println(findClosest(new int[] { 1, 2, 3, 4, 5, 5, 7, 8, 9 }, -1, 0, 8));
		System.out.println(findClosest(new int[] { -9, -8, -7, -6, -5, -4, -3, -2, -1 }, -4, 0, 8));
		System.out.println(findClosest(new int[] { -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 }, -3, 0, 11));

	}
}
