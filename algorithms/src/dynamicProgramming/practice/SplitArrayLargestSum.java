package dynamicProgramming.practice;

import auxiliaryMethods.CommonMethods;

public class SplitArrayLargestSum {
	public static int splitArray(int[] nums, int m) {
		if (nums == null || m > nums.length)
			return -1;
		int[] prefixSum = new int[nums.length];
		prefixSum[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
			prefixSum[i] = nums[i] + prefixSum[i - 1];
		int[][] memory = new int[m + 1][nums.length];
		for (int part = 1; part <= m; part++) {
			for (int col = 0; col < memory[0].length; col++)
				if (part == 1)
					memory[part][col] = prefixSum[col];
				else
					memory[part][col] = -1;
		}
		return splitArray(nums, m, 0, prefixSum, memory);
//		return splitArray(nums, m, prefixSum);
	}

	public static int splitArray(int[] nums, int m, int startIndex, int[] prefixSum, int[][] memory) {
		if (m > 1) {
			if (memory[m][startIndex] >= 0)
				return memory[m][startIndex];
			int maxSum = Integer.MAX_VALUE;
			for (int index = startIndex + 1; index <= nums.length - m + 1; index++) {
				int maxSumOfSplit = splitArray(nums, m - 1, index, prefixSum, memory);
				maxSum = Math.min(maxSum, Math.max(maxSumOfSplit,
						startIndex > 0 ? prefixSum[index - 1] - prefixSum[startIndex - 1] : prefixSum[index - 1]));
			}
			memory[m][startIndex] = maxSum;
			return maxSum;
		}
		return startIndex > 0 ? prefixSum[nums.length - 1] - prefixSum[startIndex - 1] : prefixSum[nums.length - 1];
	}

	/**
	 * TODO: to be completed.
	 * 
	 * @param nums
	 * @param m
	 * @param prefixSum
	 * @return
	 */
	public static int splitArray(int[] nums, int m, int[] prefixSum) {
		if (m > 1) {
			int[][] memory = new int[m + 1][nums.length];
			for (int part = 1; part <= m; part++) {
				for (int col = 0; col < memory[0].length; col++)
					if (part == 1)
						memory[part][col] = (col == 0) ? prefixSum[nums.length - 1]
								: prefixSum[nums.length - 1] - prefixSum[col - 1];
					else
						memory[part][col] = -1;
			}

			for (int part = 2; part <= m; part++) {
				int maxSum = Integer.MAX_VALUE;
				for (int index = nums.length - part; index >= 1; index--) {
					int maxSumOfSplit = memory[part - 1][index];
					maxSum = Math.max(maxSumOfSplit, prefixSum[index - 1]);
					memory[part][index] = maxSum;
				}
			}
			CommonMethods.display(memory);
			int minPart = Integer.MAX_VALUE;
			for (int i = 1; i < memory[0].length; i++)
				minPart = Math.min(minPart, memory[m][i]);
			return minPart;
		}
		return prefixSum[nums.length - 1];
	}

	public static void main(String[] args) {
//		System.out.println(splitArray(new int[] { 7, 2, 5, 10, 8 }, 2));
		System.out.println(splitArray(new int[] { 7, 2, 5, 10, 8 }, 3));
//		System.out.println(splitArray(new int[] { 10, 8 }, 2));
//		System.out.println(splitArray(new int[] { 2, 2, 2 }, 2));
	}
}
