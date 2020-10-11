package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * In a given grid, each cell can have one of three values:
 * 
 * the value 0 representing an empty cell; the value 1 representing a fresh
 * orange; the value 2 representing a rotten orange. Every minute, any fresh
 * orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a
 * fresh orange. If this is impossible, return -1 instead.
 * 
 * @author rajan-c
 *
 */
public class RottenTomatos {
	public int orangesRotting(int[][] grid) {
		if (!canAllOrangesRotten(grid))
			return -1;
		int time = 0;
		boolean newTomatoRot = false, firstTime = true;
		int rows = grid.length, cols = grid[0].length;
		while (newTomatoRot || firstTime) {
			firstTime = false;
			newTomatoRot = false;
			List<int[]> newRot = new ArrayList<>();
			for (int i = 0; i < rows; i++) {
				for (int j = 0; j < cols; j++) {
					if (grid[i][j] == 1) {
						if ((i > 0 && grid[i - 1][j] == 2) || (i < rows - 1 && grid[i + 1][j] == 2)
								|| (j > 0 && grid[i][j - 1] == 2) || (j < cols - 1 && grid[i][j + 1] == 2)) {
							newTomatoRot = true;
							newRot.add(new int[] { i, j });
						}
					}
				}
			}

			for (int[] index : newRot) {
				grid[index[0]][index[1]] = 2;
			}
			time += 1;
		}

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1)
					return -1;
			}
		}
		return time - 1;
	}

	private boolean canAllOrangesRotten(int[][] grid) {
		int rows = grid.length, cols = grid[0].length;
		List<int[]> ones = new ArrayList<>();
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == 1)
					ones.add(new int[] { i, j });
			}
		}
		return ones.size() < (rows * cols);
	}

}
