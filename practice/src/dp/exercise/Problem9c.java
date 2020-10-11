package dp.exercise;

public class Problem9c {
	public static int minimumPalindromeParts(String str) {
		if (str == null || str.length() <= 1)
			return 1;
		boolean[][] palindromeArray = substringPalindrome(str);
		int length = str.length();
		int[][] palindromeCount = new int[length][length];

		for (int l = 1; l <= length; l++) {
			for (int i = 0; i <= length - l; i++) {
				int j = i + l - 1;
				if (palindromeArray[i][j])
					palindromeCount[i][j] = 1;
				else {
					int minCount = j - i + 1;
					for (int k = i; k < j; k++)
						minCount = Math.min(minCount, palindromeCount[i][k] + palindromeCount[k + 1][j]);
					palindromeCount[i][j] = minCount;
				}
			}
		}
		return palindromeCount[0][length - 1];
	}

	private static boolean[][] substringPalindrome(String str) {
		int length = str.length();
		boolean[][] isPalindrome = new boolean[length][length];
		for (int l = 1; l <= length; l++) {
			for (int i = 0; i <= length - l; i++) {
				int j = i + l - 1;
				if (i == j)
					isPalindrome[i][j] = true;
				else if (str.charAt(i) == str.charAt(j))
					isPalindrome[i][j] = (i + 1 <= j - 1) ? isPalindrome[i + 1][j - 1] : true;
				else
					isPalindrome[i][j] = false;
			}
		}
		return isPalindrome;
	}

	public static void main(String[] args) {
		System.out.println(minimumPalindromeParts("apa"));
		System.out.println(minimumPalindromeParts("BUBBASEESABANANA"));
	}
}
