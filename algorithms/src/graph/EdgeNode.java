package graph;

/**
 * Edge node. Represent the single edge. We represent directed edge (x,y) by an
 * edgenode y in x�s adjacency list.
 * 
 * @author rajan-c
 *
 */

public class EdgeNode implements Comparable<EdgeNode> {
	/*
	 * vertex identifier. Edge x->y.
	 */
	private int y;
	private int weight;
	private EdgeNode next;
	private int x;

	public int getY() {
		return y;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public EdgeNode getNext() {
		return next;
	}

	public void setNext(EdgeNode next) {
		this.next = next;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((next == null) ? 0 : next.hashCode());
		result = prime * result + weight;
		result = prime * result + x;
		result = prime * result + y;
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
		EdgeNode other = (EdgeNode) obj;
		if (next == null) {
			if (other.next != null)
				return false;
		} else if (!next.equals(other.next))
			return false;
		if (weight != other.weight)
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	@Override
	public int compareTo(EdgeNode other) {
		if (this.getWeight() > other.getWeight())
			return 1;
		else if (this.getWeight() < other.getWeight())
			return -1;
		return 0;
	}

	/**
	 * this method returns the clone of the edge object.
	 */
	public EdgeNode clone() {
		EdgeNode edge = new EdgeNode();
		edge.setNext(this.next);
		edge.setWeight(weight);
		edge.setY(y);
		edge.setX(x);
		return edge;
	}
}
