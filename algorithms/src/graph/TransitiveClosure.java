package graph;

import auxiliaryMethods.CommonMethods;

/**
 * Compute the transitive closure of the graph. Transitive closure of the graph
 * is graph G(V,E`), where E`(i,j)=1 if there is a path from vertex i to vertex
 * j.
 * 
 * @author rajan-c
 *
 */
public class TransitiveClosure {
	public static boolean[][] transitiveClosure(int[][] adjacencyMatrix) {
		boolean[][] transitiveClosure = new boolean[adjacencyMatrix.length][adjacencyMatrix.length];
		for (int row = 0; row < adjacencyMatrix.length; row++) {
			for (int col = 0; col < adjacencyMatrix.length; col++) {
				transitiveClosure[row][col] = adjacencyMatrix[row][col] < Integer.MAX_VALUE;
			}
		}

		for (int i = 0; i <= adjacencyMatrix.length; i++) {
			for (int row = 0; row < adjacencyMatrix.length; row++) {
				for (int col = 0; col < adjacencyMatrix.length; col++) {
					transitiveClosure[row][col] = transitiveClosure[row][col]
							|| (transitiveClosure[row][i] && transitiveClosure[i][col]);
				}
			}
		}
		return transitiveClosure;
	}

	public static void main(String[] args) {
		int[][] weights = new int[][] { { 0, 3, 8, Integer.MAX_VALUE, -4 },
				{ Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 1, 7 },
				{ Integer.MAX_VALUE, 4, 0, Integer.MAX_VALUE, Integer.MAX_VALUE },
				{ 2, Integer.MAX_VALUE, -5, 0, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 0 } };
		CommonMethods.display(transitiveClosure(weights));
	}
}
