package numbers;

import java.util.HashMap;
import java.util.Map;

/**
 * Convert number to excel sheel column name. Column names till 26 are referred
 * as A, B...Z. But 27 is written as AZ. 7000 is written as JIF.
 * 
 * @author rajan-c
 *
 */
public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
		if (n <= 0)
			return "";
		Map<Integer, Character> charMap = new HashMap<>();
		charMap.put(1, 'A');
		charMap.put(2, 'B');
		charMap.put(3, 'C');
		charMap.put(4, 'D');
		charMap.put(5, 'E');
		charMap.put(6, 'F');
		charMap.put(7, 'G');
		charMap.put(8, 'H');
		charMap.put(9, 'I');
		charMap.put(10, 'J');
		charMap.put(11, 'K');
		charMap.put(12, 'L');
		charMap.put(13, 'M');
		charMap.put(14, 'N');
		charMap.put(15, 'O');
		charMap.put(16, 'P');
		charMap.put(17, 'Q');
		charMap.put(18, 'R');
		charMap.put(19, 'S');
		charMap.put(20, 'T');
		charMap.put(21, 'U');
		charMap.put(22, 'V');
		charMap.put(23, 'W');
		charMap.put(24, 'X');
		charMap.put(25, 'Y');
		charMap.put(26, 'Z');
		if (charMap.containsKey(n))
			return charMap.get(n) + "";
		else if (n > 26) {
			StringBuilder title = new StringBuilder();
			while (n > 26) {
				int[] data = getQuotient(n);
				title.insert(0, charMap.get(data[1]));
				n = data[0];
			}
			if (charMap.containsKey(n))
				title.insert(0, charMap.get(n));
			return title.toString();
		}
		return "";
	}

	private static int[] getQuotient(int n) {
		int[] multiplicationData = new int[2];
		int multiplier = 26;
		long quotient = 1;

		while (multiplier * quotient < n)
			quotient <<= 1;

		if (quotient != 1)
			quotient >>= 1;

		while (multiplier < n) {
			long temp = multiplier * quotient;
			if (temp < n)
				quotient += 1;
			else {
				quotient -= 1;
				break;
			}
		}
		multiplicationData[0] = (int) quotient;
		multiplicationData[1] = n - (multiplicationData[0] * multiplier);
		return multiplicationData;
	}

	public static void main(String[] args) {
		System.out.println(convertToTitle(7000));
		System.out.println(convertToTitle(701));
		System.out.println(convertToTitle(28));
		System.out.println(convertToTitle(52));
		System.out.println(convertToTitle(Integer.MAX_VALUE));
//		System.out.println(getQuotient(52)[0] + ", " + getQuotient(52)[1]);
//		int[] data = getQuotient(701);
//		System.out.println(data[0] + ", " + data[1]);
//		data = getQuotient(2600);
//		System.out.println(data[0] + ", " + data[1]);
	}
}
