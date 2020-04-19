package arrays;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * [-2,1,-3,4,-1,2,1,-5,4], Sum is 6.
 * 
 * @author rajan-c
 *
 */
public class MaximumSubarray {
	public static int maxSubArray(int[] nums) {
		int maxSum = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] > sum && sum < 0) {
				sum = nums[i];
			} else
				sum += nums[i];
			if (sum > maxSum)
				maxSum = sum;
		}

		if (sum > maxSum)
			maxSum = sum;
		return maxSum;
	};

	public static int maxSubArray(int[] nums, int left, int right) {
		if (left <= right) {
//			int middle = (left + right) / 2;
//			int 
		}
		return 0;
	}

	public static void main(String[] args) {
		int[] nums = { -2, -2, 3, -1, 5, -2, 4, -1, 6 };
		System.out.println(maxSubArray(nums));

		nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
	}
}
