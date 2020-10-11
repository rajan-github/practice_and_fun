package graph.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;

/**
 * In a directed graph, we start at some node and every turn, walk along a
 * directed edge of the graph. If we reach a node that is terminal (that is, it
 * has no outgoing directed edges), we stop.
 * 
 * Now, say our starting node is eventually safe if and only if we must
 * eventually walk to a terminal node. More specifically, there exists a natural
 * number K so that for any choice of where to walk, we must have stopped at a
 * terminal node in less than K steps.
 * 
 * Which nodes are eventually safe? Return them as an array in sorted order.
 * 
 * The directed graph has N nodes with labels 0, 1, ..., N-1, where N is the
 * length of graph. The graph is given in the following form: graph[i] is a list
 * of labels j such that (i, j) is a directed edge of the graph.
 * 
 * @author rajan-c
 *
 */
public class EventualSafeStates {
	public List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> safeStates = new ArrayList<>();
		if (graph != null && graph.length > 0) {
			int vertices = graph.length;
			Set<Integer> rejected = new HashSet<>(), processed = new HashSet<>(), grayVertices = new HashSet<>(),
					blackVertices = new HashSet<>();
			Stack<Integer> stack = new Stack<>();
			for (int i = 0; i < vertices; i++) {
				if (!processed.contains(i)) {
					processed.add(i);
					grayVertices.add(i);
					stack.push(i);
					dfs(graph, processed, rejected, stack, i, grayVertices, blackVertices);
				}
			}
			for (int i = 0; i < vertices; i++) {
				if (!rejected.contains(i))
					safeStates.add(i);
			}
		}
		return safeStates;
	}

	private static void dfs(int[][] graph, Set<Integer> processed, Set<Integer> rejected, Stack<Integer> stack,
			int source, Set<Integer> grayVertices, Set<Integer> blackVertices) {
		int[] adjacents = graph[source];
		for (int adjacent : adjacents) {
			if (grayVertices.contains(adjacent) || rejected.contains(adjacent)) {
				// found a cycle.
				while (!stack.isEmpty())
					rejected.add(stack.pop());
			} else if (!blackVertices.contains(adjacent)) {
				grayVertices.add(adjacent);
				processed.add(adjacent);
				stack.push(adjacent);
				dfs(graph, processed, rejected, stack, adjacent, grayVertices, blackVertices);
			}
		}
		if (!stack.isEmpty())
			stack.pop();
		grayVertices.remove(source);
		blackVertices.add(source);
	}
}
