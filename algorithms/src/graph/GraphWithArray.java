package graph;

/**
 * This is graph representation with adjacency array.
 * 
 * @author rajan-c
 *
 */
public class GraphWithArray {
	private int[][] adjacencyMatrix;

	private int vertex;
	private boolean isDirected;

	public GraphWithArray(int vertex, boolean directed) {
		if (vertex > 0) {
			adjacencyMatrix = new int[vertex + 1][vertex + 1];
			this.vertex = vertex;
			this.isDirected = directed;
		} else
			throw new IllegalArgumentException("Invalid vertex size.");
	}

	public int getVertex() {
		return vertex;
	}

	public void setVertex(int vertex) {
		this.vertex = vertex;
	}

	public boolean isDirected() {
		return isDirected;
	}

	public void setDirected(boolean isDirected) {
		this.isDirected = isDirected;
	}

	public int[][] getAdjacencyMatrix() {
		int[][] clone = new int[vertex + 1][vertex + 1];
		for (int row = 0; row < clone.length; row++) {
			for (int col = 0; col < clone.length; col++)
				clone[row][col] = adjacencyMatrix[row][col];
		}
		return clone;
	}

	public void insertEdge(int x, int y) {
		if (x > 0 && y > 0 && x <= vertex && y <= vertex) {
			this.adjacencyMatrix[x][y] = 1;
			if (!isDirected)
				this.adjacencyMatrix[y][x] = 1;
		} else
			throw new IllegalArgumentException("Invalid edge!");
	}

	public int getEdge(int x, int y) {
		if (x > 0 && y > 0 && x <= vertex && y <= vertex) {
			return this.adjacencyMatrix[x][y];
		} else
			throw new IllegalArgumentException("Ivalid edge!");
	}
}
