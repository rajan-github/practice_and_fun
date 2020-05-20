package dynamicProgramming.practice;

/**
 * Given an integer array nums, find the contiguous subarray within an array
 * (containing at least one number) which has the largest product. Input:
 * [2,3,-2,4] Output: 6 Explanation: [2,3] has the largest product 6.
 * 
 * Input: [-2,0,-1] Output: 0 Explanation: The result cannot be 2, because
 * [-2,-1] is not a subarray.
 * 
 * @author rajan-c
 *
 */
public class MaximumProductSubarray {
	public static int maxProduct(int[] nums) {
		int max = Integer.MIN_VALUE;
		int[][] memory = new int[nums.length][nums.length];

		for (int sequenceLength = 0; sequenceLength < nums.length; sequenceLength++) {
			for (int row = 0; row < (nums.length - sequenceLength); row++) {
				int col = row + sequenceLength > nums.length ? nums.length - 1 : row + sequenceLength;
				if (row == col) {
					memory[row][col] = nums[row];
				} else if (row < nums.length - 1)
					memory[row][col] = memory[row][col - 1] * memory[col][col];
				if (memory[row][col] > max)
					max = memory[row][col];
			}
		}
		return max;
	}

	public static int maxProduct2(int[] nums) {
		int max = Integer.MIN_VALUE;
		int[] memory = new int[nums.length];
		for (int sequenceLength = 0; sequenceLength < nums.length; sequenceLength++) {
			int memoryLength = nums.length - sequenceLength;
			for (int i = 0; i < memoryLength; i++) {
				int next = i + sequenceLength;
				if (next == i)
					memory[i] = nums[next];
				else
					memory[i] = memory[i] * nums[next];
				if (memory[i] > max)
					max = memory[i];
			}
		}
		return max;
	}

	public static void main(String[] args) {
		System.out.println(maxProduct(new int[] { 2, 3, -2, 4 }));
		System.out.println(maxProduct2(new int[] { 2, 3, -2, 4 }));
	}
}