package strings;

/**
 * A message containing letters from A-Z is being encoded to numbers using the
 * following mapping:
 * 
 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given a non-empty string containing only
 * digits, determine the total number of ways to decode it.
 * 
 * @author rajan-c
 *
 */
public class DecodeWays {

	public static int numDecodings(String s) {
		if (s.charAt(0) == '0')
			return 0;
		if (s.length() <= 2) {
			int decoding = Integer.parseInt(s);
			if (decoding <= 26 && decoding >= 11)
				return 2;
			else if (decoding > 26 && s.charAt(1) == '0')
				return 0;
			else
				return decoding >= 1 ? 1 : 0;
		}

		int decodings = Integer.MIN_VALUE;

		for (int i = 2; i < s.length(); i += 2) {
			int left = numDecodings(s.substring(0, i));
			int right = numDecodings(s.substring(i, s.length()));
			decodings = sumDecodings(decodings, left, right);
			decodings = sumDecodings(decodings, numDecodings(s.substring(0, i - 1)),
					numDecodings(s.substring(i - 1, s.length())));
		}
		return decodings;
	}

	private static int sumDecodings(int oldDecoding, int decoding1, int decoding2) {
		if (decoding1 == 0 || decoding2 == 0)
			oldDecoding = Math.max(oldDecoding, 0);
		else if (decoding1 == 1 && decoding2 == 1)
			oldDecoding = Math.max(oldDecoding, decoding1 * decoding2);
		else
			oldDecoding = Math.max(oldDecoding, decoding1 + decoding2);
		return oldDecoding;
	}

	public static void main(String[] args) {
		System.out.println(numDecodings("226"));
		System.out.println(numDecodings("12"));
		System.out.println(numDecodings("0"));
		System.out.println(numDecodings("01"));
		System.out.println(numDecodings("100"));
		System.out.println(numDecodings("101"));
		System.out.println(numDecodings("1010"));
		System.out.println(numDecodings("1001"));
		System.out.println(numDecodings("110"));
		System.out.println(numDecodings("1212"));
		System.out.println(numDecodings("2226"));
		System.out.println(numDecodings("123"));
		System.out.println(numDecodings("323"));
		System.out.println(numDecodings("222"));
		System.out.println(numDecodings("110"));
	}

}
