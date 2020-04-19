package arrays;

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

	public boolean isValidSudoku(char[][] board) {
		return validateAllSquares(board) && verifyRows(board) && verifyColumns(board);
	}

	private static boolean verifyRows(char[][] board) {
		boolean valid = true;
		Map<Character, Integer> map = new HashMap<>();
		map.put('1', 1);
		map.put('2', 1);
		map.put('3', 1);
		map.put('4', 1);
		map.put('5', 1);
		map.put('6', 1);
		map.put('7', 1);
		map.put('8', 1);
		map.put('9', 1);
		outer: for (int row = 0; row < 9; row++) {
			for (int column = 0; column < 9; column++) {
				if (board[row][column] != '.') {
					if (map.containsKey(board[row][column]))
						map.remove(board[row][column]);
					else {
						valid = false;
						break outer;
					}
				}
			}
		}
		return valid;
	}

	private static boolean verifyColumns(char[][] board) {
		boolean valid = true;
		Map<Character, Integer> map = new HashMap<>();
		map.put('1', 1);
		map.put('2', 1);
		map.put('3', 1);
		map.put('4', 1);
		map.put('5', 1);
		map.put('6', 1);
		map.put('7', 1);
		map.put('8', 1);
		map.put('9', 1);
		outer: for (int column = 0; column < 9; column++) {
			for (int row = 0; row < 9; row++) {
				if (board[column][row] != '.') {
					if (map.containsKey(board[row][column]))
						map.remove(board[row][column]);
					else {
						valid = false;
						break outer;
					}
				}
			}
		}
		return valid;
	}

	private static boolean validateAllSquares(char[][] board) {
		boolean valid = true;
		outer: for (int i = 0; i <= 6; i += 3) {
			for (int j = 0; j <= 6; j += 3) {
				valid = valid && validateSquare(board, i, j);
				if (!valid)
					break outer;
			}
		}
		return valid;
	}

	private static boolean validateSquare(char[][] board, int row, int column) {
		boolean isValid = true;
		Map<Character, Integer> map = new HashMap<>();
		map.put('1', 1);
		map.put('2', 1);
		map.put('3', 1);
		map.put('4', 1);
		map.put('5', 1);
		map.put('6', 1);
		map.put('7', 1);
		map.put('8', 1);
		map.put('9', 1);
		outer: for (int i = row; i < row + 3; i++) {
			for (int j = column; j < column + 3; j++) {
				if (board[i][j] != '.') {
					if (map.containsKey(board[i][j])) {
						map.remove(board[i][j]);
					} else {
						isValid = false;
						break outer;
					}
				}
			}
		}
		return isValid;
	}

	public static char[][] getSudoku() {
		char[][] sudoku = new char[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++)
				sudoku[i][j] = '.';
		}
		return sudoku;
	}

	public static void main(String[] args) {
		char[][] sudoku = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		System.out.println(validateAllSquares(sudoku));
	}
}
