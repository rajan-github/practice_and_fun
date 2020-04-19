package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a collection of numbers that might contain duplicates, return all
 * possible unique permutations.
 * 
 * @author rajan-c
 *
 */
public class PermutationUnique {

	public static List<List<Integer>> permuteUnique(int[] nums) {
		if (nums == null) {
			return new ArrayList<>();
		} else {
			List<List<Integer>> lists = new ArrayList<>();
			Map<String, Integer> map = new HashMap<>();
			permute(nums, 0, lists, map);
			return lists;
		}
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void permute(int[] nums, int left, List<List<Integer>> lists, Map<String, Integer> map) {
		if (left == nums.length) {
			List<Integer> list = new ArrayList<Integer>();
			StringBuilder string = new StringBuilder();
			for (int item : nums) {
				list.add(item);
				string.append(item);
			}
			if (!map.containsKey(string.toString())) {
				lists.add(list);
				map.put(string.toString(), 1);
			}

			return;
		}
		for (int i = left; i < nums.length; i++) {
			if (left == i || nums[left] != nums[i]) {
				swap(nums, left, i);
				permute(nums, left + 1, lists, map);
				swap(nums, left, i);
			}
		}
	}

	private static void display(List<List<Integer>> lists) {
		for (List<Integer> list : lists)
			System.out.println(list);
	}

	public static void main(String[] args) {
		int[] nums = { 1, 1, 2, 2 };
		List<List<Integer>> lists = permuteUnique(nums);
		display(lists);
	}

}
