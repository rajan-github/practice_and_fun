package arrays;

import auxiliaryMethods.CommonMethods;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * 
 * You must do this in-place without making a copy of the array. Minimize the
 * total number of operations.
 * 
 * @author rajan-c
 *
 */
public class MoveZeros {
	public static void moveZeroes(int[] nums) {
		for (int i = 0, j = -1; i < nums.length && j < nums.length; i++) {
			if (nums[i] != 0)
				swap(nums, i, ++j);
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1, 0, 3, 12 };
		moveZeroes(nums);
		CommonMethods.display(nums);
	}
}
