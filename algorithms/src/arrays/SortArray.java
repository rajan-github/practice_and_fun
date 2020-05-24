package arrays;

/**
 * Sort the array using an efficient algorithm. We are implementing merge sort
 * here.
 * 
 * @author rajan-c
 *
 */
public class SortArray {
	public static int[] sortArray(int[] nums) {
		if (nums == null || nums.length <= 1)
			return nums;
		return mergeSort(nums, 0, nums.length - 1);
	}

	private static int[] mergeSort(int[] nums, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			int[] left = mergeSort(nums, start, middle);
			int[] right = mergeSort(nums, middle + 1, end);
			return merge(left, right);
		}
		return new int[] { nums[start] };
	}

	private static int[] merge(int[] left, int[] right) {
		int[] merged = new int[left.length + right.length];
		int leftIndex = 0, rightIndex = 0, index = 0;

		while (leftIndex < left.length && rightIndex < right.length) {
			if (left[leftIndex] <= right[rightIndex])
				merged[index] = left[leftIndex++];
			else
				merged[index] = right[rightIndex++];
			index++;
		}

		while (leftIndex < left.length)
			merged[index++] = left[leftIndex++];

		while (rightIndex < right.length)
			merged[index++] = right[rightIndex++];
		return merged;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 3, -5 };
		nums = sortArray(nums);
		for (int item : nums)
			System.out.print(item + ", ");
	}
}
