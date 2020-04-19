package arrays;

/**
 * Given a positive integer n, generate a square matrix filled with elements
 * from 1 to n2 in spiral order.
 * 
 * @author rajan-c
 *
 */
public class SpiralMatrix2 {

	public static int[][] generateMatrix(int n) {
		if (n <= 0)
			return new int[0][0];
		int[][] spiralMatrix = new int[n][n];
		int topRow = -1, rightCol = n, bottomRow = n, leftCol = -1;
		boolean isTopRow = true, isRightCol = false, isBottomRow = false, isLeftCol = false;
		for (int i = 1; i <= n * n;) {
			if (isTopRow) {
				for (int index = leftCol + 1; index < rightCol; index++) {
					spiralMatrix[topRow + 1][index] = i++;
				}
				topRow++;
				isTopRow = false;
				isRightCol = true;
			} else if (isRightCol) {
				for (int index = topRow + 1; index < bottomRow; index++) {
					spiralMatrix[index][rightCol - 1] = i++;
				}
				rightCol--;
				isRightCol = false;
				isBottomRow = true;
			} else if (isBottomRow) {
				for (int index = rightCol - 1; index > leftCol; index--) {
					spiralMatrix[bottomRow - 1][index] = i++;
				}
				bottomRow--;
				isBottomRow = false;
				isLeftCol = true;
			} else if (isLeftCol) {
				for (int index = bottomRow - 1; index > topRow; index--) {
					spiralMatrix[index][leftCol + 1] = i++;
				}
				leftCol++;
				isLeftCol = false;
				isTopRow = true;
			}
		}
		return spiralMatrix;
	}

	private static void display(int[][] matrix) {
		System.out.println("[");
		for (int[] row : matrix) {
			System.out.print("[");
			for (int item : row) {
				System.out.print(item + ", ");
			}
			System.out.println("]");
		}
		System.out.println("]");
	}

	public static void main(String[] args) {
//		display(generateMatrix(3));
//		display(generateMatrix(2));
//		display(generateMatrix(1));

		display(generateMatrix(4));
		display(generateMatrix(0));
	}
}
