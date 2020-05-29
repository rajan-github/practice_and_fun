package dynamicProgramming.practice;

import java.util.ArrayList;
import java.util.List;

public class LargestSDivisibleSubset {
	public static List<Integer> largestDivisibleSubset(int[] nums) {
		return largestDivisibleSubset(nums, 0);
	}

	public static List<Integer> largestDivisibleSubset(int[] nums, int index) {
		if (index >= nums.length)
			return new ArrayList<>();
		List<Integer> maxSet = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			List<Integer> subset = largestDivisibleSubset(removeItem(nums, i));
			if (canBeAddedToSubset(subset, nums[i]))
				subset.add(nums[i]);
			if (subset.size() > maxSet.size())
				maxSet = subset;
		}
		return maxSet;
	}

	private static int[] removeItem(int[] nums, int i) {
		int[] array = new int[nums.length - 1];
		for (int index = 0, j = 0; index < nums.length; index++)
			if (index != i)
				array[j++] = nums[index];
		return array;
	}

	private static boolean canBeAddedToSubset(List<Integer> subset, int number) {
		for (int item : subset)
			if (item % number != 0 && number % item != 0)
				return false;
		return true;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 3, 6, 5, 10, 15 };
		System.out.println(largestDivisibleSubset(array));

		array = new int[] { 1, 2, 3 };
		System.out.println(largestDivisibleSubset(array));

		array = new int[] { 1, 2, 4, 8 };
		System.out.println(largestDivisibleSubset(array));
		array = new int[] { 1, 16, 7, 8, 4 };
		System.out.println(largestDivisibleSubset(array));

	}
}
