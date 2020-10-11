package graph;

/**
 * Most graph algorithms that take an adjacency-matrix representation as input
 * re- quire time V^2, but there are some exceptions. Show how to determine
 * whether a directed graph G contains a universal sink—a vertex with in-degree
 * V-1 and out-degree 0—in time O(V), given an adjacency matrix for G.
 * 
 * @author rajan-c
 *
 */
public class UniversalSink {
	public static int findUniversalSink(int[][] adjacencyMatrix) {
		if (adjacencyMatrix == null || adjacencyMatrix.length == 0)
			return -1;

		int i = 0, j = 0;
		while (i < adjacencyMatrix.length && j < adjacencyMatrix.length) {
			if (adjacencyMatrix[i][j] == 1)
				i += 1;
			else
				j += 1;
		}

		if (i >= adjacencyMatrix.length)
			i -= 1;
		for (int k = 0; k < adjacencyMatrix.length; k++) {
			if (i != k) {
				if (adjacencyMatrix[i][k] == 1 || adjacencyMatrix[k][i] == 0)
					return -1;
			}
		}
		return i;
	}

	public static void main(String[] args) {
		System.out.println(
				findUniversalSink(new int[][] { { 0, 1, 1, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 0 } }));
	}
}
