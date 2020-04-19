package backtracking.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two integers n and k, return all possible combinations of k numbers out
 * of 1 ... n.
 * 
 * @author rajan-c
 *
 */
public class KSubsets {
	public static List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> lists = new ArrayList<>();
		int[] nums = new int[n];
		for (int i = 0; i < k; i++)
			nums[i] = 1;
		permutations(nums, 0, lists);
		return lists;
	}

	private static void display(List<List<Integer>> lists) {
		for (List<Integer> list : lists)
			System.out.println(list);
	}

	private static void addList(int[] nums, List<List<Integer>> lists) {
		int length = nums.length;
		List<Integer> list = new ArrayList<>();
		for (int i = 1; i <= length; i++) {
			if (nums[i - 1] == 1) {
				list.add(i);
			}
		}
		lists.add(list);
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void permutations(int[] nums, int k, List<List<Integer>> lists) {
		if (k == nums.length) {
			addList(nums, lists);
			return;
		}
		List<Integer> choices = getChoices(nums, k);
		for (int choice : choices) {
			swap(nums, k, choice);
			permutations(nums, k + 1, lists);
			swap(nums, k, choice);
		}
	}

	private static List<Integer> getChoices(int[] nums, int k) {
		Map<Integer, Boolean> map = new HashMap<>();
		List<Integer> choices = new ArrayList<>();
		for (int i = k; i < nums.length; i++) {
			if (!map.containsKey(nums[i])) {
				map.put(nums[i], true);
				choices.add(i);
			}
		}
		return choices;
	}

	public static void main(String[] args) {
		display(combine(4, 2));
	}
}
