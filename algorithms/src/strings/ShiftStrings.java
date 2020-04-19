package strings;

/**
 * You are given a string s containing lowercase English letters, and a matrix
 * shift, where shift[i] = [direction, amount]:
 * 
 * direction can be 0 (for left shift) or 1 (for right shift). amount is the
 * amount by which string s is to be shifted. A left shift by 1 means remove the
 * first character of s and append it to the end. Similarly, a right shift by 1
 * means remove the last character of s and add it to the beginning. Return the
 * final string after all operations.
 * 
 * @author rajan-c
 *
 */
public class ShiftStrings {
	public static String stringShift(String s, int[][] shift) {
		if (s == null || s.length() == 0)
			return s;
		StringBuilder string = new StringBuilder();
		string.append(s);
		for (int[] instruction : shift) {
			if (instruction[1] >= 1) {
				int totalShifts = instruction[1];
				while (totalShifts-- > 0) {
					if (instruction[0] == 0)
						string = leftShift(string);
					else
						string = rightShift(string);
				}
			}
		}
		return string.toString();
	}

	private static StringBuilder leftShift(StringBuilder s) {
		char firstCharacter = s.charAt(0);
		s.deleteCharAt(0);
		s.append(firstCharacter);
		return s;
	}

	private static StringBuilder rightShift(StringBuilder s) {
		int lastIndex = s.length() - 1;
		char lastChar = s.charAt(lastIndex);
		s.deleteCharAt(lastIndex);
		s.insert(0, lastChar);
		return s;
	}

	public static void main(String[] args) {
		int[][] operations = new int[][] { { 0, 1 }, { 1, 2 } };
		System.out.println(stringShift("abc", operations));

		operations = new int[][] { { 1, 1 }, { 1, 1 }, { 0, 2 }, { 1, 3 } };
		System.out.println(stringShift("abcdefg", operations));
	}
}
