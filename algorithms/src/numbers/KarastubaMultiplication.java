package numbers;

/**
 * Karatsuba multiplication. TODO: Only works for even length numbers and in not
 * the fastest implementation yet. Need to enhance the performance and make it
 * work for the odd digit numbers also.
 * 
 * @author rajan-c
 *
 */
public class KarastubaMultiplication {
	public static String multiplication(String number1, String number2) {
		int maxLength = Math.max(number1.length(), number2.length());
		number1 = increaseNumberLength(number1, maxLength);
		number2 = increaseNumberLength(number2, maxLength);
		int length1 = number1.length(), length2 = number2.length();
		if (length1 == 1)
			return "" + (Character.digit(number1.charAt(0), 10) * Character.digit(number2.charAt(0), 10));
		String a = number1.substring(0, (length1 / 2)), b = number1.substring((length1 / 2));
		String c = number2.substring(0, (length2 / 2)), d = number2.substring((length2 / 2));
		String ac = multiplication(a, c), bd = multiplication(b, d);
		ac = appendZero(ac, length1);
		String adSumbc = sum(multiplication(a, d), multiplication(b, c));
		adSumbc = appendZero(adSumbc, length1 / 2);
		return sum(sum(adSumbc, ac), bd);
	}

	private static String appendZero(String s, int zeros) {
		StringBuilder newString = new StringBuilder();
		newString.append(s);
		while (zeros > 0) {
			newString.append(0);
			zeros--;
		}
		return newString.toString();
	}

	private static String increaseNumberLength(String a, int newLength) {
		int lengtha = a.length();
		int lengthDifference = newLength - lengtha;
		StringBuilder zeros = new StringBuilder();
		while (lengthDifference > 0) {
			zeros.append(0);
			lengthDifference--;
		}
		a = zeros.append(a).toString();
		return a;
	}

	private static String sum(String a, String b) {
		int maxLength = Math.max(a.length(), b.length());
		a = increaseNumberLength(a, maxLength);
		b = increaseNumberLength(b, maxLength);
		int carry = 0;
		StringBuilder sum = new StringBuilder();
		int lastIndex = a.length() - 1;
		while (lastIndex >= 0) {
			int digitSum = Character.digit(a.charAt(lastIndex), 10) + Character.digit(b.charAt(lastIndex), 10) + carry;
			sum.insert(0, digitSum % 10);
			carry = digitSum / 10;
			lastIndex--;
		}
		if (carry > 0)
			sum.insert(0, carry);
		return sum.toString();
	}

	public static void main(String[] args) {
//		System.out.println(sum("1", "2"));
		System.out.println(multiplication("12", "12"));
//		System.out.println(multiplication("13", "13"));
//		System.out.println(multiplication("25", "25"));
//		System.out.println(multiplication("00", "25"));
		System.out.println(multiplication("121", "121"));
		System.out.println(multiplication("5678", "1234"));
		System.out.println(multiplication("3141592653589793238462643383279502884197169399375105820974944592",
				"2718281828459045235360287471352662497757247093699959574966967627"));
	}
}
