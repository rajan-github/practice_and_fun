package dp.examples;

import java.util.Arrays;

public class Knapsack01 {
	// items[0]-weight and items[1] is value.
	public static int maximumSackValue(int[][] items, int capacity) {
		int totalItems = items.length;
		int[][] dp = new int[totalItems][capacity + 1];
		Arrays.sort(items, (x, y) -> Integer.compare(x[0], y[0]));
		for (int i = 0; i < dp[0].length; i++)
			if (i < items[0][0])
				dp[0][i] = 0;
			else
				dp[0][i] = items[0][1];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				if (items[i][0] > j)
					dp[i][j] = dp[i - 1][j];
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1]);
			}
		}
		return dp[items.length - 1][capacity];
	}

	public static void main(String[] args) {
		int[][] items = new int[][] { { 1, 3 }, { 2, 2 }, { 3, 2 } };
		System.out.println(maximumSackValue(items, 5));
		items = new int[][] { { 10, 60 }, { 20, 100 }, { 30, 120 } };
		System.out.println(maximumSackValue(items, 50));
	}
}
