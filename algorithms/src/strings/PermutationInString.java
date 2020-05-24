package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s1 and s2, write a function to return true if s2 contains
 * the permutation of s1. In other words, one of the first string's permutations
 * is the substring of the second string.
 * 
 * @author rajan-c
 *
 */
public class PermutationInString {
	public static boolean checkInclusion(String s1, String s2) {
		if (s1.equals(s2))
			return true;
		else if (s1.length() > s2.length())
			return false;
		int length2 = s2.length(), length1 = s1.length();
		Map<Character, Integer> map = new HashMap<>(), subStringMap = new HashMap<>();
		for (int index = 0; index < length1; index++) {
			char c = s1.charAt(index);
			if (subStringMap.containsKey(c))
				subStringMap.replace(c, subStringMap.get(c) + 1);
			else
				subStringMap.put(c, 1);
		}
		for (int i = 0; i <= (length2 - length1); i++) {
			if (i == 0) {
				for (int index = 0; index < length1; index++) {
					char c = s2.charAt(index);
					if (map.containsKey(c))
						map.replace(c, map.get(c) + 1);
					else
						map.put(c, 1);
				}
			} else {
				char previous = s2.charAt(i - 1);
				if (map.get(previous) > 1)
					map.replace(previous, map.get(previous) - 1);
				else
					map.remove(previous);
				char current = s2.charAt(i + length1 - 1);
				if (map.containsKey(current))
					map.replace(current, map.get(current) + 1);
				else
					map.put(current, 1);
			}
			if (isPermutation(subStringMap, map))
				return true;
		}
		return false;
	}

	private static boolean isPermutation(Map<Character, Integer> subStringMap, Map<Character, Integer> stringMap) {
		for (Map.Entry<Character, Integer> entry : subStringMap.entrySet())
			if (!stringMap.containsKey(entry.getKey()) || !stringMap.get(entry.getKey()).equals(entry.getValue()))
				return false;
		return true;
	}

	public static void main(String[] args) {
		System.out.println(checkInclusion("ab", "eidbaooo"));
		System.out.println(checkInclusion("ba", "eidboaoo"));
		System.out.println(checkInclusion("ba", "aabb"));
		System.out.println(checkInclusion("abcdxabcde", "abcdeabcdx"));
		System.out.println(checkInclusion("rvwrk", "lznomzggwrvrkxecjaq"));

		System.out.println(checkInclusion("", ""));
	}
}
