package arrays;

/*
 * 
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * @author rajan-c
 *
 */
public class SurrondedRegion2 {
	public static void solve(char[][] board) {
		if (board != null && board.length > 0) {
			int[] rows = new int[] { 0, board.length - 1 };
			int[] cols = new int[] { 0, board[0].length - 1 };

			int[][] directions = new int[][] { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

			for (int row : rows)
				for (int col = 0; col <= cols[1]; col++)
					if (board[row][col] == 'O')
						dfs(board, row, col, directions);
			for (int col : cols)
				for (int row = 0; row <= rows[1]; row++)
					if (board[row][col] == 'O')
						dfs(board, row, col, directions);

			for (int row = 0; row <= rows[1]; row++) {
				for (int col = 0; col <= cols[1]; col++) {
					if (board[row][col] == 'E')
						board[row][col] = 'O';
					else if (board[row][col] == 'O')
						board[row][col] = 'X';
				}
			}
		}
	}

	private static void dfs(char[][] board, int row, int col, int[][] directions) {
		if (row >= 0 && row < board.length && col >= 0 && col < board[0].length) {
			board[row][col] = 'E';
			int rows = board.length, cols = board[0].length;
			for (int[] direction : directions) {
				int newRow = row + direction[0], newCol = col + direction[1];
				if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && board[newRow][newCol] == 'O')
					dfs(board, newRow, newCol, directions);
			}
		}
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		solve(board);
		display(board);
	}

	private static void display(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			System.out.print("[");
			for (int col = 0; col < board[0].length; col++) {
				System.out.print(board[row][col] + ", ");
			}
			System.out.println("]");
		}
	}
}
