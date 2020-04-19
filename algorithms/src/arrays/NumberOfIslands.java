package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
 * islands. An island is surrounded by water and is formed by connecting
 * adjacent lands horizontally or vertically. You may assume all four edges of
 * the grid are all surrounded by water.
 * 
 * @author rajan-c
 *
 */
public class NumberOfIslands {
	public static int numIslands(char[][] grid) {
		if (grid == null || grid.length == 0)
			return 0;
		int rows = grid.length, cols = grid[0].length;
		Map<Index, Integer> processed = new HashMap<Index, Integer>();
		int islandCount = 0;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				Index currentIndex = new Index(row, col);
				if (!processed.containsKey(currentIndex)) {
					List<Index> tree = new ArrayList<>();
					dfs(grid, processed, currentIndex, tree);
					if (!tree.isEmpty())
						islandCount++;
				}

			}
		}
		return islandCount;
	}

	private static void dfs(char[][] grid, Map<Index, Integer> processed, Index currentItem, List<Index> tree) {
		if ((currentItem.row < 0 || currentItem.col < 0 || currentItem.row >= grid.length
				|| currentItem.col >= grid[0].length)) {
			return;
		}
		if (grid[currentItem.row][currentItem.col] == '1') {
			tree.add(currentItem);
			List<Index> adjacents = new ArrayList<>();
			adjacents.add(new Index(currentItem.row + 1, currentItem.col));
			adjacents.add(new Index(currentItem.row - 1, currentItem.col));
			adjacents.add(new Index(currentItem.row, currentItem.col + 1));
			adjacents.add(new Index(currentItem.row, currentItem.col - 1));
			for (Index adjacent : adjacents) {
				if (!processed.containsKey(adjacent)) {
					processed.put(adjacent, 1);
					dfs(grid, processed, adjacent, tree);
				}
			}
		}
	}

	public static void main(String[] args) {
		char[][] grid = new char[][] { { '1', '1', '1', '1', '0' }, { '1', '1', '0', '1', '0' },
				{ '1', '1', '0', '0', '0' }, { '0', '0', '0', '0', '0' } };
//		grid = new char[][] { { '1', '1' }, { '1', '1' } };
		grid = new char[][] { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };

//		grid = new char[][] {};
//		grid = new char[][] { { '1', '1' } };
//		grid = new char[][] { { '1', '1', '1' }, { '0', '1', '0' }, { '1', '1', '1' } };
//		grid = new char[][] { { '1', '0', '1', '1', '1' }, { '1', '0', '1', '0', '1' }, { '1', '1', '1', '0', '1' } };
		System.out.println(numIslands(grid));
	}
}

class Index {
	int row;
	int col;

	public Index(int row, int col) {
		this.row = row;
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
		Index other = (Index) obj;
		if (col != other.col)
			return false;
		if (row != other.row)
			return false;
		return true;
	}

}
