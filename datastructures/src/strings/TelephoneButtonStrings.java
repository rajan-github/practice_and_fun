package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Telephone keypads have letters on each numerical key. Write a program that
 * generates all possible words resulting from translating a given digit
 * sequence (e.g., 145345) into letters.
 * 
 * @author rajan-c
 *
 */
public class TelephoneButtonStrings {

	private static void backtrack(StringBuilder stringCombination, String digits, int k) {
		if (k == digits.length()) {
			System.out.println(stringCombination);
			return;
		}
		List<Character> choices = getChoices(Character.digit(digits.charAt(k), 10));
		for (char choice : choices) {
			stringCombination.append(choice);
			backtrack(stringCombination, digits, k + 1);
			stringCombination.deleteCharAt(k);
		}
	}

	private static List<Character> getChoices(int digit) {
		Map<Integer, List<Character>> map = new HashMap<>();
		List<Character> list = new ArrayList<>();
		list.add('a');
		list.add('b');
		list.add('c');
		map.putIfAbsent(2, list);
		list = new ArrayList<>();
		list.add('d');
		list.add('e');
		list.add('f');
		map.putIfAbsent(3, list);
		list = new ArrayList<>();
		list.add('g');
		list.add('h');
		list.add('i');
		map.putIfAbsent(4, list);
		list = new ArrayList<>();
		list.add('j');
		list.add('k');
		list.add('l');
		map.putIfAbsent(5, list);
		list = new ArrayList<>();
		list.add('m');
		list.add('n');
		list.add('o');
		map.putIfAbsent(6, list);

		list = new ArrayList<>();
		list.add('p');
		list.add('q');
		list.add('r');
		list.add('s');
		map.putIfAbsent(7, list);

		list = new ArrayList<>();
		list.add('t');
		list.add('u');
		list.add('v');
		map.putIfAbsent(8, list);

		list = new ArrayList<>();
		list.add('w');
		list.add('x');
		list.add('y');
		list.add('z');
		map.putIfAbsent(9, list);
		return map.get(digit);
	}

	public static void telephoneNumberStrings(int number) {
		String digits = "" + number;
		backtrack(new StringBuilder(), digits, 0);
	}

	public static void main(String[] args) {
		telephoneNumberStrings(9);
	}
}
