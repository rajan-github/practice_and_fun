package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an arbitrary ransom note string and another string containing letters
 * from all the magazines, write a function that will return true if the ransom
 * note can be constructed from the magazines ; otherwise, it will return false.
 * 
 * Each letter in the magazine string can only be used once in your ransom note.
 * 
 * Note: You may assume that both strings contain only lowercase letters.
 * 
 * @author rajan-c
 *
 */
public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
		if (magazine == null)
			return false;
		int magazineLength = magazine.length(), ransomLength = ransomNote.length();
		if (magazineLength < ransomLength)
			return false;
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < magazineLength; i++) {
			char c = magazine.charAt(i);
			if (map.containsKey(c))
				map.replace(c, map.get(c) + 1);
			else
				map.put(c, 1);
		}

		boolean canConstruct = true;

		for (int i = 0; i < ransomLength && canConstruct; i++) {
			char c = ransomNote.charAt(i);
			if (map.containsKey(c))
				if (map.get(c) > 1)
					map.replace(c, map.get(c) - 1);
				else
					map.remove(c);
			else
				canConstruct = false;
		}

		return canConstruct;
	}
}
