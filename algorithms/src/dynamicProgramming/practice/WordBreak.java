package dynamicProgramming.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of
 * non-empty words, determine if s can be segmented into a space-separated
 * sequence of one or more dictionary words.
 * 
 * Note:
 * 
 * The same word in the dictionary may be reused multiple times in the
 * segmentation. You may assume the dictionary does not contain duplicate words.
 * Example 1:Input: s = "applepenapple", wordDict = ["apple", "pen"] Output:
 * true
 * 
 * @author rajan-c
 *
 */
public class WordBreak {
	public static boolean wordBreak(String s, List<String> wordDict) {
		if (wordDict == null)
			return false;
		Set<String> set = new HashSet<>();
		for (String word : wordDict)
			set.add(word);
		return wordBreak(s, set, new HashMap<String, Boolean>());
	}

	public static boolean wordBreak(String s, Set<String> wordDict, Map<String, Boolean> segmented) {
		if (wordDict.contains(s))
			return true;
		else if (segmented.containsKey(s))
			return segmented.get(s);
		int length = s.length();
		for (int i = 0; i < length; i++) {
			String word = s.substring(0, i + 1), remaining = s.substring(i + 1);
			if (wordDict.contains(word) && wordBreak(remaining, wordDict, segmented)) {
				segmented.put(s, true);
				return true;
			}
		}
		segmented.put(s, false);
		return false;
	}

	public static void main(String[] args) {

		System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab", Arrays.asList(

				"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa")));
	}
}
