package topIntQuestions;

import java.util.HashMap;
import java.util.Map;

/**
 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be
 * validated according to the following rules:
 * 
 * Each row must contain the digits 1-9 without repetition. Each column must
 * contain the digits 1-9 without repetition. Each of the 9 3x3 sub-boxes of the
 * grid must contain the digits 1-9 without repetition.
 * 
 * @author rajan-c
 *
 */
public class ValidSudoku {

	public static boolean isValidSudoku(char[][] board) {
		if (board == null || board.length == 0 || board[0].length == 0)
			return false;
		boolean isValid = true;
		for (int row = 0; row <= board.length - 3 && isValid; row += 3) {
			for (int col = 0; col <= board[0].length - 3 && isValid; col += 3)
				isValid = isValid && validateSquare(board, row, col);
		}
		return isValid;
	}

	private static boolean validateSquare(char[][] board, int row, int col) {
		Map<Character, int[]> squareMap = new HashMap<>();

		for (int i = row; i < row + 3; i++) {
			for (int j = col; j < col + 3; j++) {
				char c = board[i][j];
				if (Character.isDigit(c)) {
					if (squareMap.containsKey(c) || !isValidCol(board, i, j, c) || !isValidRow(board, i, j, c))
						return false;
					else
						squareMap.put(c, new int[] { i, j });
				}
			}
		}
		return true;
	}

	private static boolean isValidCol(char[][] board, int row, int col, char c) {
		for (int i = 0; i < board.length; i++) {
			char temp = board[i][col];
			if (i != row && Character.isDigit(temp) && temp == c) {
				return false;
			}
		}
		return true;
	}

	private static boolean isValidRow(char[][] board, int row, int col, char c) {
		for (int i = 0; i < board[0].length; i++) {
			char temp = board[row][i];
			if (i != col && Character.isDigit(temp) && temp == c)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { '.', '.', '.', '9', '.', '.', '.', '.', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '.', '.', '3', '.', '.', '.', '.', '.', '1' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '1', '.', '.', '.', '.', '.', '3', '.', '.' },
				{ '.', '.', '.', '.', '2', '.', '6', '.', '.' }, { '.', '9', '.', '.', '.', '.', '.', '7', '.' },
				{ '.', '.', '.', '.', '.', '.', '.', '.', '.' }, { '8', '.', '.', '8', '.', '.', '.', '.', '.' } };
		System.out.println(isValidSudoku(board));
	}
}
