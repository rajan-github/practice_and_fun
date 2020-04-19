package arrays;

/**
 * Given an array of n distinct integers sorted in ascending order, write a
 * function that returns a Fixed Point in the array, if there is any Fixed Point
 * present in array, else returns -1. Fixed Point in an array is an index i such
 * that arr[i] is equal to i. Note that integers in array can be negative.
 * 
 * @author rajan-c
 *
 */
public class FixedPoint {
	public static int fixedPointLinearSearch(int[] nums) {
		int fixedPoint = -1;
		if (nums != null && nums.length > 0) {
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] == i) {
					fixedPoint = i;
					break;
				}
			}
		}
		return fixedPoint;
	}

	public static int fixedPointBinarySearch(int[] nums) {
		int fixedPoint = -1;
		if (nums != null && nums.length > 0) {
			int start = 0, end = nums.length - 1;
			while (start <= end) {
				int middle = (start + end) / 2;
				if (nums[middle] == middle) {
					fixedPoint = middle;
					break;
				} else if (nums[middle] < middle)
					start = middle + 1;
				else
					end = middle - 1;
			}
		}
		return fixedPoint;
	}

	public static void main(String[] args) {
		System.out.println(fixedPointBinarySearch(new int[] { -3, -2, -1, 3 }));
		System.out.println(fixedPointBinarySearch(new int[] { -3, -2, -1, 3 }));
		System.out.println(fixedPointBinarySearch(new int[] { -10, -1, 0, 3, 10, 11, 30, 50, 100 }));
	}
}
