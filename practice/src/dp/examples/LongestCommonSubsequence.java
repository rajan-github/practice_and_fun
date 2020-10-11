package dp.examples;

public class LongestCommonSubsequence {
	public static int longestCommonSubsequence(String str1, String str2) {
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];

		for (int col = length2 - 1; col >= 0; col--) {
			for (int row = length1 - 1; row >= 0; row--) {
				if (str1.charAt(row) == str2.charAt(col))
					dp[row][col] = 1 + dp[row + 1][col + 1];
				else
					dp[row][col] = Math.max(dp[row][col + 1], dp[row + 1][col]);
			}
		}
		return dp[0][0];
	}

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abcdefg", "xayczdkemg"));
		System.out.println(longestCommonSubsequence("abcd", "abcd"));
		System.out.println(longestCommonSubsequence("abcd", "kappa"));
	}
}
