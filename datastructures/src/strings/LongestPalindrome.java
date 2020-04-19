package strings;

public class LongestPalindrome {
	public static String longestPalindrome(String s) {
		if (isPalindrome(s))
			return s;
		else {
			int length = s.length();
			String largestPalidrome = "";
			for (int i = 0; i < length; i++) {
				String sub;
				int temp = length - 1;
				while (temp > i) {
					int k = temp;
					{
						while (k > i && s.charAt(i) != s.charAt(k))
							k--;
						temp = k - 1;
						sub = s.substring(i, k + 1);
						if (isPalindrome(sub) && sub.length() > largestPalidrome.length()) {
							largestPalidrome = sub;
							temp = i - 1; // break the loop
						}
					}
				}
			}
			return largestPalidrome;
		}
	}

	public static boolean isPalindrome(String s) {
		boolean isPalindrome = true;
		if (s != null && s.length() > 1) {
			int length = s.length() - 1, i = 0;
			while (i < length) {
				if (s.charAt(i) != s.charAt(length)) {
					isPalindrome = false;
					break;
				} else {
					i++;
					length--;
				}
			}
		}
		return isPalindrome;
	}

	public static void main(String[] args) {
		System.out.println(longestPalindrome("zzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz"));
	}
}
