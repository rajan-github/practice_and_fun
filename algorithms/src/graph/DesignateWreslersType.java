package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * There are two types of professional wrestlers: “babyfaces” (“good guys”) and
 * “heels” (“bad guys”). Between any pair of professional wrestlers, there may
 * or may not be a rivalry. Suppose we have n professional wrestlers and we have
 * a list of r pairs of wrestlers for which there are rivalries. Give an O.n C
 * r/-time algo- rithm that determines whether it is possible to designate some
 * of the wrestlers as babyfaces and the remainder as heels such that each
 * rivalry is between a babyface and a heel. If it is possible to perform such a
 * designation, your algorithm should produce it.
 * 
 * @author rajan-c
 *
 */
public class DesignateWreslersType {

	public static char[] designateWrestlers(Graph g) {
		if (g != null) {
			int size = g.getNvertices();
			Queue<Integer> queue = new LinkedList<>();
			int[] parent = new int[size + 1];
			char[] color = new char[size + 1];
			Set<Integer> visited = new HashSet<>();
			EdgeNode[] edgeLists = g.getEdges();
			int source = 1;
			queue.add(source);
			color[source] = 'b';
			visited.add(source);
			while (!queue.isEmpty()) {
				int node = queue.remove();
				EdgeNode adjacencyList = edgeLists[node];
				while (adjacencyList != null) {
					int y = adjacencyList.getY();
					if (!visited.contains(y)) {
						queue.add(y);
						visited.add(y);
						parent[y] = node;
						boolean bUsed = false, hUsed = false;
						EdgeNode adj = edgeLists[y];
						while ((!bUsed || !hUsed) && adj != null) {
							if (color[adj.getY()] == 'b')
								bUsed = true;
							else if (color[adj.getY()] == 'h')
								hUsed = true;
							adj = adj.getNext();
						}
						if (bUsed && hUsed)
							return null;
						else if (bUsed)
							color[y] = 'h';
						else
							color[y] = 'b';
					}
					adjacencyList = adjacencyList.getNext();
				}
			}
			return color;
		}
		return null;
	}

	public static void main(String[] args) {
		Graph g = new Graph();
		Graphs.readGraph(g, false);
		char[] colors = designateWrestlers(g);
		if (colors != null) {
			for (char color : colors)
				System.out.print(color);
		} else {
			System.out.println("Coloring not possible!");
		}
	}
}
