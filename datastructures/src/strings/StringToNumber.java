package strings;

import java.math.BigInteger;

public class StringToNumber {
	public int myAtoi(String str) {
		BigInteger bigInt = new BigInteger("0");
		int sign = 1;
		if (str != null && str.length() > 0) {
			int i = 0; // index
			while (i < str.length() && str.charAt(i) == ' ')
				i++;
			if (i < str.length()) {
				char temp = str.charAt(i);
				if (temp == '-' || temp == '+') {
					sign = (temp == '-' ? -1 : 1);
					i++;
				}
				while (i < str.length() && (47 < (int) str.charAt(i) && (int) str.charAt(i) < 58)) {
					bigInt = bigInt.multiply(new BigInteger("10"))
							.add(new BigInteger(Character.toString(str.charAt(i))));
					i++;
				}
			}
		}

		return (bigInt.compareTo(new BigInteger("" + bigInt.intValue())) == 0 ? bigInt.intValue() * sign
				: (sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE));
	}

	public static void main(String[] args) {
		StringToNumber stn = new StringToNumber();
		System.out.println(stn.myAtoi("-2147483647"));
	}
}
