package numbers;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND
 * of all numbers in this range, inclusive.
 * 
 * @author rajan-c
 *
 */
public class BitwiseAnd {
	public static int rangeBitwiseAnd(int m, int n) {
		long result = m;
		for (long i = (long) m + 1; i <= n && result != 0; i++) {
			result &= i;
		}
		return (int) result;
	}

	public static int rangeBitwiseAndFast(int m, int n) {
		int bitCount = 30, bitwiseAnd = 0;
		while (bitCount >= 0 && ((1 << bitCount) & m) == ((1 << bitCount) & n)) {
			bitwiseAnd = (bitwiseAnd << 1) + 1;
			bitCount--;
		}
		bitCount++;
		return m & (bitwiseAnd << bitCount);
	}

	public static void main(String[] args) {
		System.out.println(rangeBitwiseAndFast(5, 7));
		System.out.println(rangeBitwiseAndFast(2147483647, 2147483647) == rangeBitwiseAnd(2147483647, 2147483647));
	}
}
