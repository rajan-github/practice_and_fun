package strings.algorithms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PatternMatchingNaive {

	public static List<Integer> findPatternPositions(String text, String pattern) {
		List<Integer> indexes = new ArrayList<>();
		if (text != null && pattern != null && text.length() >= pattern.length()) {
			int shift = 0, textLength = text.length(), patternLength = pattern.length();
			for (shift = 0; shift <= (textLength - patternLength); shift++) {
				if (match(text, pattern, shift))
					indexes.add(shift);
			}
		}
		return indexes;
	}

	private static boolean match(String text, String pattern, int startIndex) {
		int patternLength = pattern.length();
		for (int start = startIndex; start < (startIndex + patternLength); start++) {
			if (text.charAt(start) != pattern.charAt(start - startIndex))
				return false;
		}
		return true;
	}

	/**
	 * Runs in O(n) time where n is the length of the text.
	 * 
	 * @param text
	 * @param pattern is made of distinct characters
	 * @return List of indexes where pattern starts in the text.
	 */
	public static List<Integer> findUniqueCharPatternPositions(String text, String pattern) {
		int textLength = text.length();
		List<Integer> indexes = new ArrayList<>();
		if (text == null || pattern == null || text.length() < pattern.length())
			return indexes;
		Map<Character, Set<Integer>> charIndexMap = new HashMap<>();
		for (int i = 0; i < textLength; i++) {
			char c = text.charAt(i);
			if (charIndexMap.containsKey(c))
				charIndexMap.get(c).add(i);
			else {
				Set<Integer> set = new HashSet<>();
				set.add(i);
				charIndexMap.put(c, set);
			}
		}
		char firstChar = pattern.charAt(0);
		if (!charIndexMap.containsKey(firstChar))
			return indexes;
		Set<Integer> indexSet = charIndexMap.get(firstChar);
		Iterator<Integer> iterator = indexSet.iterator();
		while (iterator.hasNext()) {
			int index = iterator.next();
			if (doesPatternExist(pattern, charIndexMap, index))
				indexes.add(index);
		}
		return indexes;
	}

	private static boolean doesPatternExist(String pattern, Map<Character, Set<Integer>> charIndexMap, int startIndex) {
		int patternLength = pattern.length(), previousIndex = startIndex;
		for (int i = 1; i < patternLength; i++) {
			char c = pattern.charAt(i);
			if (!charIndexMap.containsKey(c) || (!charIndexMap.get(c).contains(previousIndex + 1)))
				return false;
			previousIndex += 1;
		}
		return true;
	}

	/**
	 * Match pattern with gap character in the text in polynomial time. Note gap
	 * character can match 0 or more characters (any character) in the text. Text
	 * doesn't have any gap characters while pattern can have any number of gap
	 * characters.
	 * 
	 * @param text
	 * @param pattern
	 * @return
	 */
	public static boolean patternWithGapCharacter(String text, String pattern) {
		if (text == null || pattern == null)
			return false;
		int patternLength = pattern.length(), textLength = text.length(), patternIndex = 0, textIndex = 0;
		while (patternIndex < patternLength && textIndex < textLength) {
			char p = pattern.charAt(patternIndex);
			char t = text.charAt(textIndex);
			if (p == '*')
				patternIndex++;
			else if (p == t) {
				patternIndex++;
				textIndex++;
			} else
				textIndex++;
		}
		return patternIndex >= patternLength;
	}

	public static void main(String[] args) {
		System.out.println(findPatternPositions("aaaaaaaaaaaaa", "aaa"));
		System.out.println(findPatternPositions("", "aaa"));
		System.out.println(findPatternPositions("aaabcdaaa", "aaa"));

		System.out.println(findUniqueCharPatternPositions("aaaaaaaaaaaaa", "aaa"));
		System.out.println(findUniqueCharPatternPositions("", "aaa"));
		System.out.println(findUniqueCharPatternPositions("aaabcdaaa", "aaa"));

		System.out.println(patternWithGapCharacter("cabccbacbacab", "ab*ba*c"));
		System.out.println(patternWithGapCharacter("cabccbacbacab", "*"));
	}

}
