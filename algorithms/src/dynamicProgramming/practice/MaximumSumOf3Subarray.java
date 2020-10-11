package dynamicProgramming.practice;

import java.util.Arrays;

/**
 * This implementation is wrong and incomplete.
 * 
 * @author rajan-c
 *
 */
public class MaximumSumOf3Subarray {
	public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
		int[][] memory = new int[nums.length][nums.length];
		for (int length = 1; length <= k; length++) {
			for (int i = 0; i <= nums.length - length; i++) {
				int j = i + length - 1;
				if (i == j)
					memory[i][j] = nums[i];
				else {
					memory[i][j] = memory[i][j - 1] + nums[j];
				}
			}
		}
		int[] subarraySum = new int[nums.length - k + 1];
		for (int i = 0; i <= nums.length - k; i++)
			subarraySum[i] = memory[i][i + k - 1];

		return maximumThreeSum(subarraySum, k, new int[3], 0, 0);
	}

	private int[] maximumThreeSum(int[] array, int difference, int[] maxItems, int index, int maxIndex) {
		if (maxIndex == 3)
			return new int[] { maxItems[0], maxItems[1], maxItems[2] };
		else if (index >= array.length)
			return null;
		int[] maximumIndexes = null;
		for (int i = index; i < array.length; i++) {
			int[] indexes = maximumThreeSum(array, difference, maxItems, index + 1, maxIndex);
			if (sum(array, indexes) > sum(array, maximumIndexes))
				maximumIndexes = indexes;
			int temp = maxItems[maxIndex];
			maxItems[maxIndex] = index;
			indexes = maximumThreeSum(array, difference, maxItems, index + difference, maxIndex + 1);
			maxItems[maxIndex] = temp;
			if (sum(array, indexes) > sum(array, maximumIndexes))
				maximumIndexes = indexes;
		}
		return maximumIndexes;
	}

	private int sum(int[] data, int[] indexes) {
		if (indexes == null)
			return Integer.MIN_VALUE;
		int sum = 0;
		for (int index : indexes)
			sum += data[index];
		return sum;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2, 1, 2, 6, 7, 5, 1 };
		MaximumSumOf3Subarray p = new MaximumSumOf3Subarray();
		int k = 2;
		int[] indexes = p.maxSumOfThreeSubarrays(nums, k);
		System.out.println(Arrays.toString(indexes));
	}
}
