package backtracking.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other. Given an integer n, return the
 * number of distinct solutions to the n-queens puzzle.
 * 
 * @author rajan-c
 *
 */
public class NQueens {
	public int totalNQueens(int n) {
		List<int[]> occupied = new ArrayList<>();
		Set<List<int[]>> foundConfigs = new HashSet<>();
		totalNQueensBacktrack(n, occupied, foundConfigs, n);
		return foundConfigs.size();
	}

	public boolean totalNQueensBacktrack(int n, List<int[]> occupied, Set<List<int[]>> foundConfigs, int length) {
		if (n == 0) {
			List<int[]> clone = new ArrayList<>();
			for (int[] position : occupied)
				clone.add(position);
			foundConfigs.add(clone);
			return true;
		}

		List<int[]> choices = getChoices(occupied, length, length);
		for (int[] choice : choices) {
			occupied.add(choice);
			totalNQueensBacktrack(n - 1, occupied, foundConfigs, length);
			occupied.remove(occupied.size() - 1);
		}
		return false;
	}

	private List<int[]> getChoices(List<int[]> occupied, int rows, int cols) {
		List<int[]> validChoices = new ArrayList<>(), allChoices = new ArrayList<>();
		int row = occupied.size();
		for (int col = 0; col < cols; col++) {
			allChoices.add(new int[] { row, col });
		}

		outer: for (int[] choice : allChoices) {
			for (int[] used : occupied) {
				if (used[0] == choice[0] || used[1] == choice[1]
						|| (Math.abs(used[0] - choice[0]) == Math.abs(used[1] - choice[1])))
					continue outer;
			}
			validChoices.add(choice);
		}

		return validChoices;
	}

	public static void main(String[] args) {
		System.out.println(new NQueens().totalNQueens(8));
		System.out.println(new NQueens().totalNQueens(4));
	}
}