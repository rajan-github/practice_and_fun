package dynamicProgramming.practice;

public class IsSubsequence {
	public static boolean isSubsequence(String t, String s) {
		if (s == t || s.equals(t))
			return true;
		else if (s.length() < t.length())
			return false;
		int stringLength = s.length(), subLength = t.length();
		int subIndex = 0, stringIndex = 0;
		while (subIndex < subLength && stringIndex < stringLength) {
			if (s.charAt(stringIndex) == t.charAt(subIndex)) {
				stringIndex++;
				subIndex++;
			} else
				stringIndex++;
		}
		return subIndex >= subLength;
	}

	public static void main(String[] args) {
		System.out.println(isSubsequence("abc", "ahbgdc"));
	}
}
