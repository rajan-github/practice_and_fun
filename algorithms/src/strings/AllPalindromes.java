package strings;

import java.util.ArrayList;
import java.util.List;

/*
 * Generate all palindromes.
 */
public class AllPalindromes {
	public static List<List<String>> partition2(String s) {
		List<List<String>> partitions = new ArrayList<>();
		if (s != null && s.length() > 0) {
			int length = s.length();
			boolean[][] isPalindrome = new boolean[length][length];
			for (int l = 0; l < length; l++) {
				List<String> palindromes = new ArrayList<>();
				for (int i = 0; i < length; i++) {
					int j = (i + l) >= length ? length - 1 : (i + l);
					if (i == j)
						isPalindrome[i][j] = true;
					else if (i == length - 1 || j == 0 || j - i <= 1) {
						isPalindrome[i][j] = isPalindrome(s, i, j);
					} else if (isPalindrome[i + 1][j - 1] && s.charAt(i) == s.charAt(j))
						isPalindrome[i][j] = true;

					if (isPalindrome[i][j])
						palindromes.add(s.substring(i, j + 1));
				}
				if (!palindromes.isEmpty())
					partitions.add(palindromes);
			}
		}
		return partitions;
	}

	private static boolean isPalindrome(String s, int i, int j) {
		while (i < j && s.charAt(i) == s.charAt(j)) {
			i++;
			j--;
		}
		return i >= j;
	}
}
