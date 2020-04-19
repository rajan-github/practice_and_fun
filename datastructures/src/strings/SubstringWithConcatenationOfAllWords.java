package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubstringWithConcatenationOfAllWords {
	public static List<Integer> findSubstring(String s, String[] words) {
		List<Integer> indexes = new ArrayList<Integer>();
		if (s == null || words == null || words.length == 0)
			return indexes;
		int wordLength = words[0].length(), subLength = wordLength * words.length;

		for (int i = 0; i <= s.length() - subLength; i++) {
			String[] subStrings = getSubstrings(s, i, wordLength, subLength);
			Arrays.sort(subStrings);
			Arrays.sort(words);
			if (isEqual(subStrings, words)) {
				indexes.add(i);
			}
		}
		return indexes;
	}

	private static boolean isEqual(String[] subStrings, String[] words) {
		boolean equal = true;
		for (int i = 0; i < subStrings.length; i++) {
			if (!subStrings[i].equals(words[i])) {
				equal = false;
				break;
			}
		}
		return equal;
	}

	private static String[] getSubstrings(String s, int index, int wordLength, int subLength) {
		String[] subStrings = new String[(subLength / wordLength)];
		for (int i = index, k = 0; i < (index + subLength); i += wordLength, k++) {
			subStrings[k] = s.substring(i, i + wordLength);
		}
		return subStrings;
	}

	public static void main(String[] args) {
//		System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[] { "word", "good", "best", "word" }));
		System.out.println(findSubstring("barfoothefoobarman", new String[] { "foo", "bar" }));

		System.out.println(findSubstring("manfoothefoomanman", new String[] { "foo", "bar" }));
		System.out.println(findSubstring("barfoothemanbarman", new String[] { "foo", "bar" }));
		System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake",
				new String[] { "fooo", "barr", "wing", "ding", "wing" }));
	}
}
