package dp.examples;

import java.util.Arrays;

public class ActivitySelection {
	public static int maximumCompatibleActivities(int[] start, int[] finish) {
		int[][] dp = new int[start.length + 1][finish.length + 1];

		for (int j = 0; j < start.length; j++)
			dp[start.length][j] = 1;

		for (int i = start.length - 1; i >= 0; i--) {
			for (int j = 0; j < i; j++) {
				if (start[i] >= finish[j])
					dp[i][j] = Math.max(1 + dp[i + 1][i], dp[i + 1][j]);
				else
					dp[i][j] = dp[i + 1][j];
			}
		}
		for (int[] row : dp)
			System.out.println(Arrays.toString(row));
		return dp[1][0];
	}

	public static void main(String[] args) {
		int[] start = new int[] { 1, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
		int[] finish = new int[] { 4, 5, 6, 7, 9, 9, 10, 11, 12, 14, 16 };
		System.out.println(maximumCompatibleActivities(start, finish));
	}
}
