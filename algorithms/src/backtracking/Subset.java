package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subset {

	public static void subsets(List<Integer> list) {

	}

	private static void backtrack(List<Integer> list, boolean[] subset, int k, boolean[] values) {
		if (k >= list.size()) {
			display(subset, list);
		} else {
			for (int i = 0; i < values.length; i++) {
				boolean temp = subset[k];
				subset[k] = values[i];
				backtrack(list, subset, k + 1, values);
				subset[k] = temp;
			}
		}
	}

	private static void display(boolean[] nums, List<Integer> list) {
		System.out.print("{ ");
		for (int i = 0; i < nums.length; i++) {
			if (nums[i]) {
				System.out.print(list.get(i) + ", ");
			}
		}
		System.out.println(" }");
	}

	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(1);
		list.add(2);
		list.add(3);
		list.add(4);
		backtrack(list, new boolean[] { true, false, true, true }, 0, new boolean[] { true, false });
	}

}
