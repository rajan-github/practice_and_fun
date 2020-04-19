package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * An array is given and we need to generate all possible permutations of this
 * array.
 * 
 * @author rajan-c
 *
 */
public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
		if (nums == null) {
			return new ArrayList<List<Integer>>();
		}
		List<List<Integer>> lists = new ArrayList<>();
		generatePermutations(nums, 0, nums.length - 1, lists);
		return lists;
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private static void generatePermutations(int[] nums, int left, int right, List<List<Integer>> lists) {
		if (left == right) {
			List<Integer> list = new ArrayList<>();
			for (int item : nums) {
				list.add(item);
			}
			lists.add(list);
			return;
		}
		for (int i = left; i <= right; i++) {
			swap(nums, left, i);
			generatePermutations(nums, left + 1, right, lists);
			swap(nums, left, i);
		}
	}

	private static void display(List<List<Integer>> lists) {
		for (List<Integer> list : lists)
			System.out.println(list);
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 1, 2 };
		List<List<Integer>> lists = permute(nums);
		display(lists);
	}
}
