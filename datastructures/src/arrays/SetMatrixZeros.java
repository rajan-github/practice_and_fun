package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0.
 * Do it in-place.
 * 
 * @author rajan-c
 *
 */
public class SetMatrixZeros {
	public static void setZeroes(int[][] matrix) {

		List<int[]> indexList = new ArrayList<>();
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix[0].length; col++) {
				if (matrix[row][col] == 0)
					indexList.add(new int[] { row, col });
			}
		}

		for (int[] index : indexList)
			setZero(matrix, index);

		display(matrix);
	}

	private static void setZero(int[][] matrix, int[] index) {
		int row = index[0], col = index[1];
		for (int i = 0; i < matrix[0].length; i++)
			matrix[row][i] = 0;
		for (int i = 0; i < matrix.length; i++)
			matrix[i][col] = 0;
	}

	private static void display(int[][] matrix) {

		for (int[] row : matrix) {
			System.out.print("[");
			for (int item : row)
				System.out.print(item + ", ");
			System.out.println("]");
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 1, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
		setZeroes(matrix);

		matrix = new int[][] { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
		setZeroes(matrix);

		matrix = new int[][] { { 0, 1, }, { 3, 4 } };
		setZeroes(matrix);

		matrix = new int[][] { { 0 } };
		setZeroes(matrix);
	}

}
