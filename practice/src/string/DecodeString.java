package string;

/**
 * Given an encoded string, return its decoded string.
 * 
 * The encoding rule is: k[encoded_string], where the encoded_string inside the
 * square brackets is being repeated exactly k times. Note that k is guaranteed
 * to be a positive integer.
 * 
 * You may assume that the input string is always valid; No extra white spaces,
 * square brackets are well-formed, etc.
 * 
 * Furthermore, you may assume that the original data does not contain any
 * digits and that digits are only for those repeat numbers, k. For example,
 * there won't be input like 3a or 2[4].
 * 
 * @author rajan-c
 *
 */
public class DecodeString {

	public static String decodeString(String s) {
		if (s == null || s.length() == 0)
			return "";
		int length = s.length();
		StringBuilder decodedString = new StringBuilder();
		for (int i = 0; i < length;) {
			char c = s.charAt(i);
			if (Character.isDigit(c)) {
				StringBuilder builder = new StringBuilder();
				i = decodeString(s, i, builder);
				decodedString.append(builder);
				if (s.charAt(i) == ']')
					i++;
			} else {
				decodedString.append(c);
				i++;
			}
		}
		return decodedString.toString();
	}

	private static int decodeString(String s, int start, StringBuilder decodedString) {
		int left = 0, right = 0;
		int index = start;
		int number = 0;
		char c = s.charAt(index);
		while (Character.isDigit(c)) {
			index++;
			c = s.charAt(index);
		}
		number = Integer.parseInt(s.substring(start, index));
		while (left != right || left == 0) {
			c = s.charAt(index);
			if (c == '[')
				left++;
			index++;
			c = s.charAt(index);
			while (!Character.isDigit(c) && c != ']') {
				decodedString.append(c);
				index++;
				c = s.charAt(index);
			}
			if (Character.isDigit(c)) {
				StringBuilder decodedSubpart = new StringBuilder();
				int nextIndex = decodeString(s, index, decodedSubpart);
				decodedString.append(decodedSubpart);
				index = nextIndex;
			} else
				right++;
		}
		multiplyString(decodedString, number);
		return index;
	}

	private static StringBuilder multiplyString(StringBuilder str, int times) {
		String temp = str.toString();
		for (int i = 1; i < times; i++)
			str.append(temp);
		return str;
	}

	public static void main(String[] args) {
		String str = "3[a]2[b4[F]c]";
		String ans = decodeString(str);
		System.out.println(ans);
	}

}
