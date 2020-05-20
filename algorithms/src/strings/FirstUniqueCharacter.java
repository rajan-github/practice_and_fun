package strings;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * Given a string, find the first non-repeating character in it and return it's
 * index. If it doesn't exist, return -1.
 * 
 * @author rajan-c
 *
 */
public class FirstUniqueCharacter {
	public static int firstUniqChar(String s) {
		int index = -1;
		if (s != null && s.length() > 0) {
			Set<Character> set = new HashSet<>();
			Map<Character, Integer> map = new LinkedHashMap<>();
			int length = s.length();
			for (int i = 0; i < length; i++) {
				char c = s.charAt(i);
				if (set.contains(c)) {
					if (map.containsKey(c)) {
						if (map.get(c) == index)
							index = -1;
						map.remove(c);
					}
					for (Map.Entry<Character, Integer> entry : map.entrySet()) {
						index = entry.getValue();
						break;
					}
				} else {
					set.add(c);
					map.put(c, i);
				}
			}

			if (!map.isEmpty() && index == -1) {
				for (Map.Entry<Character, Integer> entry : map.entrySet()) {
					index = entry.getValue();
					break;
				}
			}
		}
		return index;
	}

	public static void main(String[] args) {
		System.out.println(firstUniqChar("leetcode"));
		System.out.println(firstUniqChar("loveleetcode"));
		System.out.println(firstUniqChar("z"));
		System.out.println(firstUniqChar("zz"));
		System.out.println(firstUniqChar("zadapllpdaadzcee"));
	}
}
