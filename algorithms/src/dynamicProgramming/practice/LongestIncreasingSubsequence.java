package dynamicProgramming.practice;

/**
 * Given an unsorted array of integers, find the length of longest increasing
 * subsequence.Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest
 * increasing subsequence is [2,3,7,101], therefore the length is 4.
 * 
 * @author rajan-c
 *
 */
public class LongestIncreasingSubsequence {
	public static int lengthOfLIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] memory = new int[nums.length];
		for (int i = 0; i < nums.length; i++)
			memory[i] = 1;

		int maxLength = 1;
		for (int i = 1; i < nums.length; i++) {
			int j = i - 1;
			while (j >= 0) {
				if (nums[j] < nums[i])
					memory[i] = Math.max(memory[j] + 1, memory[i]);
				if (memory[i] > maxLength)
					maxLength = memory[i];
				j--;
			}
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
		System.out.println(lengthOfLIS(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(lengthOfLIS(new int[] { 5, 4, 3, 2, 1 }));
	}

}
