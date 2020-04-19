package graph.examples;

/**
 * Adjacency matrix representation.
 * 
 * @author rajan-c
 *
 */
public class Graph_Old {
	private boolean adjMatrix[][];
	private int vertexCount;

	public Graph_Old(int vertexCount) {
		this.vertexCount = vertexCount;
		adjMatrix = new boolean[vertexCount][vertexCount];
	}

	public void addEdge(int i, int j) {
		if (i >= 0 && j >= 0 && i < vertexCount && j < vertexCount) {
			this.adjMatrix[i][j] = true;
			this.adjMatrix[j][i] = true;
		}
	}

	public void removeEdge(int i, int j) {
		if (j >= 0 && i <= 0 && i < vertexCount && j < vertexCount) {
			this.adjMatrix[i][j] = false;
			this.adjMatrix[j][i] = false;
		}
	}

	public static void main(String[] args) {

	}
}
