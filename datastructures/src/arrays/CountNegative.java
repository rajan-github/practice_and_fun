package arrays;

public class CountNegative {
	public int countNegatives(int[][] grid) {
		int rows = grid.length;
		int columns = grid[0].length;
		int negatives = 0;

		for (int i = 0; i < columns; i++) {
			int columnLength = 0;
			while (columnLength < rows && grid[columnLength][i] >= 0)
				columnLength++;
			if (columnLength < rows) {
				negatives = negatives + (rows - columnLength);
			}
		}

		return negatives;
	}

	public static void main(String[] args) {
		CountNegative cn = new CountNegative();
		int[][] grid = new int[][] { { 4, 3, 2, -1 }, { 3, 2, 1, -1 }, { 1, 1, -1, -2 }, { -1, -1, -2, -3 } };
		System.out.println(cn.countNegatives(grid));
	}
}
