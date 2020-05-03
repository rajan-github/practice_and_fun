package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they
 * add up to a specific target.
 * 
 * You may assume that each input would have exactly one solution, and you may
 * not use the same element twice.
 * 
 * @author rajan-c
 *
 */
public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		int[] indexes = new int[2];
		for (int i = 0; i < nums.length; i++)
			map.put(nums[i], i);

		for (int i = 0; i < nums.length; i++) {
			Integer key = map.get(target - nums[i]);
			if (key != null && key != i) {
				indexes[0] = i;
				indexes[1] = key;
				break;
			}
		}
		return indexes;
	}

	public static void main(String[] args) {
		int[] indexes = twoSum(new int[] { 3, 2, 4 }, 6);
		System.out.println(indexes[0] + ", " + indexes[1]);
	}
}
