package dp.examples;

public class LongestOscillatingSubsequence {
	public static int longestOscillatingSubseq(int[] array) {

		int[] extendedArray = new int[array.length + 1];
		for (int i = 0; i < array.length; i++)
			extendedArray[i + 1] = array[i];

//		boolean isOdd = true;
//		int[][] dp = new int[array.length + 1][array.length + 1];
		return 0;
	}
}
