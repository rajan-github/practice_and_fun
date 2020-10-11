package dp.examples;

import java.util.Arrays;

/**
 * Given an array of integers and you can jump from the current index to another
 * index either left or right by the current value of the index. For example -
 * if you have something like [3,2,4,1,5]. So from index[4] i.e val = 1, I can
 * take a left and come to 4 or come to 5 (jumping 1 in either direction). Now,
 * given a start and end point we need to find the smallest number of steps to
 * reach the end point.
 * 
 * @author rajan-c
 *
 */
public class SmallestStepToDestination {
	public static long smallestStepToDestination(int[] array, int start, int end) {
		long[][] dp = new long[array.length][array.length];
		for (int i = 0; i < array.length; i++)
			Arrays.fill(dp[i], -1);
		return smallestStepToDestination(array, start, end, dp);
	}

	private static long smallestStepToDestination(int[] array, int start, int end, long[][] dp) {
		if (start < 0 || start >= array.length)
			return Integer.MAX_VALUE;
		if (dp[start][end] >= 0)
			return dp[start][end];
		else if (start == end)
			return 0;
		long minStep = 1 + Math.min(smallestStepToDestination(array, start + (array[start]), end, dp),
				smallestStepToDestination(array, start - (array[start]), end, dp));
		dp[start][end] = minStep;
		return minStep;
	}

	public static void main(String[] args) {
		System.out.println(smallestStepToDestination(new int[] { 3, 2, 4, 1, 5 }, 0, 4));
		System.out.println(smallestStepToDestination(new int[] { 3, 2, 4, 1, 5 }, 4, 0));
	}
}
