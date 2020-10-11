package practice.graph.allPairsShortestpath;

import java.util.Arrays;

public class Problem25_1_1 {
	public static void allPairsShortestPaths(long[][] weights) {
		long[][] shortestPaths = new long[weights.length][weights.length];
		for (int i = 0; i < weights.length; i++)
			for (int j = 0; j < weights.length; j++)
				shortestPaths[i][j] = weights[i][j];

		int iterationCount = (int) (Math.log(weights.length));
		for (int i = 0; i <= iterationCount + 1; i++) {
			weights = extendShortestPath(shortestPaths, weights);
		}

		for (int i = 0; i < weights.length; i++)
			System.out.println(Arrays.toString(shortestPaths[i]));
	}

	private static long[][] extendShortestPath(long[][] currentWeights, long[][] weights) {
		long[][] newWeights = new long[weights.length][weights.length];
		for (int i = 0; i < weights.length; i++) {
			for (int j = 0; j < weights.length; j++)
				currentWeights[i][j] = weights[i][j];
		}

		for (int i = 0; i < weights.length; i++) {
			for (int j = 0; j < weights.length; j++) {
				newWeights[i][j] = Integer.MAX_VALUE;
				for (int k = 0; k < weights.length; k++)
					newWeights[i][j] = Math.min(newWeights[i][j], currentWeights[i][k] + weights[k][j]);
			}
		}
		return newWeights;
	}

	public static void main(String[] args) {
		long[][] weights = new long[][] {
				{ 0, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE, -1, Integer.MAX_VALUE },
				{ 1, 0, Integer.MAX_VALUE, 2, Integer.MAX_VALUE, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, 2, 0, Integer.MAX_VALUE, Integer.MAX_VALUE, -8 },
				{ -4, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, 3, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, 7, Integer.MAX_VALUE, Integer.MAX_VALUE, 0, Integer.MAX_VALUE },
				{ Integer.MAX_VALUE, 5, 10, Integer.MAX_VALUE, Integer.MAX_VALUE, 0 } };
		allPairsShortestPaths(weights);
	}
}
