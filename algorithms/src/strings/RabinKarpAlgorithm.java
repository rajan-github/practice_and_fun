package strings;

import java.util.ArrayList;
import java.util.List;

public class RabinKarpAlgorithm {
	public static List<Integer> match(String text, String pattern, int d, int q) {
		List<Integer> indexes = new ArrayList<>();
		int patternLength = pattern.length(), textLength = text.length();
		int h = ((int) Math.pow(d, patternLength - 1) % q);

		long patternValue = 0, textValue = 0;

		for (int i = 0; i < patternLength; i++) {
			patternValue += (patternValue * Math.pow(d, i) + pattern.charAt(i)) % q;
			textValue += (textValue * Math.pow(d, i) + text.charAt(i)) % q;
		}
		int i = 1;
		while (i <= (textLength - patternLength)) {
			if (patternValue == textValue && pattern.equals(text.substring(i - 1, i - 1 + patternLength)))
				indexes.add(i - 1);
			textValue = ((textValue - (text.charAt(i - 1) * h)) * d + text.charAt(i + patternLength - 1)) % q;
			if (textValue < 0)
				textValue += q;
			i++;
		}
		if (patternValue == textValue && pattern.equals(text.substring(i - 1, i - 1 + patternLength)))
			indexes.add(i - 1);

		return indexes;
	}

	public static void main(String[] args) {
		System.out.println(match("13345613", "13", 256, 101));
	}
}
