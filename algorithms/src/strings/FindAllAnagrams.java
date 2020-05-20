package strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a string s and a non-empty string p, find all the start indices of p's
 * anagrams in s.
 * 
 * Strings consists of lowercase English letters only and the length of both
 * strings s and p will not be larger than 20,100.
 * 
 * The order of output does not matter.
 * 
 * @author rajan-c
 *
 */
public class FindAllAnagrams {
	public static List<Integer> findAnagrams(String s, String p) {
		List<Integer> anagramIndexes = new ArrayList<>();
		if (s != null && p != null && s.length() >= p.length()) {
			int stringLength = s.length(), anagramLength = p.length();
			if (stringLength > 0 && anagramLength > 0) {
				char[] anagram = p.toCharArray();
				Arrays.sort(anagram);
				for (int i = 0; i <= (stringLength - anagramLength); i++) {
					char[] subArray = s.substring(i, i + anagramLength).toCharArray();
					Arrays.sort(subArray);
					if (doesMatch(subArray, anagram))
						anagramIndexes.add(i);
				}
			}
		}
		return anagramIndexes;
	}

	private static boolean doesMatch(char[] array, char[] anagram) {
		int arrayLength = array.length;
		for (int i = 0; i < arrayLength; i++)
			if (array[i] != anagram[i])
				return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(findAnagrams("cbaebabacd", "abc"));
		System.out.println(findAnagrams("", ""));
	}
}
