package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two strings s and t, determine if they are isomorphic.
 * 
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * 
 * All occurrences of a character must be replaced with another character while
 * preserving the order of characters. No two characters may map to the same
 * character but a character may map to itself.
 * 
 * @author rajan-c
 *
 */
public class IsIsomorphic {
	public static boolean isIsomorphic(String s, String t) {
		if (s == null && t == null)
			return true;
		else if (s == null || t == null)
			return false;
		int sLength = s.length(), tLength = t.length();
		if (sLength != tLength)
			return false;
		int index = 0;
		Map<Character, Character> charMap = new HashMap<>();
		Map<Character, Character> valueToKeyMap = new HashMap<>();
		while (index < sLength) {
			char c1 = s.charAt(index), c2 = t.charAt(index);
			if (charMap.containsKey(c1) && valueToKeyMap.containsKey(c2)) {
				if (c1 != valueToKeyMap.get(c2) || c2 != charMap.get(c1))
					return false;
			} else if (charMap.containsKey(c1) || valueToKeyMap.containsKey(c2))
				return false;
			else {
				charMap.put(c1, c2);
				valueToKeyMap.put(c2, c1);
			}
			index++;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isIsomorphic("egg", "add"));
	}
}
