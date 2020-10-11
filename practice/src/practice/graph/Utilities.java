package practice.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Utilities {
	/**
	 * Converts given weighted.graph in edge array form to adjacentList
	 * representation..
	 * 
	 * @param source
	 * @param edges  each edge is of size 3: edge[0] source, edge[1] target and
	 *               edge[2] is weight.
	 * @return
	 */
	public static Map<Integer, List<int[]>> makeGraph(int[][] edges) {
		Map<Integer, List<int[]>> graph = new HashMap<>();
		for (int[] edge : edges) {
			int x = edge[0];
			graph.putIfAbsent(x, new ArrayList<>());
			graph.get(x).add(new int[] { edge[1], edge[2] });
		}
		return graph;
	}
}
