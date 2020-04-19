package numbers;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * How many possible unique paths are there?
 * 
 * @author rajan-c
 *
 */
public class UniquePaths {

	private static long computeBionomialNumber(int n, int k, long[][] memory) {
		if (k == 0 || n == k) {
			return 1;
		}
		if (memory[n][k] > 0) {
			return memory[n][k];
		} else {
			memory[n][k] = computeBionomialNumber(n - 1, k, memory) + computeBionomialNumber(n - 1, k - 1, memory);
			return memory[n][k];
		}

	}

	public static int uniquePaths(int m, int n) {
		int rightMove = m - 1, downMove = n - 1, totalMoves = rightMove + downMove;
		long[][] memory = new long[totalMoves + 1][rightMove + 1];
		return (int) computeBionomialNumber(totalMoves, rightMove, memory);
	}

	public static void main(String[] args) {
		System.out.println(uniquePaths(7, 3));
	}

}
