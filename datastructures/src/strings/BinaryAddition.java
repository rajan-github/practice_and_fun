package strings;

/**
 * Add two binary numbers.
 * 
 * @author rajan-c
 *
 */
public class BinaryAddition {
	public static String addBinary(String a, String b) {
		int lengthA = a.length() - 1, lengthB = b.length() - 1, carry = 0;
		StringBuilder sum = new StringBuilder();

		while (lengthA >= 0 || lengthB >= 0) {
			int digitSum;
			if (lengthA >= 0 && lengthB >= 0) {
				digitSum = Character.digit(a.charAt(lengthA), 2) + Character.digit(b.charAt(lengthB), 2) + carry;
				sum.insert(0, digitSum & 1);
				carry = (digitSum) / 2;
				lengthA--;
				lengthB--;
			} else if (lengthA >= 0) {
				digitSum = carry + Character.digit(a.charAt(lengthA), 2);
				sum.insert(0, digitSum & 1);
				carry = digitSum / 2;
				lengthA--;
			} else {
				digitSum = carry + Character.digit(b.charAt(lengthB), 2);
				sum.insert(0, digitSum & 1);
				carry = digitSum / 2;
				lengthB--;
			}
		}
		if (carry > 0)
			sum.insert(0, carry);
		return sum.toString();
	}

	public static void main(String[] args) {
		System.out.println(addBinary("101", "101"));
		System.out.println(addBinary("1", "11"));
		System.out.println(addBinary("1011", "1010"));
	}
}
