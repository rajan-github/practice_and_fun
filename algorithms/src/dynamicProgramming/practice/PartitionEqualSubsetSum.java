package dynamicProgramming.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given a non-empty array containing only positive integers, find if the array
 * can be partitioned into two subsets such that the sum of elements in both
 * subsets is equal.
 * 
 * Note:
 * 
 * Each of the array element will not exceed 100. The array size will not exceed
 * 200.
 * 
 * @author rajan-c
 *
 */
public class PartitionEqualSubsetSum {
	public static boolean canPartition(int[] nums) {
		if (nums != null && nums.length >= 2) {
			int sum = sum(nums);
			if ((sum & 1) == 1)
				return false;
			int subsetSum = sum >> 1;
			Arrays.sort(nums);
			return subsetSum(nums, subsetSum, new HashSet<Integer>(), new HashMap<Integer, Boolean>());
		}
		return false;
	}

	private static boolean subsetSum(int[] nums, int target, Set<Integer> usedIndexes, Map<Integer, Boolean> memory) {
		if (target == 0)
			return true;
		if (memory.containsKey(target))
			return memory.get(target);
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] <= target && !usedIndexes.contains(i)) {
				usedIndexes.add(i);
				boolean sumFound = subsetSum(nums, target - nums[i], usedIndexes, memory);
				if (sumFound) {
					memory.put(target - nums[i], true);
					return true;
				}
				usedIndexes.remove(i);
			} else if (nums[i] > target)
				break;
		}
		memory.put(target, false);
		return false;
	}

	private static int sum(int[] array) {
		int sum = 0;
		for (int item : array)
			sum += item;
		return sum;
	}

	public static void main(String[] args) {
//		System.out.println(canPartition(new int[] { 1, 3, 3, 5 }));
//		System.out.println(canPartition(new int[] { 1, 2, 3, 5 }));
//		System.out.println(canPartition(new int[] { 1, 5, 11, 5 }));
//		System.out.println(canPartition(new int[] { 1, 1 }));
//		System.out.println(canPartition(new int[] { 1, 2, 5 }));
		System.out.println(canPartition(new int[] { 1, 1, 1, 1 }));
	}
}
