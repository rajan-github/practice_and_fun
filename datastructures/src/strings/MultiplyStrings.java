package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two non-negative integers num1 and num2 represented as strings, return
 * the product of num1 and num2, also represented as a string.
 * 
 * @author rajan-c
 *
 */
public class MultiplyStrings {

	public static String multiply(String num1, String num2) {
		if (num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0)
			return "0";
		Map<Character, Integer> digits = new HashMap<>();
		digits.put('0', 0);
		digits.put('1', 1);
		digits.put('2', 2);
		digits.put('3', 3);
		digits.put('4', 4);
		digits.put('5', 5);
		digits.put('6', 6);
		digits.put('7', 7);
		digits.put('8', 8);
		digits.put('9', 9);
		int length1 = num1.length();
		int length2 = num2.length();

		StringBuilder result = new StringBuilder();

		for (int i = length1 - 1; i >= 0; i--) {
			int carry = 0;
			StringBuilder digitMultiplication = new StringBuilder();
			for (int j = length2 - 1; j >= 0; j--) {
				int digit2 = digits.get(num2.charAt(j));
				int digit1 = digits.get(num1.charAt(i));
				int temp = digit2 * digit1 + carry;
				carry = temp / 10;
				StringBuilder digit = new StringBuilder();
				if (j == 0)
					digit.append(temp);
				else
					digit.append(temp % 10);
				digit.append(digitMultiplication);
				digitMultiplication = digit;

			}
			digitMultiplication.append(getZeros(num1.length() - 1 - i));
			result = addString(result, digitMultiplication, digits);
		}
		return getResult(result);
	}

	private static String getResult(StringBuilder result) {
		int i = 0;
		for (; i < result.length(); i++) {
			if (result.charAt(i) != '0')
				break;
		}
		return i < result.length() ? result.toString() : "0";
	}

	private static StringBuilder addString(StringBuilder num1, StringBuilder result, Map<Character, Integer> digits) {
		if (num1 == null || num1.length() == 0)
			return result;
		int length1 = num1.length() - 1;
		int resultLength = result.length() - 1;
		int diff = Math.abs(length1 - resultLength);
		if (diff != 0) {
			if (length1 < resultLength) {
				num1 = getZeros(diff).append(num1);
			} else {
				result = getZeros(diff).append(result);
			}
		}

		int length = result.length() - 1;
		int carry = 0;
		while (length >= 0) {
			int sum = digits.get(num1.charAt(length)) + digits.get(result.charAt(length)) + carry;
			carry = sum / 10;
			result.setCharAt(length, Character.forDigit(sum % 10, 10));
			length--;
		}
		if (carry != 0) {
			StringBuilder temp = new StringBuilder();
			temp.append(carry);
			result = temp.append(result);
		}
		return result;
	}

	private static StringBuilder getZeros(int zeros) {
		StringBuilder zeroString = new StringBuilder();
		for (int i = 0; i < zeros; i++) {
			zeroString.append("0");
		}
		return zeroString;
	}

	public static void main(String[] args) {
		System.out.println(multiply("123", "456"));
		System.out.println(multiply("3", "2"));
		System.out.println(multiply("123", "0"));
		System.out.println(multiply("123", "123"));
		System.out.println(multiply("123", "0"));
	}
}
