package dp.examples;

/**
 * Compute minimum edit distance between two strings.
 * 
 * @author rajan-c
 *
 */
public class EditDistance {
	public static int minEditDistance(String str1, String str2) {
		int length1 = str1.length(), length2 = str2.length();

		int[][] dp = new int[length1 + 1][length2 + 1];

		for (int i = 0; i <= length2; i++)
			dp[0][i] = i;
		for (int i = 0; i <= length1; i++)
			dp[i][0] = i;

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				dp[i][j] = min(1 + dp[i][j - 1], 1 + dp[i - 1][j],
						dp[i - 1][j - 1] + (str1.charAt(i - 1) == str2.charAt(j - 1) ? 0 : 1));
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	private static int min(int a, int b, int c) {
		if (a <= b && a <= c)
			return a;
		else if (b <= a && b <= c)
			return b;
		else
			return c;
	}

	public static void main(String[] args) {
		System.out.println(minEditDistance("algorithm", "altruistic"));
		System.out.println(minEditDistance("FOOD", "MONEY"));
	}
}
