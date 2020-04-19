package arrays;

/**
 * Given an integer array nums, find the contiguous subarray (containing at
 * least one number) which has the largest sum and return its sum.
 * 
 * @author rajan-c
 *
 */
public class MaximumSubarray {
	public static int bruteForceMaxSubarray(int[] nums) {
		int max = Integer.MIN_VALUE;
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum = nums[i];
			for (int j = i + 1; j < nums.length; j++) {
				if (sum > max)
					max = sum;
				sum += nums[j];
			}
			if (max < sum)
				max = sum;
		}
		return max;
	}

	public static int maxSubArray(int[] nums) {
		return maxSubArray(nums, 0, nums.length - 1);
	}

	private static int maxSubArray(int[] nums, int left, int right) {
		if (left == right) {
			return nums[left];
		} else {
			int middle = (left + right) / 2;
			int leftMax = maxSubArray(nums, left, middle);
			int rightMax = maxSubArray(nums, middle + 1, right);
			int middleMax = middleMax(nums, left, right, middle);
			return max(leftMax, rightMax, middleMax);
		}
	}

	private static int max(int a, int b, int c) {
		if (a >= b && a >= c)
			return a;
		else if (b >= c && b >= a)
			return b;
		return c;
	}

	private static int middleMax(int[] nums, int left, int right, int middle) {
		int leftMax = Integer.MIN_VALUE;
		int l = middle - 1;
		int r = middle;
		int sum = 0;
		while (l >= left) {
			sum += nums[l];
			if (sum > leftMax)
				leftMax = sum;
			l--;
		}

		int rightMax = Integer.MIN_VALUE, rightSum = 0;
		while (r <= right) {
			rightSum += nums[r++];
			if (rightSum > rightMax)
				rightMax = rightSum;
		}

		int max;
		if (rightMax >= 0 && leftMax >= 0)
			max = rightMax + leftMax;
		else if (rightMax < 0 && leftMax < 0)
			max = Math.max(rightMax, leftMax);
		else if (rightMax < 0)
			max = leftMax;
		else
			max = rightMax;
		return max;
	}

	public static int maxSubArrayLinear(int[] nums) {
		int max = nums[0];
		int sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			if (sum + nums[i] < nums[i]) {
				sum = nums[i];
			} else {
				sum += nums[i];
			}
			if (sum > max)
				max = sum;
		}
		if (sum > max)
			max = sum;
		return max;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { -12, -13, -4, -5 };
		System.out.println(bruteForceMaxSubarray(nums) == maxSubArrayLinear(nums));
		nums = new int[] { 1 };
		System.out.println(bruteForceMaxSubarray(nums) == maxSubArrayLinear(nums));
		nums = new int[] { 1, 2, 3, 4, 5, 6 };
		System.out.println(bruteForceMaxSubarray(nums) == maxSubArrayLinear(nums));
		nums = new int[] { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(bruteForceMaxSubarray(nums) == maxSubArrayLinear(nums));
		nums = new int[] { 1, 2, -4 };
		System.out.println(bruteForceMaxSubarray(nums) == maxSubArrayLinear(nums));
		nums = new int[] { -4, -2, -1, 0 };
		System.out.println(bruteForceMaxSubarray(nums) == maxSubArrayLinear(nums));

		nums = new int[] { -4, -2, -1 };
		System.out.println(bruteForceMaxSubarray(nums) == maxSubArrayLinear(nums));

		nums = new int[] { -1, -2 };
		System.out.println(bruteForceMaxSubarray(nums) == maxSubArrayLinear(nums));
		System.out.println(maxSubArrayLinear(nums));

		nums = new int[] { 13, -3, -25, 20, -3, -16, -23, 18, 20, -7, 12, -5, -22, 15, -4, 7 };
		System.out.println(bruteForceMaxSubarray(nums) == maxSubArrayLinear(nums));

	}
}
