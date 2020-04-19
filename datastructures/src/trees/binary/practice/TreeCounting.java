package trees.binary.practice;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store
 * values 1 ... n? The answer is nth Catalan number.
 * 
 * @author rajan-c
 *
 */
public class TreeCounting {
	public static int numTrees(int n) {
		return (int) (combination(2 * n, n) / ((long) n + 1));
	}

	private static long combination(int n, int r) {
		if (n >= 0 && r == 0)
			return 1;
		else if (n > 0 && r == 1)
			return n;
		else if (n < 0)
			return 0;
		long[][] memory = new long[n + 1][r + 1];
		for (int index = 0; index < r + 1; index++)
			memory[0][index] = 0;
		for (int index = 0; index < n + 1; index++)
			memory[index][0] = 1;

		for (int row = 1; row <= n; row++) {
			for (int col = 1; col <= r; col++) {
				memory[row][col] = memory[row - 1][col] + memory[row - 1][col - 1];
			}
		}

		return memory[n][r];
	}

	public static void main(String[] args) {
		System.out.println(numTrees(19));
		System.out.println(combination(5, 2));
		System.out.println(combination(2, 2));
		System.out.println(combination(2, 0));
	}
}
