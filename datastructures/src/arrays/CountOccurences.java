package arrays;

/**
 * Count the #of occurrences of the given number in O(log(n)) time in sorted array.
 * 
 * @author rajan-c
 *
 */
public class CountOccurences {
	public int countOccurences(int[] array, int k) {
		int firstIndex = findFirst(array, 0, array.length - 1, k);
		int lastIndex = findLast(array, 0, array.length - 1, k);
		if (firstIndex >= 0) {
			return lastIndex - firstIndex + 1;
		}
		return 0;
	}

	private int findFirst(int[] array, int start, int end, int key) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if ((middle == 0 || array[middle - 1] < key) && array[middle] == key)
				return middle;
			else if (array[middle] >= key)
				return findFirst(array, start, middle - 1, key);
			else
				return findFirst(array, middle + 1, end, key);
		}
		return -1;
	}

	private int findLast(int[] array, int start, int end, int key) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if ((middle == end || array[middle + 1] > key) && array[middle] == key)
				return middle;
			else if (array[middle] > key)
				return findLast(array, start, middle - 1, key);
			else
				return findLast(array, middle + 1, end, key);
		}
		return -1;
	}

	public static void main(String[] args) {
		CountOccurences co = new CountOccurences();
		System.out.println(co.countOccurences(new int[] { 0, 1, 1, 1, 1, 2, 3, 4, 5, 5 }, 1));
		System.out.println(co.countOccurences(new int[] { 0, 1, 1, 1, 1, 2, 3, 4, 5, 5 }, 5));
		System.out.println(co.countOccurences(new int[] { 0, 1, 1, 1, 1, 2, 3, 4, 5, 5 }, 2));
		System.out.println(co.countOccurences(new int[] { 0, 1, 1, 1, 1, 2, 3, 4, 5, 5 }, 0));
	}
}
