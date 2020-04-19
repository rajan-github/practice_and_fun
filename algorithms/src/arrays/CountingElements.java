package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array arr, count element x such that x + 1 is also in arr.
 * 
 * If there're duplicates in arr, count them seperately.
 * 
 * @author rajan-c
 *
 */
public class CountingElements {
	public static int countElements(int[] arr) {
		int count = 0;
		Map<Integer, Integer> map = new HashMap<>();
		for (int item : arr) {
			if (map.containsKey(item)) {
				map.put(item, map.get(item) + 1);
			} else
				map.put(item, 1);
		}

		for (int item : arr) {
			if (map.containsKey(item + 1))
				count += 1;
		}
		return count;
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3 };
		System.out.println(countElements(nums));

		nums = new int[] { 1, 1, 3, 3, 5, 5, 7, 7 };
		System.out.println(countElements(nums));

		nums = new int[] { 1, 3, 2, 3, 5, 0 };
		System.out.println(countElements(nums));

		nums = new int[] { 1, 1, 2, 2 };
		System.out.println(countElements(nums));
	}
}
