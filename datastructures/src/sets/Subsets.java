package sets;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> lists = new ArrayList<>();
		int[] subset = new int[nums.length];
		if (nums != null && nums.length > 0) {
			subsets(subset, nums, 0, lists);
		}
		return lists;
	}

	private static void display(List<List<Integer>> lists) {
		for (List<Integer> list : lists)
			System.out.println(list);
	}

	private static void addList(int[] subset, int[] set, List<List<Integer>> lists) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < subset.length; i++) {
			if (subset[i] != 0) {
				list.add(set[i]);
			}
		}
		lists.add(list);
	}

	private static void subsets(int[] subset, int[] set, int k, List<List<Integer>> lists) {
		if (k == subset.length) {
			addList(subset, set, lists);
			return;
		}
		subset[k] = 1;
		subsets(subset, set, k + 1, lists);
		subset[k] = 0;
		subsets(subset, set, k + 1, lists);
	}

	public static void main(String[] args) {
		display(subsets(new int[] { 1 }));
	}
}
