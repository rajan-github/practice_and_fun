package arrays;

/**
 * Given an array of integers nums sorted in ascending order, find the starting
 * and ending position of a given target value.Your algorithm's runtime
 * complexity must be in the order of O(log n). If the target is not found in
 * the array, return [-1, -1].
 * 
 * @author rajan-c
 *
 */
public class FindFirstAndLastPosition {
	public static int[] searchRange(int[] nums, int target) {
		int[] indexes = new int[] { -1, -1 };
		int index = findFirstPosition(nums, 0, nums.length - 1, target);
		if (index != -1) {
			indexes[0] = index;
			indexes[1] = findLastPosition(nums, 0, nums.length - 1, target);
		}
		return indexes;
	}

	private static int findFirstPosition(int[] nums, int start, int end, int target) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if ((middle == 0 || nums[middle - 1] != target) && nums[middle] == target)
				return middle;
			else if ((nums[middle] > target
					|| (middle > 0 && nums[middle - 1] == nums[middle] && nums[middle] == target)))
				return findFirstPosition(nums, 0, middle - 1, target);
			else
				return findFirstPosition(nums, middle + 1, end, target);
		}
		return -1;
	}

	private static int findLastPosition(int[] nums, int start, int end, int target) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if ((middle == end || nums[middle + 1] != target) && nums[middle] == target) {
				return middle;
			} else if ((nums[middle] < target
					|| (middle < end && nums[middle + 1] == nums[middle] && nums[middle] == target))) {
				return findLastPosition(nums, middle + 1, end, target);
			} else
				return findLastPosition(nums, start, middle - 1, target);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int[] indexes = searchRange(nums, 5);
		System.out.println(indexes[0] + ", " + indexes[1]);
	}
}
