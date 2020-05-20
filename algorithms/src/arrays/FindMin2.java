package arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * The array may contain duplicates.
 * 
 * @author rajan-c
 *
 */
public class FindMin2 {
	public static int findMin(int[] nums) {
		if (nums[0] < nums[nums.length - 1])
			return nums[0];
		return findMin(nums, 0, nums.length - 1);
	}

	private static int findMin(int[] nums, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			if ((middle > 0 && nums[middle - 1] > nums[middle]))
				return nums[middle];
			else if ((nums[middle] >= nums[nums.length - 1] && middle < (nums.length - 1)
					&& nums[middle + 1] < nums[middle]) || (nums[middle] > nums[nums.length - 1]))
				return findMin(nums, middle + 1, right);
			else if (nums[middle] < nums[nums.length - 1])
				return findMin(nums, left, middle - 1);
			else
				return Math.min(findMin(nums, left, middle), findMin(nums, middle + 1, right));
		}
		return nums[left];
	}

	private static int min(int[] nums) {
		int min = nums[0];
		for (int i = 1; i < nums.length; i++)
			if (nums[i] < min)
				min = nums[i];
		return min;
	}

	public static void main(String[] args) {
		System.out.println(findMin(new int[] { 2, 2, 2, 0, 1 }) == min(new int[] { 2, 2, 2, 0, 1 }));
		System.out.println(findMin(new int[] { 3, 4, 5, 1, 2 }) == min(new int[] { 3, 4, 5, 1, 2 }));
		System.out.println(findMin(new int[] { 1, 1, 1, 1, 1 }) == min(new int[] { 1, 1, 1, 1, 1 }));
		System.out.println(findMin(new int[] { 1, 2, 3, 4, 5 }) == min(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(findMin(new int[] { 2, 3, 4, 4, 5, 0, 0, 1 }) == min(new int[] { 2, 3, 4, 4, 5, 0, 0, 1 }));
		System.out.println(findMin(new int[] { 2, 3, 4, 4, 5, 0, 0, 0 }) == min(new int[] { 2, 3, 4, 4, 5, 0, 0, 0 }));
		System.out.println(findMin(new int[] { 2, 2, 2, 2, 2, 3, 3, 3 }) == min(new int[] { 2, 2, 2, 2, 2, 3, 3, 3 }));
		System.out.println(findMin(new int[] { 3, 1 }) == min(new int[] { 3, 1 }));
		System.out.println(findMin(new int[] { 3, 3, 1, 3 }) == min(new int[] { 3, 3, 1, 3 }));
		System.out.println(findMin(new int[] { 10, 1, 10, 10, 10 }) == min(new int[] { 10, 1, 10, 10, 10 }));
		System.out.println(findMin(new int[] { 0, 1, 10, 10, 10 }) == min(new int[] { 0, 1, 10, 10, 10 }));
		System.out.println(findMin(new int[] { 3, 3, 3, 3, 1 }) == min(new int[] { 3, 3, 3, 3, 1 }));
		System.out.println(findMin(new int[] { 3, 1, 3, 3, 3, 3, 3, 3 }) == min(new int[] { 3, 1, 3, 3, 3, 3, 3, 3 }));
		System.out.println(
				findMin(new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 1, 3 }) == min(new int[] { 3, 3, 3, 3, 3, 3, 3, 3, 1, 3 }));
	}
}
