package arrays;

/**
 * Find minimum in the rotated sorted array. You may assume that array doesn't
 * have duplicate elements.
 * 
 * @author rajan-c
 *
 */
public class FindMin {
	public static int findMin(int[] nums) {
		if (nums.length == 1 || nums[0] < nums[nums.length - 1])
			return nums[0];
		return search(nums, 0, nums.length - 1);
	}

	private static int search(int[] nums, int start, int end) {
		if (start >= 0 && start < end) {
			int middle = (start + end) / 2;
			if (middle < nums.length - 1 && nums[middle + 1] < nums[middle])
				return nums[middle + 1];
			else if (nums[0] < nums[middle])
				return search(nums, middle + 1, end);
			else
				return search(nums, start, end - 1);
		}
		return nums[start];
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2 };
		System.out.println(findMin(nums));
	}
}
