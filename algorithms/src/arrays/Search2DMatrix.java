package arrays;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * 
 * Integers in each row are sorted in ascending from left to right. Integers in
 * each column are sorted in ascending from top to bottom.
 * 
 * @author rajan-c
 *
 */
public class Search2DMatrix {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix != null && matrix.length > 0) {
			int rows = matrix.length, cols = matrix[0].length;
			int startRow = 0, endRow = rows - 1, startCol = 0, endCol = cols - 1;
			return searchMatrix(matrix, startRow, endRow, startCol, endCol, target);
		}
		return false;
	}

	private static boolean searchMatrix(int[][] matrix, int startRow, int endRow, int startCol, int endCol,
			int target) {
		if (startRow <= endRow && startCol <= endCol) {
			int middleRow = (startRow + endRow) / 2, middleCol = (startCol + endCol) / 2;
			if (matrix[middleRow][middleCol] == target)
				return true;
			else if (matrix[middleRow][middleCol] < target)
				return searchMatrix(matrix, startRow, middleRow, middleCol + 1, endCol, target)
						|| searchMatrix(matrix, middleRow + 1, endRow, middleCol + 1, endCol, target)
						|| searchMatrix(matrix, middleRow + 1, endRow, startCol, middleCol, target);
			else
				return searchMatrix(matrix, startRow, middleRow - 1, startCol, middleCol - 1, target)
						|| searchMatrix(matrix, startRow, middleRow - 1, middleCol, middleCol, target)
						|| searchMatrix(matrix, middleRow, middleRow, startCol, middleCol - 1, target)
						|| searchMatrix(matrix, startRow, middleRow, middleCol + 1, endCol, target)
						|| searchMatrix(matrix, middleRow + 1, endRow, startCol, middleCol, target);
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] nums = new int[][] { { 1, 2, 3, 4, 5 }, { 6, 7, 8, 9, 10 }, { 11, 12, 13, 14, 15 },
				{ 16, 17, 18, 19, 20 }, { 21, 22, 23, 24, 25 } };

//		System.out.println(searchMatrix(nums, 4));

		outer: for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[0].length; j++) {
				if (!searchMatrix(nums, nums[i][j])) {
					System.out.println("Wrong!" + nums[i][j]);
					break outer;
				}

			}
		}
		System.out.println();
	}
}
