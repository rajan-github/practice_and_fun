package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Combination {
	public static List<String> combinations(String str, int length, int index) {
		if (str == null || length == 0 || length > str.length())
			return new ArrayList<>();
		int stringLength = str.length();
		List<String> combinations = new ArrayList<>();
		if (length == 1) {
			for (int i = index; i < stringLength; i++)
				combinations.add("" + str.charAt(i));
			return combinations;
		}
		for (int i = index; i <= (stringLength - length); i++) {
			List<String> temp = combinations(str, length - 1, i + 1);
			for (String s : temp) {
				StringBuilder builder = new StringBuilder();
				builder.append(str.charAt(i));
				builder.append(s);
				combinations.add(builder.toString());
			}
		}
		return combinations;
	}

	public static void main(String[] args) {
		List<String> combinations = combinations("abcd", 2, 0);
		System.out.println(combinations);
	}
}
