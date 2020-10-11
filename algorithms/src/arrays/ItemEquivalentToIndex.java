package arrays;

/**
 * You are given a sorted (from smallest to largest) array A of n distinct
 * integers which can be positive, negative, or zero. You want to decide whether
 * or not there is an index i such that A[i] = i. Design the fastest algorithm
 * that you can for solving this problem.
 * 
 * @author rajan-c
 *
 */
public class ItemEquivalentToIndex {

	public static int search(int[] array) {
		if (array == null || array.length == 0)
			return -1;
		return search(array, 0, array.length - 1);
	}

	private static int search(int[] array, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			if (array[middle] == middle)
				return middle;
			else if (array[middle] < middle)
				return search(array, middle + 1, end);
			return search(array, start, middle - 1);
		} else if (array[start] == start)
			return start;
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(search(new int[] { -2, -1, 0, 1, 2, 5, 6, 7 }));
		System.out.println(search(new int[] { 1, 2, 3, 4, 5, 6, 7 }));
		System.out.println(search(new int[] { 0, 1, 2, 3, 4, 5, 6 }));
	}

}
