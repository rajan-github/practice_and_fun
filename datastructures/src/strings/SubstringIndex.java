package strings;

/**
 * Return the index of the first occurrence of needle in haystack, or -1 if
 * needle is not part of haystack.
 * 
 * @author rajan-c
 *
 */
public class SubstringIndex {
	public static int strStr(String haystack, String needle) {
		if (needle != null && needle.length() == 0)
			return 0;
		else if (haystack.length() >= needle.length()) {
			int length = haystack.length();
			for (int i = 0; i <= (length - needle.length()); i++) {
				if (doesMatch(haystack, i, needle)) {
					return i;
				}
			}
		}
		return -1;
	}

	private static boolean doesMatch(String haystack, int i, String needle) {
		int matched = -1;
		for (int j = i; j < haystack.length() && matched < needle.length() - 1; j++) {
			if (haystack.charAt(j) == needle.charAt(matched + 1)) {
				matched += 1;
			} else
				break;
		}
		return matched == needle.length() - 1 ? true : false;
	}

	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
		System.out.println(strStr("aaaaa", "bba"));
		System.out.println(strStr("hello", ""));
		System.out.println(strStr("hello", "lo"));
	}
}
