package dp.examples;

/**
 * Longest bitonic subsequence.
 * 
 * @author rajan-c
 *
 */
public class LongestBitonicSubsequence {
	public static int longestBitonicSubsequence(int[] array) {
		int lastIndex = array.length - 1;
		int longestBitonic = Math.max(longestIncreasingSubsequence(array, 0, lastIndex),
				longestDecreasingSubsequence(array, 0, lastIndex));
		if (longestBitonic >= array.length)
			return longestBitonic;
		for (int i = 0; i <= lastIndex; i++)
			longestBitonic = Math.max(
					longestIncreasingSubsequence(array, 0, i) + longestDecreasingSubsequence(array, i + 1, lastIndex),
					longestBitonic);
		return longestBitonic;
	}

	private static int longestIncreasingSubsequence(int[] array, int start, int end) {
		if (start > end)
			return 0;
		if (start == end)
			return 1;
		int[][] dp = new int[end - start + 2][end - start + 2];

		int[] extendedArray = new int[end - start + 2];
		extendedArray[0] = Integer.MIN_VALUE;
		for (int i = start; i <= end; i++)
			extendedArray[i + 1 - start] = array[i];

		for (int i = 1; i < dp.length; i++)
			dp[i][0] = 1;

		for (int i = 1; i < dp[0].length; i++)
			if (extendedArray[dp.length - 1] > extendedArray[i])
				dp[dp.length - 1][i] = 1;

		for (int i = dp.length - 2; i > 0; i--) {
			for (int j = 0; j < i; j++)
				if (extendedArray[i] > extendedArray[j])
					dp[i][j] = Math.max(dp[i + 1][j], 1 + dp[i + 1][i]);
				else
					dp[i][j] = dp[i + 1][j];
		}
		return dp[1][0];
	}

	private static int longestDecreasingSubsequence(int[] array, int start, int end) {
		if (start > end)
			return 0;
		if (start == end)
			return 1;
		int[][] dp = new int[end - start + 2][end - start + 2];

		int[] extendedArray = new int[end - start + 2];
		extendedArray[0] = Integer.MAX_VALUE;
		for (int i = start; i <= end; i++)
			extendedArray[i + 1 - start] = array[i];

		for (int i = 1; i < dp.length; i++)
			dp[i][0] = 1;

		for (int i = 1; i < dp[0].length; i++)
			if (extendedArray[dp.length - 1] < extendedArray[i])
				dp[dp.length - 1][i] = 1;

		for (int i = dp.length - 2; i > 0; i--) {
			for (int j = 0; j < i; j++)
				if (extendedArray[i] < extendedArray[j])
					dp[i][j] = Math.max(dp[i + 1][j], 1 + dp[i + 1][i]);
				else
					dp[i][j] = dp[i + 1][j];
		}
		return dp[1][0];
	}

	public static void main(String[] args) {
		System.out.println(longestBitonicSubsequence(new int[] { 1, 2, 3, 4, 5, 4, 3, 2, 1 }));
		System.out.println(longestBitonicSubsequence(new int[] { 1, 11, 2, 10, 4, 5, 2, 1 }));
		System.out.println(longestBitonicSubsequence(new int[] { 12, 11, 40, 5, 3, 1 }));
		System.out.println(longestBitonicSubsequence(new int[] { 80, 60, 30, 40, 20, 10 }));

	}
}
