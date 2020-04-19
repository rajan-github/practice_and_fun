package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a matrix of m x n elements (m rows, n columns), return all elements of
 * the matrix in spiral order.
 * 
 * Input: [[1 2 3 4], [5 6 7 8], [9 10 11 12], [13 14 15 16]] Output: [1 2 3 4 8
 * 12 16 15 14 13 9 5 6 7 11 10]
 * 
 * @author rajan-c
 *
 */
public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix.length > 0) {
			boolean isTopRow = true, isBottomRow = false, isLeftColumn = false, isRightColumn = false;

			int topRow = -1, bottomRow = matrix.length, leftCol = -1, rightCol = matrix[0].length,
					remaining = matrix.length * matrix[0].length;

			while (remaining > 0) {
				if (isTopRow) {
					int currentRow = topRow + 1;
					for (int i = leftCol + 1; i < rightCol; i++) {
						list.add(matrix[currentRow][i]);
						remaining--;
					}
					topRow = currentRow;
					isTopRow = false;
					isRightColumn = true;
				} else if (isRightColumn) {
					int currentColumn = rightCol - 1;
					for (int i = topRow + 1; i < bottomRow; i++) {
						list.add(matrix[i][currentColumn]);
						remaining--;
					}
					rightCol = currentColumn;
					isRightColumn = false;
					isBottomRow = true;
				} else if (isBottomRow) {
					int currentRow = bottomRow - 1;
					for (int i = rightCol - 1; i > leftCol; i--) {
						list.add(matrix[currentRow][i]);
						remaining--;
					}
					isBottomRow = false;
					isLeftColumn = true;
					bottomRow = currentRow;
				} else if (isLeftColumn) {
					int currentCol = leftCol + 1;
					for (int i = bottomRow - 1; i > topRow; i--) {
						list.add(matrix[i][currentCol]);
						remaining--;
					}
					isLeftColumn = false;
					isTopRow = true;
					leftCol = currentCol;
				}
			}
		}
		return list;
	}

	public static void display(List<Integer> list) {
		System.out.println(list);
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		display(spiralOrder(matrix));

		matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		display(spiralOrder(matrix));

		matrix = new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };
		display(spiralOrder(matrix));

		matrix = new int[][] { { 1 } };
		display(spiralOrder(matrix));
	}
}
