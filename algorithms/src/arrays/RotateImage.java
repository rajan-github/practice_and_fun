package arrays;

import auxiliaryMethods.CommonMethods;

/**
 * You are given an n x n 2D matrix representing an image.
 * 
 * Rotate the image by 90 degrees (clockwise). You have to rotate the image
 * in-place, which means you have to modify the input 2D matrix directly. DO NOT
 * allocate another 2D matrix and do the rotation.
 * 
 * @author rajan-c
 *
 */
public class RotateImage {
	public static void rotate(int[][] matrix) {
		if (matrix == null || matrix.length == 0)
			return;
		transpose(matrix);
		int rows = matrix.length, cols = matrix[0].length;
		for (int row = 0; row < rows; row++) {
			int left = 0, right = cols - 1;
			while (left < right) {
				int temp = matrix[row][left];
				matrix[row][left] = matrix[row][right];
				matrix[row][right] = temp;
				left++;
				right--;
			}
		}
		CommonMethods.display(matrix);
	}

	private static void transpose(int[][] matrix) {
		int rows = matrix.length, cols = matrix[0].length;
		for (int row = 0; row < rows; row++) {
			for (int col = row; col < cols; col++) {
				int temp = matrix[col][row];
				matrix[col][row] = matrix[row][col];
				matrix[row][col] = temp;
			}
		}
	}

	public static void main(String[] args) {
		int[][] matrix = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);
	}
}
