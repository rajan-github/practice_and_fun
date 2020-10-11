package dp.examples;

import java.util.Arrays;

public class SubsetSum {
	public static boolean subsetSum(int[] array, int target) {
		if (array == null || array.length == 0)
			return target == 0;
		Arrays.sort(array);
		boolean[][] dp = new boolean[array.length + 1][target + 1];

		for (int i = 0; i < dp[0].length; i++)
			dp[array.length - 1][i] = (array[array.length - 1] == i);

		for (int i = 0; i < dp.length; i++)
			dp[i][0] = true;

		for (int i = array.length - 2; i >= 0; i--) {
			for (int t = 1; t <= target; t++) {
				int lastIndex = t - array[i];
				dp[i][t] = (dp[i + 1][t]
						|| ((lastIndex < dp[0].length && lastIndex >= 0) ? dp[i + 1][t - array[i]] : false));
			}
		}
		return dp[0][target];
	}

	public static void main(String[] args) {
		System.out.println(subsetSum(new int[] { 1, 5, 10 }, 16));
		System.out.println(subsetSum(new int[] { 1, 5, 10 }, 15));
		System.out.println(subsetSum(new int[] { 1, 5, 10 }, 10));
		System.out.println(subsetSum(new int[] { 1, 5, 10 }, 6));
		System.out.println(subsetSum(new int[] { 1, 5, 10 }, 11));
	}
}
