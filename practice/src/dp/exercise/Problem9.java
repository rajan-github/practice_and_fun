package dp.exercise;

public class Problem9 {
	public static int longestPalindromeSubsequence(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int length = str.length();
		int[][] dp = new int[length + 1][length + 1];
		for (int i = dp.length - 1; i > 0; i--) {
			for (int j = i; j < dp[0].length; j++) {
				if (i == j)
					dp[i][j] = 1;
				else if (str.charAt(i - 1) == str.charAt(j - 1))
					dp[i][j] = 2 + dp[i + 1][j - 1];
				else
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
			}
		}

		return dp[1][dp[0].length - 1];
	}

	public static void main(String[] args) {
		System.out.println(longestPalindromeSubsequence("abba"));
		System.out.println(longestPalindromeSubsequence("abcd"));
		System.out.println(longestPalindromeSubsequence("MAHDYNAMICPROGRAMZLETMESHOWYOUTHEM"));

	}
}
