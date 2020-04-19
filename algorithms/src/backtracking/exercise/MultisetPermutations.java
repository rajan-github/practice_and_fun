package backtracking.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Multisets are allowed to have repeated elements. A multiset of n items may
 * thus have fewer than n! distinct permutations. For example, {1,1,2,2} has
 * only six different permutations: {1,1,2,2}, {1,2,1,2}, {1,2,2,1}, {2,1,1,2},
 * {2,1,2,1}, and {2,2,1,1}. Design and implement an efficient algorithm for
 * constructing all permutations of a multiset.
 * 
 * @author rajan-c
 *
 */
public class MultisetPermutations {

	private static List<Integer> getChoices(int[] nums, int k) {
		List<Integer> list = new ArrayList<>();
		Map<Integer, Boolean> map = new HashMap<>();
		for (int i = k; i < nums.length; i++) {
			map.putIfAbsent(nums[i], false);
		}
		for (int i = k; i < nums.length; i++) {
			if (!map.get(nums[i])) {
				list.add(i);
				map.put(nums[i], true);
			}
		}
		return list;
	}

	public static void multisetPermutations(int[] nums, int k) {
		if (k == nums.length) {
			display(nums);
			return;
		}

		List<Integer> choices = getChoices(nums, k);
		for (int choice : choices) {
			swap(nums, choice, k);
			multisetPermutations(nums, k + 1);
			swap(nums, choice, k);
		}
	}

	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public static void display(int[] nums) {
		for (int item : nums)
			System.out.print(item + ", ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1 };
		multisetPermutations(nums, 0);
	}
}
