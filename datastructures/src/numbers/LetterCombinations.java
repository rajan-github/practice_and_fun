package numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations {

	public List<String> letterCombinations(String digits) {
		Map<Character, String[]> map = new HashMap<>();
		map.put('2', new String[] { "a", "b", "c" });
		map.put('3', new String[] { "d", "e", "f" });
		map.put('4', new String[] { "g", "h", "i" });
		map.put('5', new String[] { "j", "k", "l" });
		map.put('6', new String[] { "m", "n", "o" });
		map.put('7', new String[] { "p", "q", "r", "s" });
		map.put('8', new String[] { "t", "u", "v" });
		map.put('9', new String[] { "w", "x", "y", "z" });
		String[][] data = new String[digits.length()][];
		for (int i = 0; i < digits.length(); i++) {
			data[i] = map.get(digits.charAt(i));
		}
		return multiplyStrings(data);
	}

	private static List<String> multiplyStrings(String[]... strings) {
		List<String> multiplied = new ArrayList<>();
		if (strings.length > 0) {
			for (int t = 0; t < (strings[0].length); t++)
				multiplied.add(strings[0][t]);
			for (int k = 1; k < strings.length; k++) {
				List<String> temp = new ArrayList<>(multiplied);
				multiplied.clear();
				for (int i = 0; i < strings[k].length; i++) {
					for (String item : temp) {
						multiplied.add(item + strings[k][i]);
					}
				}
			}

		}
		return multiplied;
	}

	public static void main(String[] args) {
//		List<String> list = multiplyStrings(new String[][] { { "a", "b", "c" }, { "e", "f", "g" }, { "k", "l", "m" } });
		List<String> list = new LetterCombinations().letterCombinations("");
		System.out.println(list.size());
	}

}
