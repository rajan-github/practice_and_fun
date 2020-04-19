package arrays;

import numbers.MergeSort;

/**
 * Given an unsorted array and a number n, find if there exists a pair of
 * elements in the array whose difference is n.
 * 
 * @author rajan-c
 *
 */
public class PairWithGivenDifference {

	public static int[] findPairWithGivenDifference(int[] nums, int diff) {
		int[] indexes = { Integer.MIN_VALUE, Integer.MIN_VALUE };
		if (nums != null && nums.length > 1) {
			nums = MergeSort.mergeSort(nums, 0, nums.length - 1);
			for (int i = 0; i < nums.length; i++) {
				int index = search(nums, 0, nums.length - 1, diff + nums[i]);
				if (index >= 0 && index != i) {
					indexes[0] = nums[i];
					indexes[1] = nums[index];
					break;
				}
			}
		}
		return indexes;
	}

	private static int search(int[] nums, int start, int end, int key) {
		if (start <= end) {
			int middle = (start + end) / 2;
			if (nums[middle] == key)
				return middle;
			else if (nums[middle] < key)
				return search(nums, middle + 1, end, key);
			else
				return search(nums, start, middle - 1, key);
		}
		return -1;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 20, 3, 2, 50, 80 };
		int[] indexes = findPairWithGivenDifference(nums, 78);
		System.out.println(indexes[0] + " and " + indexes[1]);

		nums = new int[] { 1, 8, 30, 40, 100 };
		indexes = findPairWithGivenDifference(nums, 60);
		System.out.println(indexes[0] + " and " + indexes[1]);
	}

}
