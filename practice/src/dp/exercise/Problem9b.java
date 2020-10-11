package dp.exercise;

import java.util.Arrays;

public class Problem9b {
	public static int smallestSupersequenceLength(String str) {
		long[][] dp = new long[str.length() + 1][str.length() + 1];

		for (long[] row : dp)
			Arrays.fill(row, Integer.MAX_VALUE);

		for (int i = dp.length - 1; i > 0; i--) {
			for (int j = i; j < dp[0].length; j++) {
				if (i == j)
					dp[i][j] = 0;
				else if (str.charAt(i - 1) == str.charAt(j - 1))
					dp[i][j] = dp[i + 1][j - 1];
				else
					dp[i][j] = 1 + Math.min(dp[i + 1][j], dp[i][j - 1]);

			}
		}
		return str.length() + (int) dp[1][str.length()];
	}

	public static void main(String[] args) {
		System.out.println(smallestSupersequenceLength("TWENTYONE"));
		System.out.println(smallestSupersequenceLength("abc"));
		System.out.println(smallestSupersequenceLength("aba"));
		System.out.println(smallestSupersequenceLength("race"));
	}
}
