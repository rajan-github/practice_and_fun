package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given an array of integers nums and an integer limit, return the size of the
 * longest continuous subarray such that the absolute difference between any two
 * elements is less than or equal to limit.
 * 
 * In case there is no subarray satisfying the given condition return 0.
 * 
 * @author rajan-c
 *
 */
public class AbsoluteDiffLessThanLimit {
	public static int longestSubarray(int[] nums, int limit) {
		int length = nums.length, subSize = 0;

		List<?>[][] diff = new List<?>[nums.length][nums.length];
		for (int l = 0; l < nums.length; l++) {
			for (int row = 0; row < nums.length; row++) {
				int col = row + l;
				if (row == col) {
					diff[row][col] = largestDiff(row, col, nums);
				} else {
					List<?> previous = diff[row][col - 1];
					if (previous != null) {
						if (nums[col] < (int) previous.get(0)) {
//							previous.add(0, nums[col]);
						}

					}
				}
			}
		}
		return subSize;
	}

	private static List<Integer> largestDiff(int i, int j, int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for (int index = i; index <= j; index++) {
			int item = Math.abs(nums[index]);
			if (item < min)
				min = item;
			if (nums[index] > max)
				max = item;
		}
		List<Integer> maxMin = new ArrayList<>();
		maxMin.add(min);
		maxMin.add(max);
		return maxMin;
	}

	public static void main(String[] args) {
		int nums[] = new int[] { 4, 2, 2, 2, 4, 4, 2, 2 };
		System.out.println(longestSubarray(nums, 0));
	}
}
