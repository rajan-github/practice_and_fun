package dp.examples;

/**
 * Longest Increasing Subsequence.
 * 
 * @author rajan-c
 *
 */
public class LongestIncreasingSubsequence {
	public static int longestIncreasingSubsequence(int[] array) {
		int length = array.length;
		int[][] dp = new int[length + 2][length + 2];
		int[] newArray = new int[array.length + 1];

		newArray[0] = Integer.MIN_VALUE;

		for (int i = 0; i < array.length; i++)
			newArray[i + 1] = array[i];

		for (int j = dp.length - 2; j > 0; j--) {
			for (int i = 0; i <= length; i++)
				if (newArray[j] > newArray[i])
					dp[i][j] = Math.max(dp[i][j + 1], 1 + dp[j][j + 1]);
				else
					dp[i][j] = Math.max(dp[i][j], dp[i][j + 1]);
		}
		return dp[0][1];
	}

	public static void main(String[] args) {
		System.out.println(longestIncreasingSubsequence(new int[] { 1, 2, 3, 4, 5 }));
		System.out.println(longestIncreasingSubsequence(new int[] { 5, 4, 3, 2, 1 }));
		System.out.println(longestIncreasingSubsequence(new int[] { 1, 7, 2, 8, 3, 6, 4, 5 }));
	}
}
