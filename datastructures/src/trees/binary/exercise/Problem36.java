package trees.binary.exercise;

/**
 * How many different binary trees are possible with n nodes? This number is
 * equal to the catalan number. Its equivalent to (2n C n)/(n+1).
 * 
 * @author rajan-c
 *
 */
public class Problem36 {

	public static int differentBinaryTree(int n) {
		int memory[][] = new int[2 * n + 1][n + 1];
		for (int i = 0; i < memory.length; i++)
			for (int j = 0; j < memory[0].length; j++)
				memory[i][j] = -1;
		return combination(2 * n, n, memory) / (n + 1);
	}

	private static int combination(int n, int k, int[][] memory) {
		if (n == 0)
			return 0;
		else if (k == 0)
			return 1;
		else if (k == 1)
			return n;
		else if (memory[n][k] >= 0)
			return memory[n][k];
		else {
			memory[n][k] = combination(n - 1, k, memory) + combination(n - 1, k - 1, memory);
			return memory[n][k];
		}
	}

	public static void main(String[] args) {
		System.out.println(differentBinaryTree(5));
	}
}
