package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a set of candidate numbers (candidates) (without duplicates) and a
 * target number (target), find all unique combinations in candidates where the
 * candidate numbers sums to target.
 * 
 * The same repeated number may be chosen from candidates unlimited number of
 * times.
 * 
 * @author rajan-c
 *
 */
public class CombinationSum {
	private static List<List<Integer>> combinationSum(int[] nums, int target) {
		List<List<Integer>> listOfLists = new ArrayList<>();
		if (nums != null) {
			Map<Integer, Integer> map = new HashMap<>();
			for (int item : nums) {
				map.put(item, 1);
			}

			for (int item : nums) {
				List<Integer> list = combination(nums, target - item, map, new ArrayList<>());
				if (list != null) {
					list.addAll(combination(nums, item, map, new ArrayList<>()));
					if (map.containsKey(target - item)) {
						Map<Integer, Integer> newMap = new HashMap<>(map);
						newMap.remove(target - item);
						listOfLists.add(combination(nums, target, newMap, new ArrayList<>()));
					}
					listOfLists.add(list);
				}
			}
		}

		return listOfLists;
	}

	private static boolean sumToTarget(List<Integer> list, int target) {
		for (int item : list) {
			target -= item;
		}
		return target == 0;
	}

	private static List<Integer> combination(int[] nums, int target, Map<Integer, Integer> map, List<Integer> sum) {
		if (target == 0)
			return new ArrayList<>();
		else if (map.containsKey(target)) {
			sum.add(target);
			return sum;
		} else if (target < 0)
			return null;
		else {
			List<Integer> result = null;
			for (int item : nums) {
				result = combination(nums, target - item, map, sum);
				if (result != null && sumToTarget(result, target - item)) {
					result.add(item);
					break;
				}
			}
			return result;
		}
	}

	public static void display(List<List<Integer>> lists) {
		if (lists != null) {
			for (List<Integer> list : lists)
				System.out.println(list);
		} else
			System.out.println("No combination found!");
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 2, 5, 3 };
		display(combinationSum(nums, 8));
	}

}
