package graph;

/**
 * This is adjacency list representation of the graph.
 * 
 * @author rajan-c
 *
 */
public class Graph {
	/*
	 * Adjacency info.
	 */
	private EdgeNode[] edges;
	/*
	 * outdegree info.
	 */
	private int[] degree;
	/*
	 * number of vertices in graph.
	 */
	private int nvertices;
	/*
	 * number of edges in graph.
	 */
	private int nedges;
	/*
	 * is graph directed.
	 */
	private boolean directed;

	public EdgeNode[] getEdges() {
		return edges;
	}

//	public void setEdges(EdgeNode[] edges) {
//		this.edges = edges;
//	}

//	public int[] getDegree() {
//		return degree;
//	}
//
//	public void setDegree(int[] degree) {
//		this.degree = degree;
//	}

	public void increaseDegree(int x) {
		if (degree[x] > 1)
			degree[x] += 1;
	}

	/*
	 * set degree of x to k.
	 */
	public void setDegree(int x, int k) {
		if (k >= 0)
			degree[x] = k;
	}

	public int getNvertices() {
		return nvertices;
	}

	public void setNvertices(int nvertices) {
		this.nvertices = nvertices;
		this.degree = new int[nvertices + 1];
		this.edges = new EdgeNode[nvertices + 1];
	}

	public int getNedges() {
		return nedges;
	}

	public void setNedges(int nedges) {
		this.nedges = nedges;
	}

	public boolean isDirected() {
		return directed;
	}

	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	/*
	 * compute the in-degree of node x.
	 * 
	 * @param x
	 * 
	 * @return
	 */
	public int indegree(int x) {
		int indegree = 0;
		for (int i = 1; i <= nvertices; i++) {
			if (i != x) {
				EdgeNode adjacents = this.edges[i];
				while (adjacents != null) {
					if (adjacents.getY() == x)
						indegree++;
					adjacents = adjacents.getNext();
				}
			}
		}
		return indegree;
	}
}
