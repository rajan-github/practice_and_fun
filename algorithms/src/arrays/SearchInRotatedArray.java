package arrays;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown
 * to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its
 * index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * @author rajan-c
 *
 */
public class SearchInRotatedArray {
	public static int search(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return -1;
		int pivot = findPivot(nums, 0, nums.length - 1);
		if (pivot < 0)
			return binarySearch(nums, 0, nums.length - 1, target);

		int targetPosition = binarySearch(nums, 0, pivot - 1, target);
		if (targetPosition < 0)
			return binarySearch(nums, pivot, nums.length - 1, target);
		return targetPosition;
	}

	private static int findPivot(int[] nums, int start, int end) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if (middle > 0 && nums[middle - 1] > nums[middle])
				return middle;
			else if (nums[middle] < nums[0])
				return findPivot(nums, start, middle - 1);
			else
				return findPivot(nums, middle + 1, end);
		}
		return -1;
	}

	private static int binarySearch(int[] nums, int start, int end, int target) {
		if (start >= 0 && start <= end) {
			int middle = (start + end) / 2;
			if (nums[middle] == target)
				return middle;
			else if (nums[middle] < target)
				return binarySearch(nums, middle + 1, end, target);
			else
				return binarySearch(nums, start, middle - 1, target);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 4, 5, 6, 7, 0, 1, 2 };
		System.out.println(search(array, 4));
		System.out.println(search(array, 0));

		array = new int[] { 1, 2, 3 };
		System.out.println(search(array, 1));
		System.out.println(search(array, 2));
		System.out.println(search(array, 3));

	}
}
