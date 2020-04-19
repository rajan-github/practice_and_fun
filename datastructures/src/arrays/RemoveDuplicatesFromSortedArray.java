package arrays;

import java.util.Arrays;

public class RemoveDuplicatesFromSortedArray {
	public int removeDuplicates(int[] nums) {
		int newLength = 1, oldLength = nums.length, i = 0;
		while (i < oldLength) {
			int temp = getNextIndex(nums, i);
			if (temp <= oldLength - 1) {
				nums[newLength++] = nums[temp];
			}
			i = temp;
		}
		return newLength;
	}

	private static int getNextIndex(int[] nums, int index) {
		int i = index;
		while (i < nums.length - 1 && nums[i] == nums[i + 1])
			i++;
		return i + 1;
	}

	public static void main(String[] args) {
		int[] data = new int[] { 0, 0, 0, 0, 1, 2, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6, 6, 6, 6, 7, 7, 7, 7, 8, 8, 8, 8,
				9 };
		int length = new RemoveDuplicatesFromSortedArray().removeDuplicates(data);
		System.out.println(length + "\n " + Arrays.toString(data));
	}
}
