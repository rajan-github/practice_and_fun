package topIntQuestions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given two arrays, write a function to compute their intersection.
 * 
 * Each element in the result should appear as many times as it shows in both
 * arrays. The result can be in any order.
 * 
 * @author rajan-c
 *
 */
public class Problem5 {
	public int[] intersect(int[] nums1, int[] nums2) {
		if (nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0)
			return new int[] {};
		int length1 = nums1.length, length2 = nums2.length;
		List<Integer> intersection;
		if (length1 > length2) {
			intersection = getIntersection(nums1, nums2);
		} else {
			intersection = getIntersection(nums2, nums1);
		}
		int[] intersectionArray = new int[intersection.size()];
		for (int i = 0; i < intersectionArray.length; i++)
			intersectionArray[i] = intersection.get(i);
		return intersectionArray;
	}

	private static List<Integer> getIntersection(int[] nums1, int[] nums2) {
		List<Integer> intersection = new ArrayList<>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int item : nums1)
			if (map.containsKey(item))
				map.replace(item, map.get(item) + 1);
			else
				map.put(item, 1);
		for (int item : nums2)
			if (map.containsKey(item)) {
				intersection.add(item);
				int frequency = map.get(item);
				if (frequency > 1)
					map.replace(item, frequency - 1);
				else
					map.remove(item);
			}

		return intersection;
	}
}
