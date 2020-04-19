package backtracking;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in
 * the diagram below).
 * 
 * The robot can only move either down or right at any point in time. The robot
 * is trying to reach the bottom-right corner of the grid (marked 'Finish' in
 * the diagram below).
 * 
 * Now consider if some obstacles are added to the grids. How many unique paths
 * would there be?
 * 
 * @author rajan-c
 *
 */
public class UniquePath {

	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int rows = obstacleGrid.length, columns = rows > 0 ? obstacleGrid[0].length : 0;
		if (rows > 0 && columns > 0 && obstacleGrid[0][0] == 1)
			return 0;
		obstacleGrid[0][0] = 1;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				if (i == 0 && j > 0) {
					obstacleGrid[i][j] = (obstacleGrid[i][j]) == 0 ? (obstacleGrid[i][j - 1]) : -1;
				} else if (j == 0 && i > 0)
					obstacleGrid[i][j] = (obstacleGrid[i][j]) == 0 ? (obstacleGrid[i - 1][j]) : -1;
				else if (i > 0 && j > 0)
					obstacleGrid[i][j] = -1 * (obstacleGrid[i][j]);
			}
		}

		for (int i = 1; i < rows; i++) {
			for (int j = 1; j < columns; j++) {
				if (obstacleGrid[i][j] >= 0) {
					if (obstacleGrid[i][j - 1] >= 0 && obstacleGrid[i - 1][j] >= 0)
						obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
					else
						obstacleGrid[i][j] = Math.max(obstacleGrid[i - 1][j], obstacleGrid[i][j - 1]);
				}
			}
		}
		return obstacleGrid[rows - 1][columns - 1] < 0 ? 0 : obstacleGrid[rows - 1][columns - 1];
	}

	public static void main(String[] args) {
		int[][] grid = { { 0, 0 }, { 1, 1 }, { 0, 0 } };
		grid = new int[][] { { 1 } };
//		grid = new int[][] { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 0, 0 } };
//		grid = new int[][] { { 0, 0, 0 }, { 0, 0, 1 }, { 0, 0, 0 } };
		System.out.println(uniquePathsWithObstacles(grid));
	}
}
