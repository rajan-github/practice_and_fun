package arrays;

/**
 * Given an array of integers and an integer k, you need to find the total
 * number of continuous subarrays whose sum equals to k.
 * 
 * @author rajan-c
 *
 */
public class CountSubsetsWithSum {
	public static int subarraySum(int[] nums, int k) {
		long[] prefixSum = new long[nums.length + 1];
		for (int i = 1; i <= nums.length; i++)
			prefixSum[i] = prefixSum[i - 1] + nums[i - 1];

		int count = 0;

		for (int i = 1; i < prefixSum.length; i++) {
			for (int j = i; j < prefixSum.length; j++) {
				if (prefixSum[j] - prefixSum[i - 1] == k)
					count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 1, 1, 1 };
		System.out.println(subarraySum(nums, 2));
	}
}
