package arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions
 * surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded
 * region.
 * 
 * @author rajan-c
 *
 */
public class SurroundedRegions {

	public static void solve(char[][] board) {
		if (board != null && board.length > 0) {
			Set<Pair> set = new HashSet<>(), nullSet = new HashSet<>();

			int rows = board.length, cols = board[0].length;
			for (int row = 0; row < rows; row++)
				if (board[row][0] == 'O')
					nullSet.add(new Pair(row, 0));

			for (int col = 0; col < cols; col++)
				if (board[0][col] == 'O')
					nullSet.add(new Pair(0, col));

			for (int row = 0; row < rows; row++)
				if (board[row][cols - 1] == 'O')
					nullSet.add(new Pair(row, cols - 1));

			for (int col = 0; col < cols; col++)
				if (board[rows - 1][col] == 'O')
					nullSet.add(new Pair(rows - 1, col));

			for (int row = 1; row < rows; row++) {
				for (int col = 1; col < cols; col++) {
					Pair pair = new Pair(row, col);
					if (!set.contains(pair) && board[pair.row][pair.col] == 'O' && !nullSet.contains(pair)) {
						bfs(board, pair, set, nullSet);
					}
				}
			}
		}
	}

	private static void bfs(char[][] board, Pair start, Set<Pair> set, Set<Pair> nullSet) {
		List<Pair> tree = new ArrayList<>();
		int rows = board.length, cols = board[0].length;
		Queue<Pair> queue = new LinkedList<>();

		queue.add(start);
		Set<Pair> usedPair = new HashSet<>();

		while (!queue.isEmpty()) {
			Pair pair = queue.remove();
			usedPair.add(pair);
			set.add(pair);

			if ((pair.row == rows - 1 || pair.col == cols - 1 || pair.row == 0 || pair.col == 0)) {
				for (Pair item : tree)
					nullSet.add(item);
				return;
			}

			tree.add(pair);
			Pair up = new Pair(pair.row - 1, pair.col);
			Pair down = new Pair(pair.row + 1, pair.col);
			Pair left = new Pair(pair.row, pair.col - 1);
			Pair right = new Pair(pair.row, pair.col + 1);
			if (nullSet.contains(up) || nullSet.contains(down) || nullSet.contains(left) || nullSet.contains(right)) {
				nullSet.add(pair);
				return;
			}

			if (left.col >= 0 && board[left.row][left.col] == 'O' && !usedPair.contains(left)) {
				queue.add(left);
				set.add(left);
			}

			if (right.col < cols && board[right.row][right.col] == 'O' && !usedPair.contains(right)) {
				queue.add(right);
				set.add(right);
			}

			if (up.row >= 0 && board[up.row][up.col] == 'O' && !usedPair.contains(up)) {
				queue.add(up);
				set.add(up);
			}

			if (down.row < rows && board[down.row][down.col] == 'O' && !usedPair.contains(down)) {
				queue.add(down);
				set.add(down);
			}
		}

		for (Pair item : tree) {
			board[item.row][item.col] = 'X';
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

class Pair {
	int row, col;

	public Pair(int _row, int _col) {
		this.row = _row;
		this.col = _col;
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
		Pair other = (Pair) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
