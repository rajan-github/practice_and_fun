package dynamicProgramming.practice;

import java.util.HashSet;
import java.util.Set;

public class UniqueSubstringInWrapAround {
	public static int findSubstringInWraproundString(String p) {
		if (p == null || p.length() == 0)
			return 0;
		int count = 0;

		return count;
	}

	static int count = 0;

	private static int findSubstringInWraproundString(String p, int startIndex, int endIndex, Set<String> subtrings) {
		if (startIndex == endIndex) {
			subtrings.add(p.charAt(startIndex) + "");
			return 1;
		} else if (startIndex > endIndex)
			return 0;

		int count = 0;
		for (int i = startIndex; i < endIndex; i++) {
			int leftResult = findSubstringInWraproundString(p, startIndex, i, subtrings);
			int rightResult = findSubstringInWraproundString(p, i + 1, endIndex, subtrings);
			if (leftResult >= (i - startIndex + 1))
				subtrings.add(p.substring(startIndex, i + 1));
			count += leftResult;
			if (rightResult >= (endIndex - i))
				subtrings.add(p.substring(i + 1, endIndex + 1));
			count += rightResult;
			if (leftResult >= (i - startIndex + 1) && rightResult >= (endIndex - i)
					&& p.charAt(i) + 1 == p.charAt(i + 1)) {
				subtrings.add(p.substring(startIndex, endIndex + 1));
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		Set<String> set = new HashSet<>();
//		findSubstringInWraproundString("abc", 0, 2, set);
		findSubstringInWraproundString("cac", 0, 2, set);
		System.out.println(set);
		System.out.println(set.size());
	}
}
