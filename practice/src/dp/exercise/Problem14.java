package dp.exercise;

import java.util.Arrays;

public class Problem14 {
	public static int swapPuzzle(int[] candies, int myCandy) {
		int[][] dp = new int[3][candies.length + 1];
		for (int i = 0; i < 3; i++)
			dp[i][dp[0].length - 1] = (i == myCandy) ? 1 : 0;

		for (int i = dp[0].length - 2; i > 0; i--) {
			int index = i - 1;
			int scoreWithSwap = (candies[index] == myCandy ? 1 : -1) + dp[candies[index]][i + 1];
			int scoreWithoutSwap = dp[myCandy][i + 1];
			if (scoreWithSwap > scoreWithoutSwap) {
				myCandy = candies[index];
				dp[myCandy][i] = scoreWithSwap;
			} else
				dp[myCandy][i] = scoreWithoutSwap;
		}

		for (int i = 0; i < 3; i++) {
			System.out.println(Arrays.toString(dp[i]));
		}
		return dp[myCandy][1];
	}

	private static int swapPuzzle(int[] candies, int myCandy, int index) {
		if (index >= candies.length)
			return 0;
		int scoreWithSwap = (candies[index] == myCandy ? 1 : -1) + swapPuzzle(candies, candies[index], index + 1);
		int scoreWithoutSwap = swapPuzzle(candies, myCandy, index + 1);
		return Math.max(scoreWithSwap, scoreWithoutSwap);
	}

	public static void main(String[] args) {
		int[] candies = new int[] { 1, 1, 1, 1, 1 };
		System.out.println(swapPuzzle(candies, 1));
		System.out.println(swapPuzzle(candies, 2));
	}
}
