package arrays;

import java.util.Arrays;

/**
 * Find the next permutaion of the array which is greater than the current
 * order. If current order of elements makes the largest number then return
 * minimum number which can be formed from these number. Use constant space.
 * 
 * Example: [1,2,3]=>[1,3,2] and [3,2,1]=>[1,2,3]
 * 
 * @author rajan-c
 *
 */
public class NextPermutation {
	public static void nextPermutation(int[] nums) {
		if (nums == null || nums.length < 2)
			return;
		if (isMax(nums)) {
			Arrays.sort(nums);
		} else {
			int index = firstBigDigit(nums);
			sort(nums, index);
			int firstMin = findMin(nums, nums[index - 1], index);
			int temp = nums[index - 1];
			nums[index - 1] = nums[firstMin];
			nums[firstMin] = temp;
		}
	}

	private static void sort(int[] nums, int index) {
		if (index < nums.length && index >= 0) {
			for (int i = index + 1; i < nums.length; i++) {
				int temp = nums[i], j = i - 1;
				while (j >= index && nums[j] > temp) {
					nums[j + 1] = nums[j];
					j--;
				}
				nums[j + 1] = temp;
			}

		}
	}

	private static int findMin(int[] nums, int key, int start) {
		int min = -1;
		for (int i = start; i < nums.length; i++) {
			if (nums[i] > key) {
				if (min > 0 && nums[min] > nums[i]) {
					min = i;
				} else if (min < 0) {
					min = i;
				}
			}
		}
		return min;
	}

	private static int firstBigDigit(int[] nums) {
		int index = -1;
		for (int i = nums.length - 1; i > 0; i--) {
			if (nums[i] > nums[i - 1]) {
				index = i;
				break;
			}
		}
		return index;
	}

	private static boolean isMax(int[] nums) {
		int firstDigit = Integer.MAX_VALUE;
		boolean max = true;
		for (int item : nums) {
			if (item > firstDigit) {
				max = false;
				break;
			}
			firstDigit = item;
		}
		return max;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 3, 2 };
//		nextPermutation(nums);
//		display(nums);
//
//		nums = new int[] { 1, 2, 3 };
//		nextPermutation(nums);
//		display(nums);
//
//		nums = new int[] { 2, 3, 1 };
//		nextPermutation(nums);
//		display(nums);
//
//		nums = new int[] { 2, 1, 3 };
//		nextPermutation(nums);
//		display(nums);
//		nums = new int[] { 3, 2, 1 };
//		nextPermutation(nums);
//		display(nums);
//		nums = new int[] { 3, 1, 2 };
//		nextPermutation(nums);
//		display(nums);
//		
//		nums = new int[] { 1, 1, 5 };
//		nextPermutation(nums);
//		display(nums);
//
		nums = new int[] { 5, 4, 7, 5, 3, 2 };
		nextPermutation(nums);
		display(nums);

		nums = new int[] { 1, 2, 0, 3, 0, 1, 2, 4 };
		nextPermutation(nums);
		display(nums);

		nums = new int[] { 1, 2, 0, 3, 0, 1, 4, 2 };
		nextPermutation(nums);
		display(nums);
	}

	public static void display(int[] nums) {
		for (int item : nums) {
			System.out.print(item + ", ");
		}
		System.out.println();
	}
}
