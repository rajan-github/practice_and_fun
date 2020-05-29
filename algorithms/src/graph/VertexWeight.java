package graph;

/**
 * This class is used to store the vertex and their edge weight by which they
 * are connected in the minimum spanning tree. Vertex Weight is used to create a
 * min heap of vertices with their weights and then extract min and decrease key
 * operations are applied on these vertex objects to implement the prims
 * algorithm.
 */
class VertexWeight implements Comparable<VertexWeight> {
	int vertex;
	int weight;

	public VertexWeight(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}

	@Override
	public int compareTo(VertexWeight o) {
		if (o.weight > weight)
			return -1;
		else if (weight > o.weight)
			return 1;
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + vertex;
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
		VertexWeight other = (VertexWeight) obj;
		if (vertex != other.vertex)
			return false;
		return true;
	}
}
