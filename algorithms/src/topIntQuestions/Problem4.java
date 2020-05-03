package topIntQuestions;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * 
 * Your function should return true if any value appears at least twice in the
 * array, and it should return false if every element is distinct.
 * 
 * @author rajan-c
 *
 */
public class Problem4 {

	public static boolean containsDuplicate(int[] nums) {
		if (nums == null || nums.length == 0)
			return false;
		Set<Integer> set = new HashSet<>();
		for (int item : nums) {
			if (set.contains(item))
				return true;
			else
				set.add(item);
		}
		return false;
	}

	public static void main(String[] args) {
		int[] array = new int[] { 1, 2, 3, 4, 1 };
		System.out.println(containsDuplicate(array));
	}

}
