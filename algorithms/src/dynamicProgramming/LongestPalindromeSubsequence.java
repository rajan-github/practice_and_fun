package dynamicProgramming;

public class LongestPalindromeSubsequence {

	public static int getlps(String lps) {
		if (lps == null)
			return 0;
		else if (lps.length() <= 1)
			return lps.length();
		else {
			if (lps.charAt(0) == lps.charAt(lps.length() - 1))
				return 2 + getlps(lps.substring(1, lps.length() - 1));
			else {
				return Math.max(getlps(lps.substring(1)), getlps(lps.substring(0, lps.length() - 1)));
			}
		}
	}

	public static void main(String[] main) {
		System.out.println(getlps("character"));
	}

}
