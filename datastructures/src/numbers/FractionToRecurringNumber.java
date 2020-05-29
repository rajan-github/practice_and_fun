package numbers;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringNumber {

	public static String fractionToDecimal(int numerator, int denominator) {
		boolean negative = (numerator < 0 && denominator > 0) || (numerator > 0 && denominator < 0);
		numerator = Math.abs(numerator);
		denominator = Math.abs(denominator);
		int quotient = 0;
		if (numerator >= denominator)
			quotient = numerator / denominator;
		numerator = numerator % denominator;
		StringBuilder str = new StringBuilder();
		str.append(quotient);
		if (numerator != 0) {
			str.append(".");
			int index = 1;
			Map<Integer, Integer> remainderMap = new HashMap<>();
			while (numerator != 0 && !remainderMap.containsKey(numerator)) {
				remainderMap.put(numerator, index);
				boolean firstTime = true;
				while (numerator < denominator) {
					numerator *= 10;
					if (!firstTime)
						str.append("0");
					firstTime = false;
				}

				str.append(numerator / denominator);
				numerator = numerator % denominator;
				index++;
			}
			if (remainderMap.containsKey(numerator)) {
				int repetionStartPoint = remainderMap.get(numerator);
				str.insert(repetionStartPoint + 1, "(");
				str.append(")");
			}

		}
		if (negative)
			str.insert(0, "-");
		return str.toString();
	}

	public static void main(String[] args) {
		System.out.println(fractionToDecimal(22, 7));
		System.out.println(fractionToDecimal(1, 2));
		System.out.println(fractionToDecimal(1, 3));
		System.out.println(fractionToDecimal(2, 3));
		System.out.println(fractionToDecimal(2, 1));
		System.out.println(fractionToDecimal(4, 333));
		System.out.println(fractionToDecimal(-50, 8));
		System.out.println(fractionToDecimal(-22, -2));
	}
}
