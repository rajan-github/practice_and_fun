package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Coordinate {
	private int row;
	private int col;

	public Coordinate(int row, int col) {
		this.row = row;
		this.col = col;
	}

	public int getRow() {
		return row;
	}

	public void setRow(int row) {
		this.row = row;
	}

	public int getCol() {
		return col;
	}

	public void setCol(int col) {
		this.col = col;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + col;
		result = prime * result + row;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Coordinate other = (Coordinate) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}
}

public class WordSearch {
	public static boolean exist(char[][] board, String word) {
		boolean found = false;
		List<Coordinate> indexes = new ArrayList<>();
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == word.charAt(0))
					indexes.add(new Coordinate(i, j));
			}
		}

		outer: for (Coordinate index : indexes) {
			int trackedLength = 1;
			if (trackedLength >= word.length()) {
				found = true;
				break;
			}
			Map<Coordinate, Integer> usedIndexes = new HashMap<>();
			usedIndexes.put(index, 1);
			found = exist(index, board, 1, word, usedIndexes);
			if (found)
				break outer;
		}
		return found;
	}

	private static boolean exist(Coordinate index, char[][] board, int trackedLength, String word,
			Map<Coordinate, Integer> usedIndexes) {
		if (trackedLength >= word.length())
			return true;
		else {
			boolean found = false;
			List<Coordinate> choices = matchedAdjacent(index, board, word.charAt(trackedLength), usedIndexes);
			for (Coordinate choice : choices) {
				usedIndexes.put(choice, 1);
				found = exist(choice, board, trackedLength + 1, word, usedIndexes);
				if (!found)
					usedIndexes.remove(choice);
				else
					break;
			}
			return found;
		}
	}

	private static List<Coordinate> matchedAdjacent(Coordinate coordinate, char[][] board, char c,
			Map<Coordinate, Integer> usedIndexes) {
		List<Coordinate> foundMatches = new ArrayList<>();
		int row = coordinate.getRow(), col = coordinate.getCol();

		Coordinate up = new Coordinate(row - 1, col), down = new Coordinate(row + 1, col),
				left = new Coordinate(row, col - 1), right = new Coordinate(row, col + 1);

		if (down.getRow() < board.length && !usedIndexes.containsKey(down)
				&& board[down.getRow()][down.getCol()] == c) {
			foundMatches.add(down);
		}
		if (up.getRow() >= 0 && !usedIndexes.containsKey(up) && board[up.getRow()][up.getCol()] == c) {
			foundMatches.add(up);
		}
		if (right.getCol() < board[0].length && !usedIndexes.containsKey(right)
				&& board[right.getRow()][right.getCol()] == c) {
			foundMatches.add(right);
		}
		if (left.getCol() >= 0 && !usedIndexes.containsKey(left) && board[left.getRow()][left.getCol()] == c) {
			foundMatches.add(left);
		}
		return foundMatches;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'A', 'B', 'C', 'E' }, { 'S', 'F', 'C', 'S' }, { 'A', 'D', 'E', 'E' } };
		System.out.println(exist(board, "ABCCED"));
		System.out.println(exist(board, "SEE"));
		System.out.println(exist(board, "ABCB"));
		board = new char[][] { { 'a' } };
		System.out.println(exist(board, "a"));
		board = new char[][] { { 'C', 'A', 'A' }, { 'A', 'A', 'A' }, { 'B', 'C', 'D' } };
		System.out.println(exist(board, "AAB"));
	}
}
