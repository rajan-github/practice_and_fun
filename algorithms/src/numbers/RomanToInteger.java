package numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert from given roman string to number.
 * 
 * @author rajan-c
 *
 */
public class RomanToInteger {
	public static int romanToInt(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int length = s.length();
		Map<Character, Integer> romanToInteger = new HashMap<>();
		romanToInteger.put('I', 1);
		romanToInteger.put('V', 5);
		romanToInteger.put('X', 10);
		romanToInteger.put('L', 50);
		romanToInteger.put('C', 100);
		romanToInteger.put('D', 500);
		romanToInteger.put('M', 1000);
		int number = 0;
		for (int index = 0; index < length;) {
			char c1 = s.charAt(index);
			int valueOfC1 = romanToInteger.get(c1);
			if ((c1 == 'I' || c1 == 'X' || c1 == 'C') && index < length - 1) {
				char c2 = s.charAt(index + 1);
				int valueOfC2 = romanToInteger.get(c2);
				if (valueOfC1 < valueOfC2) {
					number += (valueOfC2 - valueOfC1);
					index++;
				} else
					number += valueOfC1;

			} else
				number += valueOfC1;
			index++;
		}
		return number;
	}

	public static void main(String[] args) {
//		System.out.println(romanToInt("LVIII"));
//		System.out.println(romanToInt("III"));
//		System.out.println(romanToInt("XXX"));
//		System.out.println(romanToInt("IX"));
//		System.out.println(romanToInt("IV"));
		System.out.println(romanToInt("MDCCCLXXXIV"));
	}
}
