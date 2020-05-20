package graph;

public class GraphsWithMatrix {

	public static void printGraph(GraphWithArray g) {
		if (g != null) {
			int rows = g.getVertex();
			for (int row = 1; row <= rows; row++) {
				for (int col = 1; col <= rows; col++)
					System.out.print(g.getEdge(row, col) + ", ");
				System.out.println();
			}
		}
	}

	public static GraphWithArray transpose(GraphWithArray g) {
		if (g != null) {
			int vertices = g.getVertex();
			GraphWithArray transpose = new GraphWithArray(vertices, g.isDirected());
			for (int i = 1; i <= vertices; i++) {
				for (int j = 1; j <= vertices; j++) {
					transpose.insertEdge(j, i);
				}
			}
			return transpose;
		}
		return null;
	}

	public static GraphWithArray square(GraphWithArray g) {
		if (g != null) {
			int vertices = g.getVertex();
			GraphWithArray square = new GraphWithArray(g.getVertex(), g.isDirected());
			if (vertices > 0) {
				for (int row = 1; row <= vertices; row++) {
					for (int col = 1; col <= vertices; col++) {
						boolean entry = false;
						for (int k = 1; k <= vertices && !entry; k++)
							entry = (g.getEdge(row, k) + g.getEdge(k, col)) > 0;

						if (entry)
							square.insertEdge(row, col);
					}
				}
			}
			return square;
		}
		return g;
	}

	public static void main(String[] args) {

	}
}
