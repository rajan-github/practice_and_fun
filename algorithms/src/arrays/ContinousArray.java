package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a binary array, find the maximum length of a contiguous subarray with
 * equal number of 0 and 1.
 * 
 * @author rajan-c
 *
 */
public class ContinousArray {
	public static int findMaxLength(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		for (int i = 0; i < nums.length; i++)
			if (nums[i] == 0)
				nums[i] -= 1;
		int[] prefixSum = new int[nums.length + 1];
		prefixSum[0] = 0;
		for (int i = 1; i <= nums.length; i++)
			prefixSum[i] += (prefixSum[i - 1] + nums[i - 1]);

		int maxCount = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < prefixSum.length; i++) {
			if (map.containsKey(prefixSum[i])) {
				int diff = i - map.get(prefixSum[i]);
				if (diff > maxCount)
					maxCount = diff;
			} else
				map.put(prefixSum[i], i);
		}

		return maxCount > 0 ? maxCount : 0;
	}

	public static void main(String[] args) {
		int[] nums = new int[] { 0, 1 };
		System.out.println(findMaxLength(nums));

		nums = new int[] { 0, 1, 0 };
		System.out.println(findMaxLength(nums));

		nums = new int[] { 0, 1, 0, 1, 1, 0 };
		System.out.println(findMaxLength(nums));

		nums = new int[] { 0, 0, 0, 1, 1, 0 };
		System.out.println(findMaxLength(nums));

		nums = new int[] { 0, 0, 0, 0 };
		System.out.println(findMaxLength(nums));

		nums = new int[] { 0, 0, 0, 1, 1, 1, 0 };
		System.out.println(findMaxLength(nums));

		nums = new int[] { 0, 1, 1, 0, 1, 1, 1, 0 };
		System.out.println(findMaxLength(nums));

		nums = new int[] { 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1,
				0, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 0, 0, 1, 0,
				0, 0, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1 };
		System.out.println(findMaxLength(nums));
	}
}
