package graph.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to
 * numCourses-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, is it
 * possible for you to finish all courses?
 * 
 * @author rajan-c
 *
 */
public class CanFinishCourses {
	public static boolean canFinish(int numCourses, int[][] prerequisites) {
		if (numCourses <= 0)
			return true;
		Map<Integer, Set<Integer>> adjacencyLists = new HashMap<>();

		for (int i = 0; i < numCourses; i++)
			adjacencyLists.put(i, new HashSet<>());

		for (int[] edge : prerequisites) {
			int source = edge[1], destination = edge[0];
			adjacencyLists.get(source).add(destination);
		}
		return dfs(adjacencyLists);
	}

	private static boolean dfs(Map<Integer, Set<Integer>> adjacencyLists) {
		Set<Integer> visitedGray = new HashSet<>(), visitedBlack = new HashSet<>();
		int vertices = adjacencyLists.size();

		for (int i = 0; i < vertices; i++) {
			if (visitedGray.contains(i) || visitedBlack.contains(i))
				continue;
			else {
				visitedGray.add(i);
				if (!dfsVisit(i, adjacencyLists, visitedGray, visitedBlack))
					return false;
			}
		}
		return true;
	}

	private static boolean dfsVisit(int source, Map<Integer, Set<Integer>> adjacencyLists, Set<Integer> visitedGray,
			Set<Integer> visitedBlack) {
		Set<Integer> adjacencySet = adjacencyLists.get(source);
		Iterator<Integer> iterator = adjacencySet.iterator();
		while (iterator.hasNext()) {
			int vertex = iterator.next();
			if (visitedGray.contains(vertex))
				return false;
			visitedGray.add(vertex);
			boolean isAcyclic = dfsVisit(vertex, adjacencyLists, visitedGray, visitedBlack);
			if (!isAcyclic)
				return isAcyclic;
		}
		visitedBlack.add(source);
		visitedGray.remove(source);
		return true;
	}

	public static void main(String[] args) {
		System.out.println(canFinish(2, new int[][] { { 1, 0 }, { 0, 1 } }));
		System.out.println(canFinish(2, new int[][] { { 0, 1 } }));
		System.out.println(canFinish(3, new int[][] { { 2, 0 }, { 2, 1 } }));
		System.out.println(canFinish(4, new int[][] { { 3, 0 }, { 0, 1 } }));
		System.out.println(canFinish(3, new int[][] { { 1, 0 }, { 2, 0 }, { 0, 2 } }));
		System.out.println(canFinish(8, new int[][] { { 1, 0 }, { 2, 6 }, { 1, 7 }, { 6, 4 }, { 7, 0 }, { 0, 5 } }));
	}
}
