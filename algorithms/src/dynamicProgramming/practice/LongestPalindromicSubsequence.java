package dynamicProgramming.practice;

/**
 * Given a string s, find the longest palindromic subsequence's length in s. You
 * may assume that the maximum length of s is 1000.
 * 
 * @author rajan-c
 *
 */
public class LongestPalindromicSubsequence {
	public int longestPalindromeSubseq(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int[][] memory = new int[s.length()][s.length()];
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory.length; j++)
				memory[i][j] = -1;
		}
		return longestPalindromeSubseq(s, 0, s.length() - 1, memory);
	}

	private int longestPalindromeSubseq(String s, int start, int end, int[][] memory) {
		if (start > end)
			return 0;
		if (memory[start][end] >= 0)
			return memory[start][end];
		int longestPalindrome = Integer.MIN_VALUE;
		if (s.charAt(start) == s.charAt(end))
			longestPalindrome = Math.max(longestPalindrome,
					(start == end ? 1 : 2) + longestPalindromeSubseq(s, start + 1, end - 1, memory));
		else {
			longestPalindrome = Math.max(longestPalindrome, longestPalindromeSubseq(s, start + 1, end, memory));
			longestPalindrome = Math.max(longestPalindrome, longestPalindromeSubseq(s, start, end - 1, memory));
		}
		memory[start][end] = longestPalindrome;
		return longestPalindrome;
	}
}
