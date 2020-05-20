package backtracking.practice;

/**
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters(can be none) deleted without changing the relative order
 * of the remaining characters. (eg, "ace" is a subsequence of "abcde" while
 * "aec" is not). A common subsequence of two strings is a subsequence that is
 * common to both strings.
 * 
 * 
 * 
 * If there is no common subsequence, return 0.
 * 
 * @author rajan-c
 *
 */
public class LongestCommonSubsequence {
	public static int longestCommonSubsequence(String text1, String text2) {
		if (text1 == null || text2 == null || text1.length() == 0 || text2.length() == 0)
			return 0;
		return lcs(text1, text2);
	}

	private static int lcs(String text1, String text2) {
		int[][] memory = new int[text1.length() + 1][text2.length() + 1];
		for (int i = 0; i < memory.length; i++)
			memory[i][0] = 0;

		for (int i = 0; i < memory[0].length; i++)
			memory[0][i] = 0;

		int rows = memory.length, cols = memory[0].length;
		for (int row = 1; row < rows; row++) {
			for (int col = 1; col < cols; col++) {
				if (text1.charAt(row - 1) == text2.charAt(col - 1))
					memory[row][col] = memory[row - 1][col - 1] + 1;
				else
					memory[row][col] = max(memory[row - 1][col], memory[row - 1][col - 1], memory[row][col - 1]);
			}
		}
		return memory[rows - 1][cols - 1];
	}

	private static int max(int a, int b, int c) {
		if (a > b && a > c)
			return a;
		else if (b > c && b > a)
			return b;
		else
			return c;
	}

	public static void main(String[] args) {
		System.out.println(longestCommonSubsequence("abc", "def"));

		System.out.println(longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
	}
}
