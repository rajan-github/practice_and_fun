package graph.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

import auxiliaryMethods.CommonMethods;

/**
 * There are a total of n courses you have to take, labeled from 0 to n-1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * @author rajan-c
 *
 */
public class CourseSchedule2 {
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
		Map<Integer, Set<Integer>> graph = new HashMap<>();
		int[] courseOrder = new int[numCourses];

		for (int i = 0; i < numCourses; i++)
			graph.put(i, new HashSet<>());

		for (int[] prerequisite : prerequisites)
			graph.get(prerequisite[1]).add(prerequisite[0]);

		Stack<Integer> stack = new Stack<>();
		Set<Integer> grayNodes = new HashSet<>(), blackNodes = new HashSet<>();
		for (int i = 0; i < numCourses; i++) {
			if (!grayNodes.contains(i) && !blackNodes.contains(i)) {
				grayNodes.add(i);
				if (!dfs(i, graph, stack, grayNodes, blackNodes))
					return new int[] {};
			}
		}

		int index = 0;
		while (!stack.isEmpty())
			courseOrder[index++] = stack.pop();
		return courseOrder;
	}

	private static boolean dfs(int source, Map<Integer, Set<Integer>> graph, Stack<Integer> stack,
			Set<Integer> grayNodes, Set<Integer> blackNodes) {
		Set<Integer> adjacencyList = graph.get(source);
		Iterator<Integer> iterator = adjacencyList.iterator();
		while (iterator.hasNext()) {
			int node = iterator.next();
			if (grayNodes.contains(node))
				return false;
			else if (!blackNodes.contains(node)) {
				grayNodes.add(node);
				boolean result = dfs(node, graph, stack, grayNodes, blackNodes);
				if (!result)
					return false;
			}
		}
		blackNodes.add(source);
		stack.add(source);
		grayNodes.remove(source);
		return true;
	}

	public static void main(String[] args) {

		int[] traversal = findOrder(2, new int[][] { { 1, 0 } });
		CommonMethods.display(traversal);
		traversal = findOrder(4, new int[][] { { 1, 0 }, { 2, 0 }, { 3, 1 }, { 3, 2 } });
		CommonMethods.display(traversal);
		traversal = findOrder(3, new int[][] { { 1, 0 }, { 2, 1 } });
		CommonMethods.display(traversal);

		traversal = findOrder(3, new int[][] { { 1, 0 }, { 2, 0 } });
		CommonMethods.display(traversal);

		traversal = findOrder(3, new int[][] { { 1, 0 }, { 2, 1 }, { 0, 2 } });
		CommonMethods.display(traversal);
	}
}
