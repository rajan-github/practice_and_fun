package arrays;

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
public class PlusOne {
	public static int[] plusOne(int[] digits) {
		int[] number = new int[digits.length + 1];
		int i = digits.length - 1, carry = 0;
		while (i >= 0) {
			if (i == digits.length - 1) {
				carry = (digits[i] + 1) / 10;
				if (carry > 0)
					number[i + 1] = (digits[i] + 1) - 10;
				else
					number[i + 1] = (digits[i] + 1);
				digits[i] = number[i + 1];
			} else {
				if (carry > 0 && digits[i] + carry > 9) {
					number[i + 1] = (digits[i] + carry) - 10;
					carry = (digits[i] + carry) / 10;
				} else {
					number[i + 1] = (digits[i] + carry);
					carry = number[i + 1] / 10;
				}
				digits[i] = number[i + 1];
			}
			i--;
		}
		number[i + 1] = carry;
		return carry > 0 ? number : digits;
	}

	public static void display(int[] nums) {
		System.out.print("[");
		for (int item : nums)
			System.out.print(item + ",");
		System.out.println("]");
	}

	public static void main(String[] args) {
		int[] digits = { 1, 2, 3, 4 };
		display(plusOne(digits));
	}
}
