package numbers;

import java.util.HashMap;
import java.util.Map;

public class IntegerToRoman {
	public static String intToRoman(int num) {
		StringBuilder roman = new StringBuilder("");
		Map<Integer, String> map = new HashMap<>();
		map.put(0, "");
		map.put(1, "I");
		map.put(5, "V");
		map.put(10, "X");
		map.put(50, "L");
		map.put(100, "C");
		map.put(500, "D");
		map.put(1000, "M");
		return getRoman(num, roman, map).toString();
	}

	private static StringBuilder getRoman(int num, StringBuilder roman, Map<Integer, String> map) {
		if (map.containsKey(num)) {
			return new StringBuilder(map.get(num));
		} else {
			int keys[] = { 1, 5, 10, 50, 100, 500, 1000 };
			int index = keys.length - 1;
			while ((((index == 5 || index == 6) && num < keys[index] - keys[4])
					|| ((index == 3 || index == 4) && num < keys[index] - keys[2])
					|| ((index == 1 || index == 2) && num < keys[index] - keys[0])) && index > 0)
				index--;
			if (num < keys[index] && ((index == 1 || index == 2) && num >= keys[index] - 1)) {
				roman.append(map.get(keys[0])).append(map.get(keys[index]));
				roman.append(getRoman(num - (keys[index] - keys[0]), new StringBuilder(""), map));
				return roman;
			} else if (num < keys[index] && ((index == 3 || index == 4) && num >= keys[index] - keys[2])) {
				roman.append(map.get(keys[2])).append(map.get(keys[index]));
				roman.append(getRoman(num - (keys[index] - keys[2]), new StringBuilder(""), map));
				return roman;
			} else if (num < keys[index] && ((index == 5 || index == 6) && num >= keys[index] - keys[4])) {
				roman.append(map.get(keys[4])).append(map.get(keys[index]));
				roman.append(getRoman(num - (keys[index] - keys[4]), new StringBuilder(""), map));
				return roman;
			} else if (num >= 3 * keys[index]) {
				roman.append(map.get(keys[index])).append(map.get(keys[index])).append(map.get(keys[index]));
				roman.append(getRoman(num - 3 * keys[index], new StringBuilder(""), map));
				return roman;
			} else
				roman.append(map.get(keys[index]));
			roman.append(getRoman(num - keys[index], new StringBuilder(""), map));
			return roman;
		}
	}

	public static void main(String[] args) {

//		getRoman(9, new StringBuilder());
//		getRoman(8, new StringBuilder());
//		getRoman(19, new StringBuilder());
//		getRoman(11, new StringBuilder());
//		getRoman(994, new StringBuilder());
//		getRoman(600, new StringBuilder());
		System.out.println(intToRoman(1));
		System.out.println(intToRoman(2));
		System.out.println(intToRoman(3));
		System.out.println(intToRoman(4));
		System.out.println(intToRoman(5));
		System.out.println(intToRoman(6));
		System.out.println(intToRoman(7));
		System.out.println(intToRoman(8));
		System.out.println(intToRoman(9));
		System.out.println(intToRoman(1994));

//		System.out.println(intToRoman(99));
//		System.out.println(intToRoman(103));
		System.out.println(intToRoman(3999));
		System.out.println(intToRoman(3998));

	}
}
