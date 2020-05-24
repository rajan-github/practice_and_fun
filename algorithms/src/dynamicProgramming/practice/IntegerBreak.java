package dynamicProgramming.practice;

/**
 * Given a positive integer n, break it into the sum of at least two positive
 * integers and maximize the product of those integers. Return the maximum
 * product you can get. Example: 10: 3+3+4(3*3*4=36)
 * 
 * @author rajan-c
 *
 */
public class IntegerBreak {
	private static int integerBreak(int n) {
		int[] memory = new int[n + 1];
		return integerBreak(n, false, memory);
	}

	private static int integerBreak(int n, boolean isBroken, int[] memory) {
		int maxProduct;
		if (memory[n] > 0)
			return memory[n];
		if (isBroken) {
			if (n <= 4)
				return n;
			maxProduct = n;
			int half = (n >> 1);
			for (int k = 1; k <= half; k++)
				maxProduct = Math.max(maxProduct, integerBreak(k, true, memory) * integerBreak(n - k, true, memory));
		} else {
			int half = (n >> 1);
			maxProduct = half * (n - half);
			for (int k = 1; k <= half; k++)
				maxProduct = Math.max(maxProduct, integerBreak(k, true, memory) * integerBreak(n - k, true, memory));
		}
		memory[n] = maxProduct;
		return maxProduct;
	}

	public static void main(String[] args) {
		System.out.println(integerBreak(2));
		System.out.println(integerBreak(5));
		System.out.println(integerBreak(10));
		System.out.println(integerBreak(12));
		System.out.println(integerBreak(15));
	}
}
