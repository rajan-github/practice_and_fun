package arrays;

/**
 * You are given an n x n 2D matrix representing an image. Rotate the image by
 * 90 degrees (clockwise).
 *
 * You have to rotate the image in-place, which means you have to modify the
 * input 2D matrix directly. DO NOT allocate another 2D matrix and do the
 * rotation.
 * 
 * @author rajan-c
 *
 */
public class RotateImage {
	public static void display(int[][] matrix) {
		for (int[] item : matrix) {
			for (int i : item) {
				System.out.print(i + ", ");
			}
			System.out.println();
		}
	}

	public static void rotate(int[][] matrix) {
		if (matrix != null) {
			for (int row = 0; row < matrix.length; row++) {
				for (int column = row; column < matrix.length; column++) {
					int temp = matrix[column][row];
					matrix[column][row] = matrix[row][column];
					matrix[row][column] = temp;
				}
			}

			for (int row = 0; row < matrix.length; row++) {
				int left = 0, right = matrix[0].length - 1;
				while (left < right) {
					int temp = matrix[row][left];
					matrix[row][left] = matrix[row][right];
					matrix[row][right] = temp;
					left++;
					right--;
				}
			}

			display(matrix);
		}
	}

	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		rotate(matrix);

		matrix = new int[][] { { 5, 1, 9, 11 }, { 2, 4, 8, 10 }, { 13, 3, 6, 7 }, { 15, 14, 12, 16 } };
		rotate(matrix);
	}
}
