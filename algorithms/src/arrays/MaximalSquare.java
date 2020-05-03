package arrays;

/**
 * Given a 2D binary matrix filled with 0's and 1's, find the largest square
 * containing only 1's and return its area.
 * 
 * @author rajan-c
 *
 */
public class MaximalSquare {
	public static int maximalSquare(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int rows = matrix.length, cols = matrix[0].length,
				largestSquareEdge = Math.min(matrix.length, matrix[0].length), maxSofar = -1;

		for (int edge = 0; edge < largestSquareEdge; edge++) {
			boolean found = false;
			for (int row = 0; row < rows && !found; row++) {
				for (int col = 0; col < cols && !found; col++) {
					found = square(matrix, row, col, edge);
				}
			}
			if (found && maxSofar < edge)
				maxSofar = edge;
		}
		return (maxSofar + 1) * (maxSofar + 1);
	}

	private static boolean square(char[][] matrix, int i, int j, int edgeSize) {
		int rows = matrix.length, cols = matrix[0].length;
		if (i + edgeSize < rows && j + edgeSize < cols) {
			boolean hasSquare = true;
			for (int row = i; row <= i + edgeSize && hasSquare; row++) {
				for (int col = j; col <= j + edgeSize && hasSquare; col++) {
					if (matrix[row][col] == '0')
						hasSquare = false;
				}
			}
			return hasSquare;
		} else
			return false;
	}

	public static int maximalSquareDP(char[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return 0;
		int answer = 0;
		int rows = matrix.length, cols = matrix[0].length;
		int[][] memory = new int[rows][cols];
		for (int i = 0; i < cols; i++) {
			memory[0][i] = matrix[0][i] == '1' ? 1 : 0;
			if (answer < memory[0][i])
				answer = memory[0][i];
		}

		for (int i = 0; i < rows; i++) {
			memory[i][0] = matrix[i][0] == '1' ? 1 : 0;
			if (answer < matrix[i][0])
				answer = matrix[i][0];
		}

		for (int row = 1; row < rows; row++) {
			for (int col = 1; col < cols; col++) {
				int digit = Character.digit(matrix[row][col], 10);
				if (digit > 0)
					memory[row][col] = Character.digit(matrix[row][col], 10)
							+ min(memory[row - 1][col], memory[row - 1][col - 1], memory[row][col - 1]);
				else
					memory[row][col] = 0;
				if (memory[row][col] > answer)
					answer = memory[row][col];
			}
		}

		return answer * answer;
	}

	private static int min(int a, int b, int c) {
		if (a <= b && a <= c)
			return a;
		else if (b <= c && b <= a)
			return b;
		return c;
	}

	public static void main(String[] args) {
		System.out.println(maximalSquare(new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));

		System.out.println(maximalSquareDP(new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
				{ '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } }));

		System.out.println(maximalSquareDP(new char[][] { { '1' } }));

		System.out.println(maximalSquareDP(new char[][] { { '0', '0', '0' }, { '0', '0', '0' }, { '1', '1', '1' } }));

		System.out.println(maximalSquareDP(new char[][] { { '1', '0', '1', '1', '0', '1' },
				{ '1', '1', '1', '1', '1', '1' }, { '0', '1', '1', '0', '1', '1' }, { '1', '1', '1', '0', '1', '0' },
				{ '0', '1', '1', '1', '1', '1' }, { '1', '1', '0', '1', '1', '1' } }));

		System.out.println(maximalSquareDP(new char[][] { { '1', '1', '1' }, { '1', '1', '1' }, { '1', '1', '1' } }));
	}
}
