package arrays;

/**
 * Given an integer array nums, find the contiguous sub-array (containing at
 * least one number) which has the largest sum and return its sum.
 * [-2,1,-3,4,-1,2,1,-5,4], Sum is 6.
 * 
 * We have linear time solution using Kadane's algorithm. But here we have
 * implemented divide and conquer solution.
 * 
 * @author rajan-c
 *
 */
public class MaximumSubarray {
	public static int maxSubArray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		return maxSubArray(nums, 0, nums.length - 1);
	};

	private static int maxSubArray(int[] nums, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			int leftSum = maxSubArray(nums, left, middle);
			int rightSum = maxSubArray(nums, middle + 1, right);
			int crossSum = maxSubArrayCross(nums, left, right, middle);
			return max(leftSum, rightSum, crossSum);
		}
		return nums[left];
	}

	private static int maxSubArrayCross(int[] nums, int left, int right, int middle) {
		int sum = 0, leftSumMax = nums[middle], index = middle, rightSumMax = nums[middle + 1];
		while (index >= left) {
			sum += nums[index];
			if (sum > leftSumMax)
				leftSumMax = sum;
			index--;
		}
		index = middle + 1;
		sum = 0;
		while (index <= right) {
			sum += nums[index];
			if (sum > rightSumMax)
				rightSumMax = sum;
			index++;
		}
		return leftSumMax + rightSumMax;
	}

	private static int max(int a, int b, int c) {
		if (a >= b && a >= c)
			return a;
		else if (b >= a && b >= c)
			return b;
		return c;
	}

	public static void main(String[] args) {
		int[] nums = { -2, -2, 3, -1, 5, -2, 4, -1, 6 };
		System.out.println(maxSubArray(nums));

		nums = new int[] { -2, -1 };
		System.out.println(maxSubArray(nums));

		nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(maxSubArray(nums));
	}
}
