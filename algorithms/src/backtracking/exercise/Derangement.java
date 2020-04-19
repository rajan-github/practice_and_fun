package backtracking.exercise;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A derangement is a permutation p of {1,...,n} such that no item is in its
 * proper position, i.e. p[i] ̸= i for all 1 ≤ i ≤ n. Write an efficient
 * backtracking program with pruning that constructs all the derangements of n
 * items.
 * 
 * @author rajan-c
 *
 */
public class Derangement {
	private static List<Integer> getChoices(int[] nums, int index) {
		List<Integer> choices = new ArrayList<>();
		Map<Integer, Integer> used = new HashMap<>();
		for (int i = 0; i < nums.length; i++)
			used.put(i, 1);
		for (int i = 0; i < index; i++)
			used.remove(nums[i]);
		used.remove(index);
		for (Map.Entry<Integer, Integer> map : used.entrySet()) {
			choices.add(map.getKey());
		}
		return choices;
	}

	public static void derangement(int[] nums, int currentIndex) {
		if (currentIndex == nums.length) {
			display(nums);
			return;
		}
		List<Integer> choices = getChoices(nums, currentIndex);
		for (int item : choices) {
			int temp = nums[currentIndex];
			nums[currentIndex] = item;
			derangement(nums, currentIndex + 1);
			nums[currentIndex] = temp;
		}
	}

	private static void display(int[] nums) {
		for (int item : nums)
			System.out.print(item + ", ");
		System.out.println();
	}

	public static void main(String[] args) {
		int[] nums = { 0, 1, 2, 3 };

//		derangement(nums, 0);

		nums = new int[] { 0, 1, 2, 3, 4 };
		derangement(nums, 0);
	}
}
