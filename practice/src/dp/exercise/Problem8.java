package dp.exercise;

public class Problem8 {
	public static int longestContiguousSubstring(String str) {
		if (str == null || str.length() == 0)
			return 0;
		int length = str.length();
		int longestString = 0;
		for (int i = 0; i < length; i++) {
			for (int j = length - 1; j > i; j--) {
				if (str.charAt(i) == str.charAt(j))
					longestString = Math.max(longestString, longestContiguousSubstring(str, i, j));
			}
		}
		return longestString;
	}

	private static int longestContiguousSubstring(String str, int start, int end) {
		if (start >= end)
			return 0;
		if (str.charAt(start) == str.charAt(end))
			return 1 + longestContiguousSubstring(str, start + 1, end - 1);
		else if (str.charAt(start) == str.charAt(end - 1) && str.charAt(start + 1) == str.charAt(end))
			return Math.max(longestContiguousSubstring(str, start, end - 1),
					longestContiguousSubstring(str, start + 1, end));
		else if (str.charAt(start) == str.charAt(end - 1))
			return longestContiguousSubstring(str, start, end - 1);
		else if (str.charAt(start + 1) == str.charAt(end))
			return longestContiguousSubstring(str, start + 1, end);
		else
			return 0;
	}

	public static void main(String[] args) {
		System.out.println(longestContiguousSubstring("ALGORITHM"));
		System.out.println(longestContiguousSubstring("RECURSION"));
		System.out.println(longestContiguousSubstring("REDIVIDE"));
		System.out.println(longestContiguousSubstring("DYNAMICPROGRAMMINGMANYTIMES"));
	}
}
