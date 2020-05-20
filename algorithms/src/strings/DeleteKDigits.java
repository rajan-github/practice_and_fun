package strings;

/**
 * Given a non-negative integer num represented as a string, remove k digits
 * from the number so that the new number is the smallest possible.
 * 
 * Note: The length of num is less than 10002 and will be ≥ k. The given num
 * does not contain any leading zero.
 * 
 * @author rajan-c
 *
 */
public class DeleteKDigits {

	public static String removeKdigits(String num, int k) {
		if (k == 0 || num == null || num.length() < k)
			return num;
		int length = num.length();
		if (k == length)
			return "0";
		String minimum = num;
		for (int i = 0; i < length; i++) {
			String temp = removeLeadingZeros(num.substring(0, i) + num.substring(i + 1));
			if (compare(temp, minimum) < 0)
				minimum = temp;
		}
		return removeKdigits(minimum, k - 1);
	}

	private static String removeLeadingZeros(String num) {
		int length = num.length(), index = 0;
		while (index < length && num.charAt(index) == '0')
			index++;
		if (index < length)
			return num.substring(index);
		return "0";
	}

	private static int compare(String num1, String num2) {
		int index1 = 0, index2 = 0, length1 = num1.length(), length2 = num2.length();
		if (length1 > length2)
			return 1;
		else if (length2 > length1)
			return -1;
		while (index1 < length1 && index2 < length2 && num1.charAt(index1) == num2.charAt(index2)) {
			index1++;
			index2++;
		}
		if (index1 == index2 && index1 == length1)
			return 0;
		else {
			int d1 = num1.charAt(index1), d2 = num2.charAt(index2);
			return d1 > d2 ? 1 : -1;
		}
	}

	public static String removeKdigitsGreedy(String num, int k) {
		if (k == 0 || num == null || num.length() < k)
			return num;
		if (k == num.length())
			return "0";

		while (k > 0) {
			int length = num.length(), i = 0;
			inner: for (i = 0; i < length - 1; i++) {
				char current = num.charAt(i), next = num.charAt(i + 1);
				if (Character.digit(current, 10) > Character.digit(next, 10)) {
					num = removeLeadingZeros(num.substring(0, i) + num.substring(i + 1));
					num = removeLeadingZeros(num);
					break inner;
				}
			}
			if (i == length - 1) {
				num = removeLeadingZeros(num.substring(0, i) + num.substring(i + 1));
				num = removeLeadingZeros(num);
			}
			k--;
		}
		return num;
	}

	public static void main(String[] args) {
		System.out.println(removeKdigits("10200", 1) + ", " + removeKdigitsGreedy("10200", 1));
		System.out.println(removeKdigits("10", 2) + ", " + removeKdigitsGreedy("10", 2));
		System.out.println(removeKdigits("1432219", 3) + ", " + removeKdigitsGreedy("1432219", 3));
		System.out.println(removeKdigits("9", 1) + ", " + removeKdigitsGreedy("9", 1));
		System.out.println(removeKdigits("991", 2) + ", " + removeKdigitsGreedy("991", 2));
		System.out.println(removeKdigits("991", 3) + ", " + removeKdigitsGreedy("991", 3));
		System.out.println(removeKdigits("112", 1) + ", " + removeKdigitsGreedy("112", 1));
		System.out.println(removeKdigits("0200", 1) + ", " + removeKdigitsGreedy("0200", 1));
	}
}
