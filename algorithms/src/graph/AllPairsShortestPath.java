package graph;

import auxiliaryMethods.CommonMethods;

public class AllPairsShortestPath {

	public static long[][] allPairShortestPathsNonOptimized(int[][] weights) {
		int size = weights.length;
		long[][] previousCalculation = clone(weights);
		for (int m = 1; m <= size; m = 2 * m)
			previousCalculation = allPairShortestPathHelper(weights, previousCalculation);
		return previousCalculation;
	}

	private static long[][] clone(int[][] weights) {
		long[][] clone = new long[weights.length][weights.length];
		for (int row = 0; row < weights.length; row++) {
			for (int col = 0; col < weights.length; col++)
				clone[row][col] = weights[row][col];
		}
		return clone;
	}

	private static long[][] allPairShortestPathHelper(int[][] weights, long[][] previousCalculation) {
		long[][] newWeights = new long[weights.length][weights.length];
		for (int row = 0; row < weights.length; row++) {
			for (int col = 0; col < weights.length; col++) {
				long newWeight = Integer.MAX_VALUE;
				for (int k = 0; k < weights.length; k++) {
					newWeight = Math.min(newWeight, previousCalculation[row][k] + weights[k][col]);
				}
				newWeights[row][col] = newWeight;
			}
		}
		return newWeights;
	}

	/**
	 * This algorithm computes the shortest paths between all pairs of the vertices
	 * in the graph. Running time of this algorithm is O(n^3). This is the
	 * implementation of the johnson's algorithm.
	 * 
	 * @param weights
	 * @return
	 */
	public static long[][] allPairShortestPathJohnsonAlgorithm(int[][] weights) {
		long[][] shortestPaths = new long[weights.length][weights.length];
		for (int row = 0; row < weights.length; row++)
			for (int col = 0; col < weights.length; col++)
				shortestPaths[row][col] = weights[row][col];

		for (int k = 0; k < weights.length; k++) {
			for (int row = 0; row < weights.length; row++) {
				for (int col = 0; col < weights.length; col++) {
					shortestPaths[row][col] = Math.min(shortestPaths[row][col],
							shortestPaths[row][k] + shortestPaths[k][col]);
				}
			}
		}
		return shortestPaths;
	}

	public static void main(String[] args) {
		int[][] weights = new int[][] { { 0, 3, 8, Integer.MAX_VALUE, -4 },
				{ Integer.MAX_VALUE, 0, Integer.MAX_VALUE, 1, 7 },
				{ Integer.MAX_VALUE, 4, 0, Integer.MAX_VALUE, Integer.MAX_VALUE },
				{ 2, Integer.MAX_VALUE, -5, 0, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, 6, 0 } };
		CommonMethods.display(allPairShortestPathsNonOptimized(weights));
		System.out.println("---------johnson----------");
		CommonMethods.display(allPairShortestPathJohnsonAlgorithm(weights));
	}
}
