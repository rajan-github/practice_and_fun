package arrays;

/**
 * Given an N x N grid containing only values 0 and 1, where 0 represents water
 * and 1 represents land, find a water cell such that its distance to the
 * nearest land cell is maximized and return the distance.
 * 
 * The distance used in this problem is the Manhattan distance: the distance
 * between two cells (x0, y0) and (x1, y1) is |x0 - x1| + |y0 - y1|.
 * 
 * If no land or water exists in the grid, return -1.
 * 
 * @author rajan-c
 *
 */
public class AsFarAsFromLandPossible {
	public int maxDistance(int[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		long[][] distances = new long[grid.length][grid.length];
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 1)
					distances[i][j] = 0;
				else
					distances[i][j] = Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid.length; j++) {
				if (grid[i][j] == 0)
					distances[i][j] = 1 + min(j < grid.length - 1 ? distances[i][j + 1] : Integer.MAX_VALUE,
							i < grid.length - 1 ? distances[i + 1][j] : Integer.MAX_VALUE,
							i > 0 ? distances[i - 1][j] : Integer.MAX_VALUE,
							j > 0 ? distances[i][j - 1] : Integer.MAX_VALUE);
			}
		}

		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid.length - 1; j >= 0; j--) {
				if (grid[i][j] == 0)
					distances[i][j] = 1 + min(j < grid.length - 1 ? distances[i][j + 1] : Integer.MAX_VALUE,
							i < grid.length - 1 ? distances[i + 1][j] : Integer.MAX_VALUE,
							i > 0 ? distances[i - 1][j] : Integer.MAX_VALUE,
							j > 0 ? distances[i][j - 1] : Integer.MAX_VALUE);
			}
		}

		long maxDistance = 0;
		for (int i = grid.length - 1; i >= 0; i--) {
			for (int j = grid.length - 1; j >= 0; j--) {
				maxDistance = Math.max(maxDistance, distances[i][j]);
			}
		}
		if (Math.abs(maxDistance) > 2 * grid.length || maxDistance == 0)
			maxDistance = -1;
		return (int) maxDistance;
	}

	private long min(long a, long b, long c, long d) {
		if (a <= b && a <= c && a <= d)
			return a;
		else if (b <= a && b <= c && b <= d)
			return b;
		else if (c <= a && c <= b && c <= d)
			return c;
		else
			return d;
	}
}
