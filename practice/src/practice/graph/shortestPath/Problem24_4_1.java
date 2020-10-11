package practice.graph.shortestPath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem24_4_1 {
	public static boolean differenceConstrainstsSolution(int vertices, double[][] edges) {

		// assuming input is correct.
		List<double[]> edgeList = new ArrayList<>();
		for (int i = 1; i <= vertices; i++)
			edgeList.add(new double[] { 0, i, 0 });
		for (double[] edge : edges)
			edgeList.add(edge);

		// vertex weights;
		double[] solution = new double[vertices + 1];

		for (int i = 0; i <= vertices; i++) {
			for (double[] edge : edgeList) {
				int x = (int) edge[0], y = (int) edge[1];
				if (solution[y] > solution[x] + edge[2])
					solution[y] = solution[x] + edge[2];
			}
		}

		// check for the negative weight cycle.
		for (double[] edge : edgeList) {
			int x = (int) edge[0], y = (int) edge[1];
			if (solution[y] > solution[x] + edge[2])
				return false;
		}

		System.out.println(Arrays.toString(solution));
		return true;
	}

	public static void main(String[] args) {
		double[][] edges = new double[][] { { 2, 1, 0 }, { 5, 1, -1 }, { 5, 2, 1 }, { 1, 3, 5 }, { 1, 4, 4 },
				{ 3, 4, -1 }, { 3, 5, -3 }, { 4, 5, -3 } };

		System.out.println(differenceConstrainstsSolution(5, edges));
		System.out.println("-----system#2----------");

		edges = new double[][] { { 2, 1, 1 }, { 4, 1, -4 }, { 3, 2, 2 }, { 5, 2, 7 }, { 6, 2, 5 }, { 6, 3, 10 },
				{ 2, 4, 2 }, { 1, 5, -1 }, { 4, 5, 3 }, { 3, 6, -8 } };

		System.out.println(differenceConstrainstsSolution(6, edges));

		System.out.println("-----system#3----------");

		edges = new double[][] { { 2, 1, 4 }, { 5, 1, 5 }, { 4, 2, -6 }, { 2, 3, 1 }, { 1, 4, 3 }, { 3, 4, 5 },
				{ 5, 4, 10 }, { 3, 5, -4 }, { 4, 5, -8 } };

		System.out.println(differenceConstrainstsSolution(6, edges));

	}
}
