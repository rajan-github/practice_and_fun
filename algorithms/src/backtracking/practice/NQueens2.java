package backtracking.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard
 * such that no two queens attack each other. Given an integer n, return all
 * distinct solutions to the n-queens puzzle.
 * 
 * Each solution contains a distinct board configuration of the n-queens'
 * placement, where 'Q' and '.' both indicate a queen and an empty space
 * respectively.
 * 
 * @author rajan-c
 *
 */
public class NQueens2 {

	public List<List<String>> solveNQueens(int n) {
		List<List<String>> solutions = new ArrayList<>();
		if (n > 0) {
			List<int[]> occupied = new ArrayList<>();
			totalNQueensBacktrack(n, occupied, solutions, n);
		}
		return solutions;
	}

	public boolean totalNQueensBacktrack(int n, List<int[]> occupied, List<List<String>> solutions, int length) {
		if (n == 0) {
			List<String> solution = new ArrayList<>();
			for (int[] position : occupied) {
				StringBuilder rowConfig = new StringBuilder();
				for (int i = 0; i < length; i++) {
					if (i == position[1])
						rowConfig.append("Q");
					else
						rowConfig.append(".");
				}
				solution.add(rowConfig.toString());
			}
			solutions.add(solution);
			return true;
		}

		List<int[]> choices = getChoices(occupied, length, length);
		for (int[] choice : choices) {
			occupied.add(choice);
			totalNQueensBacktrack(n - 1, occupied, solutions, length);
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
//		System.out.println(new NQueens().totalNQueens(8));
		System.out.println(new NQueens2().solveNQueens(4));
	}
}
