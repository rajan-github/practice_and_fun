package dp.examples;

public class Shuffle {
	public static boolean isShuffle(String a, String b, String c) {
		int lengtha = a.length();
		int lengthb = b.length();
		int lengthc = c.length();

		if (lengthc != lengtha + lengthb)
			return false;

		boolean[][] dp = new boolean[lengtha + 1][lengthb + 1];
		dp[0][0] = true;
		for (int i = 1; i <= lengthb; i++)
			if (b.charAt(i - 1) == c.charAt(i - 1))
				dp[0][i] = dp[0][i - 1];

		for (int i = 1; i <= lengtha; i++)
			if (a.charAt(i - 1) == c.charAt(i - 1))
				dp[i][0] = dp[i - 1][0];

		for (int i = 1; i < dp.length; i++) {
			for (int j = 1; j < dp[0].length; j++) {
				int k = i + j;
				if (a.charAt(i - 1) == c.charAt(k - 1))
					dp[i][j] = dp[i - 1][j];
				else if (b.charAt(j - 1) == c.charAt(k - 1))
					dp[i][j] = dp[i][j - 1];
			}
		}
		return dp[dp.length - 1][dp[0].length - 1];
	}

	/**
	 * To down approach.
	 * 
	 * @param a
	 * @param b
	 * @param c
	 * @param i
	 * @param j
	 * @param k
	 * @param memory
	 * @return
	 */
	public static boolean isShuffle(String a, String b, String c, int i, int j, int k, Boolean[][][] memory) {
		if (k < 0)
			return (i < 0 && j < 0);
		else if (i < 0 && j < 0)
			return false;
		if (i >= 0 && j >= 0 && k >= 0 && memory[i][j][k] != null)
			return memory[i][j][k];

		char chara = (i >= 0) ? a.charAt(i) : '0';
		char charb = (j >= 0) ? b.charAt(j) : '0';
		char charc = (k >= 0) ? c.charAt(k) : '0';
		boolean doesMatch = false;
		if (chara == charb && charc == chara)
			doesMatch = doesMatch
					|| (isShuffle(a, b, c, i - 1, j, k - 1, memory) || isShuffle(a, b, c, i, j - 1, k - 1, memory));
		else if (chara == charc)
			doesMatch = doesMatch || isShuffle(a, b, c, i - 1, j, k - 1, memory);
		else if (charb == charc)
			doesMatch = doesMatch || isShuffle(a, b, c, i, j - 1, k - 1, memory);
		if (i >= 0 && j >= 0 && k >= 0)
			memory[i][j][k] = doesMatch;
		return doesMatch;
	}

	public static void main(String[] args) {
		System.out.println(isShuffle("BANANA", "ANANAS", "BANANAANANAS"));
		System.out.println(isShuffle("BANANA", "ANANAS", "BANANAANANAS"));
		System.out.println(isShuffle("BANANA", "ANANAS", "BANANAANANAS"));
		System.out.println(isShuffle("ab", "eg", "aebf"));
	}
}
