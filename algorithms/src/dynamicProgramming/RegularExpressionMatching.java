package dynamicProgramming;

/**
 * Given an input string (s) and a pattern (p), implement regular expression
 * matching with support for '.' and '*'.
 * 
 * '.' Matches any single character. '*' Matches zero or more of the preceding
 * element. The matching should cover the entire input string (not partial).
 * 
 * Note:
 * 
 * s could be empty and contains only lowercase letters a-z. p could be empty
 * and contains only lowercase letters a-z, and characters like . or *.
 * 
 * @author rajan-c
 *
 */
public class RegularExpressionMatching {
	public static boolean isMatch(String s, String p) {
		if (s.equals(p))
			return true;
		return isMatch(s, p, 0, 0);
	}

	private static boolean isMatch(String s, String p, int i, int j) {
		if (i >= s.length() && j >= p.length())
			return true;
		else if (i >= s.length() && j > 0 && p.charAt(j - 1) != '*' && j < p.length() && p.charAt(j) == '*')
			return isMatch(s, p, i, j + 1);
		else if (i >= s.length() && j < p.length() - 1 && p.charAt(j) != '*' && p.charAt(j + 1) == '*')
			return isMatch(s, p, i, j + 2);
		else if ((i >= s.length() && j < p.length()) || (i < s.length() && j >= p.length()))
			return false;

		else {
			if (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
				return isMatch(s, p, i + 1, j + 1);
			else if (j > 0 && p.charAt(j) == '*' && (p.charAt(j - 1) == s.charAt(i) || p.charAt(j - 1) == '.'))
				return isMatch(s, p, i + 1, j) || isMatch(s, p, i + 1, j + 1) || isMatch(s, p, i, j + 1);
			else if (j > 0 && p.charAt(j) == '*' && p.charAt(j - 1) != s.charAt(i))
				return isMatch(s, p, i, j + 1);
			else if (s.charAt(i) != p.charAt(j) && j < p.length() - 1 && p.charAt(j + 1) == '*')
				return isMatch(s, p, i, j + 2);
			else
				return false;
		}
	}

	public static void main(String[] args) {
//		System.out.println(isMatch("aa", "a"));
//		System.out.println(isMatch("aa", "a*"));
//		System.out.println(isMatch("ab", ".*"));
//		System.out.println(isMatch("aab", "c*a*b"));
//		System.out.println(isMatch("mississippi", "mis*is*p*."));
//		System.out.println(isMatch("mississippi", "mis*is*ip*."));

//		System.out.println(isMatch("a", "ab*"));

//		System.out.println(isMatch("aa", ".ab*"));
		System.out.println(isMatch("bbbb", ".*a*a"));
	}
}
