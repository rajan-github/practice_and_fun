package dynamicProgramming;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x,
 * where 0 ≤ x < 10^n.
 * 
 * @author rajan-c
 *
 */
public class CountUniqeDigitNumbers {
	public int countNumbersWithUniqueDigits(int n) {
		int[] uniqeDigitNumbers = new int[n + 1];
		uniqeDigitNumbers[0] = 1;
		if (n > 0) {
			uniqeDigitNumbers[1] = 10;
			int choices = 9, count = 9;
			for (int i = 2; i <= n; i++) {
				count = (count * choices--);
				uniqeDigitNumbers[i] = uniqeDigitNumbers[i - 1] + count;
			}
		}
		return uniqeDigitNumbers[n];
	}
}
