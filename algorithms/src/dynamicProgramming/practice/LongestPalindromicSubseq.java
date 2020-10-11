package dynamicProgramming.practice;

public class LongestPalindromicSubseq {
	public int longestPalindromeSubseq(String s) {
		if (s == null || s.length() == 0)
			return 0;
//		return longestPalindromeSubseq(s, 0);
		return 0;
	}

	private String longestPalindromeSubseq(String s, int startIndex) {
		if (startIndex >= s.length())
			return "";
		
		
		return "";
	}

	private static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right && s.charAt(left) == s.charAt(right)) {
			left++;
			right--;
		}
		return left >= right;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("a"));
		System.out.println(isPalindrome("aa"));
		System.out.println(isPalindrome("cac"));
		System.out.println(isPalindrome("caac"));
		System.out.println(isPalindrome("ab"));
	}
}
