package graph.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Stack;

public class StronglyConnectedComponents {
	long time = 0;

	/**
	 * Return five largest scc in the graph.
	 * 
	 * @param vertices
	 * @param graph
	 * @return
	 */
	public int[] stronglyConnectedComponents(int vertices, Map<Integer, List<Integer>> graph) {
		int[] color = new int[vertices];
		long[] finishTimes = new long[vertices];
		for (int i = 0; i < vertices; i++) {
			if (color[i] == 0) {
				dfs(i, graph, color, finishTimes);
			}
		}
		Map<Integer, List<Integer>> transposeGraph = transpose(graph);
		PriorityQueue<long[]> queue = new PriorityQueue<>((long[] x, long[] y) -> Long.compare(y[1], x[1]));
		for (int index = 0; index < finishTimes.length; index++)
			queue.add(new long[] { index, finishTimes[index] });

		int[] colorOfTranspose = new int[vertices];

		PriorityQueue<Integer> componentSizes = new PriorityQueue<Integer>(
				(Integer x, Integer y) -> Integer.compare(y, x));
		while (!queue.isEmpty()) {
			long[] node = queue.remove();
			if (colorOfTranspose[(int) node[0]] == 0) {
				int size = dfs((int) node[0], transposeGraph, colorOfTranspose, new long[vertices]);
				componentSizes.add(size);
			}
		}
		int[] fiveLargestComponents = new int[5];
		int i = 0;
		while (!componentSizes.isEmpty() && i < 5)
			fiveLargestComponents[i++] = componentSizes.remove();
		return fiveLargestComponents;
	}

	private Map<Integer, List<Integer>> transpose(Map<Integer, List<Integer>> graph) {
		Map<Integer, List<Integer>> transpose = new HashMap<>();
		for (Map.Entry<Integer, List<Integer>> entry : graph.entrySet()) {
			int v1 = entry.getKey();
			List<Integer> adjacents = entry.getValue();
			for (int adjacent : adjacents) {
				transpose.putIfAbsent(adjacent, new ArrayList<>());
				transpose.get(adjacent).add(v1);
			}
		}
		return transpose;
	}

	/**
	 * TODO: This algorithm has issues: it doesn't assign correct finish times and
	 * thus algorithm for scc doesn't work correctly.
	 * 
	 * @param source
	 * @param graph
	 * @param color
	 * @param finishTime
	 * @return
	 */
	public int dfsIterative(int source, Map<Integer, List<Integer>> graph, int[] color, long[] finishTime) {
		Stack<Integer> stack = new Stack<>();
		stack.push(source);
		color[source] = 1;
		Stack<Integer> dfsOrder = new Stack<>();
		while (!stack.isEmpty()) {
			int node = stack.peek();
			List<Integer> adjacencyList = graph.getOrDefault(node, new ArrayList<>());
			for (Integer adjacent : adjacencyList)
				if (color[adjacent] == 0) {
					stack.push(adjacent);
					color[adjacent] = 1;
				}
			if (node == stack.peek()) {
				int finishedNode = stack.pop();
				time += 1;
				finishTime[finishedNode] = time;
				color[finishedNode] = 2;
				dfsOrder.push(finishedNode);
			}
		}
		return dfsOrder.size();
	}

	private int dfs(int source, Map<Integer, List<Integer>> graph, int[] color, long[] finishTime) {
		color[source] = 1;
		List<Integer> adjacentList = graph.getOrDefault(source, new ArrayList<>());
		int count = 1;
		for (int adjacent : adjacentList) {
			if (color[adjacent] == 0) {
				color[adjacent] = 1;
				count += dfs(adjacent, graph, color, finishTime);
			}
		}
		time += 1;
		finishTime[source] = time;
		color[source] = 2;
		return count;
	}

	private int[] computeStronglyConnectedComponents(int n) throws IOException {
		Path path = Paths.get(Paths.get("").toAbsolutePath() + "\\src\\graph\\practice\\scc.txt");
		List<String> lines = Files.readAllLines(path);
		Map<Integer, List<Integer>> graph = new HashMap<>();
		for (String line : lines) {
			String[] nodes = line.split(" ");
			graph.putIfAbsent(Integer.parseInt(nodes[0]) - 1, new ArrayList<>());
			graph.get(Integer.parseInt(nodes[0]) - 1).add(Integer.parseInt(nodes[1]) - 1);
		}
		return stronglyConnectedComponents(n, graph);
	}

	public static void main(String[] args) throws IOException {
		System.out.println("running dfs.");
		StronglyConnectedComponents scc = new StronglyConnectedComponents();
		System.out.println(Arrays.toString(scc.computeStronglyConnectedComponents(875714)));
//		System.out.println(Arrays.toString(scc.computeStronglyConnectedComponents(8)));
	}

}
