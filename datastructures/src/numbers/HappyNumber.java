package numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * Write an algorithm to determine if a number is "happy".
 * 
 * A happy number is a number defined by the following process: Starting with
 * any positive integer, replace the number by the sum of the squares of its
 * digits, and repeat the process until the number equals 1 (where it will
 * stay), or it loops endlessly in a cycle which does not include 1. Those
 * numbers for which this process ends in 1 are happy numbers.
 * 
 * @author rajan-c
 *
 */
public class HappyNumber {
	public static boolean isHappy(int n) {
		Map<Integer, Integer> map = new HashMap<>();
		boolean isNumberHappy = false;
		while (true) {
			n = getDigitSumSquare(n);
			if (n == 1) {
				isNumberHappy = true;
				break;
			} else if (map.containsKey(n))
				break;
			map.put(n, 1);
		}
		if (n == 1)
			isNumberHappy = true;
		return isNumberHappy;
	}

	private static int getDigitSumSquare(int n) {
		int sum = 0;
		while (n > 0) {
			int remainder = n % 10;
			sum += (remainder * remainder);
			n /= 10;
		}
		return sum;
	}

	public static void main(String[] args) {
		System.out.println(isHappy(19));
		System.out.println(isHappy(20));
		System.out.println(isHappy(7));

	}
}
