package arrays;

/**
 * Given an unsorted integer array, find the smallest missing positive integer.
 * 
 * @author rajan-c
 *
 */
public class SmallestMissingPositive {
	public static int firstMissingPositive(int[] nums) {
		if (nums == null || nums.length == 0)
			return 1;
		else if (nums.length == 1)
			return nums[0] == 1 ? 2 : 1;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= 0) {
				nums[i] = nums.length + 1;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			int index = (int) Math.abs(nums[i]) - 1;
			if (index >= 0 && index < nums.length && nums[index] > 0) {
				nums[index] *= -1;
			}
		}

		int index = 0;
		for (index = 0; index < nums.length; index++) {
			if (nums[index] > 0) {
				break;
			}
		}
		return index + 1;
	}

	public static void main(String[] args) {
		int[] nums = { 3, 4, -1, 1 };
//		System.out.println(firstMissingPositive(nums));
		nums = new int[] { 1, 2, 0 };
		System.out.println(firstMissingPositive(nums));
		nums = new int[] { 7, 8, 9, 11, 12 };
		System.out.println(firstMissingPositive(nums));
		nums = new int[] { 2, 3, 7, 6, 8, -1, -10, 15 };
		System.out.println(firstMissingPositive(nums));
		nums = new int[] { 2, 3, -7, 6, 8, 1, -10, 15 };
		System.out.println(firstMissingPositive(nums));
		nums = new int[] { 1, 1, 0, -1, -2 };
		System.out.println(firstMissingPositive(nums));

		nums = new int[] { 4 };
		System.out.println(firstMissingPositive(nums));

		nums = new int[] { 1, 2 };
		System.out.println(firstMissingPositive(nums));
	}
}
