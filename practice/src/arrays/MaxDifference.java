package arrays;

/**
 * Given an array arr[] of integers, find out the maximum difference between any
 * two elements such that larger element appears after the smaller number.
 * 
 * @author rajan-c
 *
 */
public class MaxDifference {
	public static int maxDifference(int[] array) {
		int diff = array[1] - array[0];
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			diff = Math.max(array[i] - min, diff);
			min = Math.min(min, array[i]);
		}
		return diff;
	}

	public static int maxDifference1(int[] array) {
		int diff = array[array.length - 1] - array[array.length - 2];
		int max = array[array.length - 1];
		for (int i = array.length - 2; i >= 0; i--) {
			max = Math.max(max, array[i]);
			diff = Math.max(diff, max - array[i]);
		}
		return diff;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 2, 3, 10, 6, 4, 8, 1 };
		System.out.println(maxDifference(array) == maxDifference1(array));
		array = new int[] { 1, 3, -1, -3, 5, 3, 6, 7 };
		System.out.println(maxDifference(array) == maxDifference1(array));
	}
}
