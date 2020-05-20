package backtracking.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SolveSudoku {
	public static void solveSudoku(char[][] board) {
		List<int[]> freeSlots = new ArrayList<>();
		int rows = board.length, cols = board[0].length;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (board[row][col] == '.')
					freeSlots.add(new int[] { row, col });
			}
		}
		solveSudoku(board, freeSlots);
	}

	private static boolean solveSudoku(char[][] board, List<int[]> freeSlots) {
		if (freeSlots.isEmpty()) {
			for (int i = 0; i < board.length; i++) {
				System.out.print("[");
				for (int j = 0; j < board[0].length; j++)
					System.out.print(board[i][j] + ", ");
				System.out.println("]");
			}
			return true;
		}

		int[] lastIndexSlot = freeSlots.get(freeSlots.size() - 1);
		Set<Character> choices = choices(lastIndexSlot, board);
		for (Character choice : choices) {
			freeSlots.remove(freeSlots.size() - 1);
			board[lastIndexSlot[0]][lastIndexSlot[1]] = choice;
			if (!solveSudoku(board, freeSlots)) {
				freeSlots.add(lastIndexSlot);
				board[lastIndexSlot[0]][lastIndexSlot[1]] = '.';
			} else
				return true;

		}
		return false;
	}

	private static Set<Character> choices(int[] slot, char[][] board) {
		Set<Character> used = new HashSet<>(), validChoices = new HashSet<>();
		char[] allChoices = new char[] { '1', '2', '3', '4', '5', '6', '7', '8', '9' };

		int[] squareCorner = getSquareCorner(slot);
		for (int i = squareCorner[0]; i < (squareCorner[0] + 3); i++) {
			for (int j = squareCorner[1]; j < (squareCorner[1] + 3); j++) {
				if (board[i][j] != '.')
					used.add(board[i][j]);
			}
		}
		for (int i = 0; i < board.length; i++)
			used.add(board[slot[0]][i]);

		for (int i = 0; i < board.length; i++)
			used.add(board[i][slot[1]]);

		for (char choice : allChoices)
			if (!used.contains(choice))
				validChoices.add(choice);

		return validChoices;
	}

	private static int[] getSquareCorner(int[] slot) {
		int row = slot[0], col = slot[1];
		while (row % 3 != 0 || col % 3 != 0) {
			if (row % 3 != 0)
				row++;
			if (col % 3 != 0)
				col++;
		}
		if (row > 0 && row > slot[0])
			row -= 3;
		if (col > 0 && col > slot[1])
			col -= 3;

		return new int[] { row, col };
	}

	public static void main(String[] args) {
		char[][] board = { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
				{ '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
				{ '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
				{ '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
				{ '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };
		solveSudoku(board);
		System.out.println(board);
	}
}