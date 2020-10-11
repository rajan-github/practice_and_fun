package arrays;

import java.util.Arrays;

public class Wiggle2 {
	public static void wiggleSort(int[] nums) {
		int[] clone = Arrays.copyOf(nums, nums.length);
		Arrays.sort(clone);
		int endOfFirstHalf = (nums.length / 2) - 1, endOfSecondHalf = nums.length - 1;
		int firstHalfIndex = 0, secondHalfIndex = endOfFirstHalf + 1, index = 0;

		boolean chooseBig = false;
		while (firstHalfIndex <= endOfFirstHalf || secondHalfIndex <= endOfSecondHalf) {
			System.out.println(firstHalfIndex + "," + secondHalfIndex);
			if (chooseBig)
				nums[index++] = clone[secondHalfIndex++];
			else
				nums[index++] = clone[firstHalfIndex++];
			chooseBig = !chooseBig;
		}
	}

	public static void main(String[] args) {
		int array[] = new int[] { 1, 5, 1, 1, 6, 4 };
		wiggleSort(array);
		System.out.println(Arrays.toString(array));
	}
}
