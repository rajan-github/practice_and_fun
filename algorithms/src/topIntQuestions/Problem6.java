package topIntQuestions;

import auxiliaryMethods.CommonMethods;

/**
 * Given a non-empty array of digits representing a non-negative integer, plus
 * one to the integer.
 * 
 * The digits are stored such that the most significant digit is at the head of
 * the list, and each element in the array contain a single digit.
 * 
 * You may assume the integer does not contain any leading zero, except the
 * number 0 itself.
 * 
 * @author rajan-c
 *
 */
public class Problem6 {
	public static int[] plusOne(int[] digits) {
		int[] nextNumber = new int[digits.length + 1];

		int carry = 0;	
		int i = 0;
		for (i = digits.length - 1; i >= 0; i--) {
			int temp = digits[i];
			if (i == digits.length - 1) {
				digits[i] = (carry + digits[i] + 1) % 10;
				nextNumber[i + 1] = digits[i];
				carry = (carry + temp + 1) / 10;
			} else {
				digits[i] = (digits[i] + carry) % 10;
				nextNumber[i + 1] = digits[i];
				carry = (temp + carry) / 10;
			}
		}
		nextNumber[i + 1] = carry;
		return carry != 0 ? nextNumber : digits;
	}

	public static void main(String[] args) {
		CommonMethods.display(plusOne(new int[] { 9 }));
	}
}
