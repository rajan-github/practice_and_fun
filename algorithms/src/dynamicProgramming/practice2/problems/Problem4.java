package dynamicProgramming.practice2.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem4 {
	/**
	 * Describe and analyze an algorithm that finds the largest sum of elements in a
	 * contiguous subarray A[i .. j].
	 * 
	 * @param array
	 * @return
	 */
	public static int largestSumInContigousSubarray(int[] array) {
		int largestSum = 0;
		if (array == null || array.length == 0)
			return largestSum;
		int currentSum = 0;

		for (int i = 0; i < array.length; i++) {
			int iterationLength = array.length, startIndex = i;
			currentSum = 0;
			inner: while (iterationLength > 0) {
				currentSum += array[startIndex];
				largestSum = Math.max(largestSum, currentSum);
				if (currentSum <= 0)
					break inner;
				startIndex++;
				iterationLength--;
				if (startIndex == (array.length))
					startIndex %= (array.length);
			}
		}
		return largestSum;
	}

	public static int[] largestSumInLongestSubarraySlow(int[] array) {
		if (array == null || array.length == 0)
			return new int[2];
		int largestSum = largestSumSubarray(array);
		int[] prefixSum = new int[array.length];
		prefixSum[0] = array[0];
		for (int i = 1; i < array.length; i++)
			prefixSum[i] = prefixSum[i - 1] + array[i];

		int[] largestSumIndexes = new int[2];

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				int sum = (i == 0) ? prefixSum[j] : (prefixSum[j] - prefixSum[i - 1]);
				if (sum == largestSum) {
					int oldSubarrayLength = largestSumIndexes[1] - largestSumIndexes[0] + 1;
					if (oldSubarrayLength < (j - i + 1)) {
						largestSumIndexes[0] = i;
						largestSumIndexes[1] = j;
					}
				}
			}
		}
		return largestSumIndexes;
	}

	public static int largestSumInLongestSubarrayFast(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int largestSum = largestSumSubarray(array);
		Map<Integer, Integer> sumToIndexMap = new HashMap<>();

		int sum = 0, largestLength = Integer.MIN_VALUE;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (sum == largestSum)
				largestLength = Math.max(largestLength, i + 1);

			sumToIndexMap.put(sum, i);
			if (sumToIndexMap.containsKey(sum - largestSum))
				largestLength = Math.max(largestLength, i - sumToIndexMap.get(sum - largestSum));
		}
		return largestLength;
	}

	public static int largestSumInShortestSubarray(int[] array) {
		if (array == null || array.length == 0)
			return 0;
		int largestSum = largestSumSubarray(array);
		Map<Integer, Integer> sumToIndexMap = new HashMap<>();

		int sum = 0, largestLength = Integer.MAX_VALUE;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
			if (sum == largestSum)
				largestLength = Math.min(largestLength, i + 1);

			sumToIndexMap.put(sum, i);
			if (sumToIndexMap.containsKey(sum - largestSum))
				largestLength = Math.min(largestLength, i - sumToIndexMap.get(sum - largestSum));
		}
		return largestLength;
	}

	private static int largestSumSubarray(int[] array) {
		int largestSum = 0;
		if (array == null || array.length == 0)
			return largestSum;
		int currentSum = 0;
		for (int i = 0; i < array.length; i++) {
			currentSum = currentSum + array[i];
			largestSum = Math.max(largestSum, currentSum);
			currentSum = Math.max(currentSum, 0);
		}
		return largestSum;
	}

	public static void main(String[] args) {
		int[] array = new int[] { -6, 12, -7, 0, 14, -7, 5 };
		System.out.println(largestSumSubarray(array));
		System.out.println(largestSumInLongestSubarrayFast(array) + ", " + largestSumInShortestSubarray(array));
		array = new int[] { 5, -2, -1, 3, -4 };
		System.out.println(largestSumInLongestSubarrayFast(array) + ", " + largestSumInShortestSubarray(array));
		array = new int[] { -2, -3, 4, -1, -2, 1, 5, -3 };
		System.out.println(largestSumInLongestSubarrayFast(array) + ", " + largestSumInShortestSubarray(array));
	}
}
