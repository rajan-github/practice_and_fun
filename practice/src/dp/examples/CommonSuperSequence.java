package dp.examples;

/**
 * Let A[1.. m] and B[1.. n] be two arbitrary arrays. A common super- sequence
 * of A and B is another sequence that contains both A and B as subsequences.
 * Describe an efficient algorithm to compute the length of the shortest common
 * supersequence of A and B.
 * 
 * @author rajan-c
 *
 */
public class CommonSuperSequence {
	public static int smallestCommonSuperSequence(String str1, String str2) {
		if (str1 == str2)
			return 0;
		if (str1 == null)
			return str2.length();
		if (str2 == null)
			return str1.length();
		int length1 = str1.length();
		int length2 = str2.length();
		int[][] dp = new int[length1 + 1][length2 + 1];

		for (int i = 0; i < dp.length; i++)
			dp[i][0] = i;
		for (int i = 0; i < dp[0].length; i++)
			dp[0][i] = i;

		for (int col = 1; col < dp[0].length; col++) {
			for (int row = 1; row < dp.length; row++) {
				if (str1.charAt(row - 1) == str2.charAt(col - 1))
					dp[row][col] = 1 + dp[row - 1][col - 1];
				else
					dp[row][col] = 1 + Math.min(dp[row][col - 1], dp[row - 1][col]);
			}
		}
		return dp[length1][length2];
	}

	public static void main(String[] args) {
		System.out.println(smallestCommonSuperSequence("abcd", "abc"));
		System.out.println(smallestCommonSuperSequence("abac", "cab"));
		System.out.println(smallestCommonSuperSequence("bcacaaab", "bbabaccc"));
	}
}
