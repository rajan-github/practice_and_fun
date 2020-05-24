package arrays;

/**
 * Given a m * n matrix of ones and zeros, return how many square submatrices
 * have all ones.
 * 
 * @author rajan-c
 *
 */
public class CountSquares {
	public static int countSquares(int[][] matrix) {
		int count = 0;
		if (matrix != null) {
			int rows = matrix.length, cols = matrix[0].length, maxSquare = Math.min(rows, cols);
			for (int squareSide = 2; squareSide <= maxSquare; squareSide++) {
				for (int squareRow = squareSide - 1; squareRow < rows; squareRow++) {
					for (int squareCol = squareSide - 1; squareCol < cols; squareCol++) {
						if ((matrix[squareRow - 1][squareCol - 1] >= squareSide - 1)
								&& (matrix[squareRow][squareCol - 1] >= squareSide - 1)
								&& (matrix[squareRow - 1][squareCol] >= squareSide - 1)
								&& (matrix[squareRow][squareCol] >= squareSide - 1))
							matrix[squareRow][squareCol] = squareSide;
					}
				}
			}
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					count += matrix[i][j];
				}
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 1, 1, 1 } };
		System.out.println(countSquares(matrix));

		matrix = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 1, 0 }, { 1, 1, 1 }, { 1, 1, 0 } };
		System.out.println(countSquares(matrix));
	}
}
