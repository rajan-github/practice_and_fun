package backtracking.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a collection of integers that might contain duplicates, nums, return
 * all possible subsets (the power set).
 * 
 * Note: The solution set must not contain duplicate subsets.
 * 
 * @author rajan-c
 *
 */
public class UniqueSubsets {

	public static List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> subsets = new ArrayList<>();
		if (nums == null || nums.length == 0)
			return subsets;
		Arrays.sort(nums);
		generateSubsets(nums, 0, new boolean[nums.length], subsets);
		Map<List<Integer>, Integer> map = new HashMap<>();
		for (List<Integer> subset : subsets)
			map.putIfAbsent(subset, 1);
		subsets.clear();
		for (Map.Entry<List<Integer>, Integer> entry : map.entrySet())
			subsets.add(entry.getKey());
		return subsets;
	}

	private static void generateSubsets(int[] nums, int k, boolean[] subset, List<List<Integer>> subsets) {
		if (k >= nums.length) {
			List<Integer> temp = new ArrayList<>();
			for (int i = 0; i < subset.length; i++) {
				if (subset[i])
					temp.add(nums[i]);
			}
			subsets.add(temp);
		} else {
			subset[k] = false;
			generateSubsets(nums, k + 1, subset, subsets);
			subset[k] = true;
			generateSubsets(nums, k + 1, subset, subsets);
		}
	}

	public static void main(String[] args) {
		int[] nums = { 4, 4, 4, 1, 4 };
		List<List<Integer>> subsets = subsetsWithDup(nums);
		for (List<Integer> subset : subsets)
			System.out.println(subset);
	}

}
