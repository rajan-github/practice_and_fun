package arrays;

/**
 * Given an array of integers which is initially increasing and then decreasing,
 * find the maximum value in the array.
 * 
 * @author rajan-c
 *
 */
public class MaxElement {

	public static int findMax(int[] nums) {
		if (nums != null && nums.length > 0) {
			int descendingPoint = findDescendingPoint(nums, 0, nums.length - 1);
			if (descendingPoint < 0) {
				if (nums[0] <= nums[nums.length - 1]) {
					return nums[nums.length - 1];
				} else {
					return nums[0];
				}
			} else {
				return nums[descendingPoint - 1] >= nums[descendingPoint] ? nums[descendingPoint - 1]
						: nums[descendingPoint];
			}
		}
		return Integer.MIN_VALUE;
	}

	private static int findDescendingPoint(int[] nums, int start, int end) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if (middle > 0 && middle < nums.length - 1 && nums[middle] > nums[middle + 1]
					&& (nums[middle - 1] <= nums[middle]))
				return middle + 1;
			else if (middle < nums.length - 1 && middle > 0 && nums[middle] > nums[middle + 1]
					&& (nums[middle - 1] >= nums[middle]))
				return findDescendingPoint(nums, start, middle - 1);
			else
				return findDescendingPoint(nums, middle + 1, end);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1 };
		System.out.println(findMax(nums));

		nums = new int[] { 1, 2, 3, 4, 5, 6 };
		System.out.println(findMax(nums));

		nums = new int[] { 6, 5, 4, 3, 2, 1 };
		System.out.println(findMax(nums));

		nums = new int[] { 1, 3 };
		System.out.println(findMax(nums));

		nums = new int[] { 8, 10, 20, 80, 100, 200, 400, 500, 3, 2, 1 };
//		System.out.println(findDescendingPoint(nums, 0, nums.length - 1));
		System.out.println(findMax(nums));

		nums = new int[] { 120, 100, 80, 20, 0 };
		System.out.println(findMax(nums));

		nums = new int[] { 10, 20, 30, 40, 50 };
		System.out.println(findMax(nums));

	}

}
