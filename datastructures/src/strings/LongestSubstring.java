package strings;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstring {
	public int lengthOfLongestSubstring(String s) {
		if (s != null && s.length() > 0) {
			int currentLength = 0, maxLength = 0;
			int length = s.length();
			char temp;
			StringBuilder string = new StringBuilder();
			Map<Character, Integer> map = new HashMap<>();
			for (int i = 0; i < length; i++) {
				temp = s.charAt(i);
				if (!map.containsKey(temp)) {
					map.put(temp, 1);
					currentLength++;
					string.append(temp);
				} else {
					if (currentLength > maxLength)
						maxLength = currentLength;
					int k = 0, l = string.length();
					while (string.charAt(k) != temp)
						k++;
					k = k + 1;
					map.clear();
					StringBuilder string2 = new StringBuilder();
					while (k < l) {
						map.put(string.charAt(k), 1);
						string2.append(string.charAt(k));
						k++;
					}
					map.put(temp, 1);
					string2.append(temp);
					currentLength = string2.length();
					string = string2;
					string2 = null;
				}
			}
			return maxLength < string.length() ? string.length() : maxLength;
		} else
			return 0;

	}

	public static void main(String[] args) {
		LongestSubstring sub = new LongestSubstring();
		System.out.println(sub.lengthOfLongestSubstring("dvdf"));
	}
}
