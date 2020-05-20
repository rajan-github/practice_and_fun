package graph;

import java.util.Stack;

/**
 * Give a linear-time algorithm that takes as input a directed acyclic graph
 * G(V,E) and two vertices s and t, and returns the number of simple paths from
 * s to t in G. For example, the directed acyclic graph of Figure 22.8 contains
 * exactly four simple paths from vertex p to vertex v: pov, poryv, posryv, and
 * psryv. (Your algorithm needs only to count the simple paths, not list them.)
 * NOTE: It works on DAG. Complexity is O(V+E).
 * 
 * @author rajan-c
 *
 */
public class NumberOfPaths {
	public static int findAllPaths(int source, int destination, Graph g) {
		int count = 0;
		if (g != null & g.isDirected()) {
			EdgeNode[] adjacentListArray = g.getEdges();
			Stack<Integer> stack = new Stack<>();
			stack.push(source);
			while (!stack.isEmpty()) {
				int node = stack.pop();
				EdgeNode adjacencyList = adjacentListArray[node];
				while (adjacencyList != null) {
					int y = adjacencyList.getY();
					if (y == destination)
						count++;
					else
						stack.push(y);
					adjacencyList = adjacencyList.getNext();
				}
			}
		} else
			System.out.println("Invalid graph!");
		return count;
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Graphs.readGraph(g, true);
		System.out.println(findAllPaths(1, 6, g));
	}
}
