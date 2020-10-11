package dynamicProgramming.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array with all positive numbers and no duplicates, find the
 * number of possible combinations that add up to a positive integer target.
 * Example: nums = [1, 2, 3] target = 4
 * 
 * The possible combination ways are: (1, 1, 1, 1) (1, 1, 2) (1, 2, 1) (1, 3)
 * (2, 1, 1) (2, 2) (3, 1)
 * 
 * @author rajan-c
 *
 */
public class CombinationSumIV {

	public static int combinationSum4(int[] nums, int target) {
		if (nums != null) {
			Arrays.sort(nums);
			int memory[] = new int[target + 1];
			for (int i = 0; i <= target; i++)
				memory[i] = -1;
			return combinationSum(nums, target, new ArrayList<>(), memory);
		}
		return 0;
	}

	private static int combinationSum(int[] nums, int target, List<Integer> currentCombination, int[] memory) {
		if (target == 0)
			return 1;

		if (memory[target] >= 0)
			return memory[target];
		int total = 0;
		for (int item : nums) {
			if (item <= target) {
				currentCombination.add(item);
				total += combinationSum(nums, target - item, currentCombination, memory);
				if (currentCombination.size() > 0)
					currentCombination.remove(currentCombination.size() - 1);
			} else
				break;
		}
		memory[target] = total;
		return total;
	}

	public static void main(String[] args) {
		System.out.println(combinationSum4(new int[] { 1, 2, 3 }, 4));
		System.out.println(combinationSum4(new int[] { 1, 2, 4 }, 32));
		System.out.println(combinationSum4(new int[] { 1, 2, 3 }, 32));
	}
}
