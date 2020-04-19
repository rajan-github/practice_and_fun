package backtracking.practice;

/**
 * Young boy Artem tries to paint a picture, and he asks his mother Medina to
 * help him. Medina is very busy, that's why she asked for your help.
 * 
 * Artem wants to paint an n×m board. Each cell of the board should be colored
 * in white or black.
 * 
 * Lets B be the number of black cells that have at least one white neighbor
 * adjacent by the side. Let W be the number of white cells that have at least
 * one black neighbor adjacent by the side. A coloring is called good if B=W+1.
 * 
 * The first coloring shown below has B=5 and W=4 (all cells have at least one
 * neighbor with the opposite color). However, the second coloring is not good
 * as it has B=4, W=4 (only the bottom right cell doesn't have a neighbor with
 * the opposite color).
 * 
 * Please, help Medina to find any good coloring. It's guaranteed that under
 * given constraints the solution always exists. If there are several solutions,
 * output any of them.
 * 
 * Input Each test contains multiple test cases.
 * 
 * The first line contains the number of test cases t (1≤t≤20). Each of the next
 * t lines contains two integers n,m (2≤n,m≤100) — the number of rows and the
 * number of columns in the grid.
 * 
 * Output For each test case print n lines, each of length m, where i-th line is
 * the i-th row of your colored matrix (cell labeled with 'B' means that the
 * cell is black, and 'W' means white). Do not use quotes.
 * 
 * It's guaranteed that under given constraints the solution always exists.
 * 
 * @author rajan-c
 *
 */
public class LittleArtem {

	public static void getGoodColoring(int row, int col, int n, int m, boolean[][] board) {
		if (row >= n) {
			if (isGoodColoring(board)) {
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++)
						if (board[i][j])
							System.out.print('W');
						else
							System.out.print('B');
					System.out.println();
				}
			}
			return;
		} else if (col >= m && row < n) {
			getGoodColoring(row + 1, 0, n, m, board);
		} else {
			board[row][col] = false;
			getGoodColoring(row, col + 1, n, m, board);
			board[row][col] = true;
			getGoodColoring(row, col + 1, n, m, board);
		}
	}

	private static boolean isGoodColoring(boolean[][] board) {
		int n = board.length, m = board[0].length;
		int black = 0, white = 0;
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < m; col++) {
				if (board[row][col]) {
					if (row > 0 && !board[row - 1][col])
						white++;
					else if (col + 1 < m && !board[row][col + 1])
						white++;
					else if (col > 0 && !board[row][col - 1])
						white++;
					else if (row + 1 < n && !board[row + 1][col])
						white++;
				} else {
					if (row > 0 && board[row - 1][col])
						black++;
					else if (col + 1 < m && board[row][col + 1])
						black++;
					else if (col > 0 && board[row][col - 1])
						black++;
					else if (row + 1 < n && board[row + 1][col])
						black++;
				}
			}
		}
		return black == white + 1;
	}

	public static void main(String[] args) {
		getGoodColoring(0, 0, 3, 2, new boolean[3][2]);
	}
}
