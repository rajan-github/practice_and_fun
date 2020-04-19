package numbers;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {
	public int romanToInt(String s) {
		int number = 0;
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		if (s.length() > 0) {
			if (s.length() == 1 && map.containsKey(s.charAt(0))) {
				return map.get(s.charAt(0));
			} else {
				int index = 0;
				while (index < s.length()) {
					if (index < s.length() - 1 && map.get(s.charAt(index)) < map.get(s.charAt(index + 1))) {
						number = number + (map.get(s.charAt(index + 1)) - map.get(s.charAt(index)));
						index += 2;
					} else {
						number = number + (map.get(s.charAt(index++)));
					}
				}
			}
		}
		return number;
	}

	public static void main(String[] args) {
		RomanToInteger roman = new RomanToInteger();
		System.out.println(roman.romanToInt("LVIII"));
		System.out.println(roman.romanToInt("MCMXCIV"));
		System.out.println(roman.romanToInt("IX"));
		System.out.println(roman.romanToInt("MDC"));
		System.out.println(roman.romanToInt("MMMCMXCIX"));
		
	}
}
