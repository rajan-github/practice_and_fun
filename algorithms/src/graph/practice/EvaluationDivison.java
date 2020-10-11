package graph.practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import auxiliaryMethods.CommonMethods;

/**
 * Equations are given in the format A / B = k, where A and B are variables
 * represented as strings, and k is a real number (floating point number). Given
 * some queries, return the answers. If the answer does not exist, return -1.0.
 * 
 * Example: Given a / b = 2.0, b / c = 3.0. queries are: a / c = ?, b / a = ?, a
 * / e = ?, a / a = ?, x / x = ? . return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 * 
 * The input is: vector<pair<string, string>> equations, vector<double>& values,
 * vector<pair<string, string>> queries , where equations.size() ==
 * values.size(), and the values are positive. This represents the equations.
 * Return vector<double>.
 * 
 * Note: The input is always valid. You may assume that evaluating the queries
 * will result in no division by zero and there is no contradiction.
 * 
 * @author rajan-c
 *
 */
public class EvaluationDivison {
	public static double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		Set<String> nodeSet = new HashSet<>();
		for (List<String> edge : equations) {
			String source = edge.get(0), destination = edge.get(1);
			nodeSet.add(source);
			nodeSet.add(destination);
		}

		Map<String, Integer> nameToIndexMap = new HashMap<>();
		int index = 0;
		for (String node : nodeSet)
			nameToIndexMap.put(node, index++);

		double[][] adjacencyMatrix = new double[nodeSet.size()][nodeSet.size()];
		int size = adjacencyMatrix.length;
		for (int row = 0; row < size; row++) {
			for (int col = 0; col < size; col++)
				if (row == col)
					adjacencyMatrix[row][col] = 1;
				else
					adjacencyMatrix[row][col] = Integer.MAX_VALUE;
		}
		index = 0;
		for (List<String> edge : equations) {
			int source = nameToIndexMap.get(edge.get(0)), destination = nameToIndexMap.get(edge.get(1));
			adjacencyMatrix[source][destination] = values[index++];
			adjacencyMatrix[destination][source] = 1 / adjacencyMatrix[source][destination];
		}

		double[] equationResults = new double[queries.size()];
		computePath(adjacencyMatrix);
		index = 0;
		for (List<String> query : queries) {
			Integer source = nameToIndexMap.get(query.get(0)), destination = nameToIndexMap.get(query.get(1));
			if (source == null || destination == null)
				equationResults[index++] = -1;
			else {
				double pathValue = adjacencyMatrix[source][destination];
				if (pathValue < Integer.MAX_VALUE)
					equationResults[index++] = pathValue;
				else if (adjacencyMatrix[destination][source] < Integer.MAX_VALUE)
					equationResults[index++] = 1 / (adjacencyMatrix[destination][source]);
				else
					equationResults[index++] = -1;
			}
		}
		return equationResults;
	}

	private static void computePath(double[][] graph) {
		for (int k = 0; k < graph.length; k++) {
			for (int row = 0; row < graph.length; row++) {
				for (int col = 0; col < graph.length; col++) {
					if (row != col && graph[row][k] < Integer.MAX_VALUE && graph[k][col] < Integer.MAX_VALUE)
						graph[row][col] = Math.min(graph[row][col], graph[row][k] * graph[k][col]);
				}
			}

		}
	}

	public static void main(String[] args) {
//		List<String> edge1 = new ArrayList<>();
//		edge1.add("a");
//		edge1.add("e");
//
//		List<String> edge2 = new ArrayList<>();
//		edge2.add("b");
//		edge2.add("e");
//
//		List<List<String>> equations = new ArrayList<>();
//		equations.add(edge1);
//		equations.add(edge2);
//
//		List<String> q1 = new ArrayList<>();
//		q1.add("a");
//		q1.add("b");
//
//		List<String> q2 = new ArrayList<>();
//		q2.add("e");
//		q2.add("e");
//
//		List<String> q3 = new ArrayList<>();
//		q3.add("x");
//		q3.add("x");
//		List<List<String>> queries = new ArrayList<>();
//		queries.add(q1);
//		queries.add(q2);
//		queries.add(q3);

//		List<String> edge1 = new ArrayList<>();
//		edge1.add("a");
//		edge1.add("b");
//
//		List<String> edge2 = new ArrayList<>();
//		edge2.add("c");
//		edge2.add("d");
//
//		List<List<String>> equations = new ArrayList<>();
//		equations.add(edge1);
//		equations.add(edge2);
//
//		List<String> q1 = new ArrayList<>();
//		q1.add("a");
//		q1.add("c");
//
//		List<String> q2 = new ArrayList<>();
//		q2.add("b");
//		q2.add("d");
//
//		List<String> q3 = new ArrayList<>();
//		q3.add("b");
//		q3.add("a");
//
//		List<String> q4 = new ArrayList<>();
//		q4.add("d");
//		q4.add("c");
//		List<List<String>> queries = new ArrayList<>();
//		queries.add(q1);
//		queries.add(q2);
//		queries.add(q3);
//		queries.add(q4);

		List<String> edge1 = new ArrayList<>();
		edge1.add("a");
		edge1.add("b");

		List<String> edge2 = new ArrayList<>();
		edge2.add("c");
		edge2.add("d");

		List<String> edge3 = new ArrayList<>();
		edge3.add("e");
		edge3.add("f");

		List<String> edge4 = new ArrayList<>();
		edge4.add("g");
		edge4.add("h");

		List<List<String>> equations = new ArrayList<>();
		equations.add(edge1);
		equations.add(edge2);
		equations.add(edge3);
		equations.add(edge4);

		List<String> q1 = new ArrayList<>();
		q1.add("a");
		q1.add("c");

		List<String> q2 = new ArrayList<>();
		q2.add("d");
		q2.add("f");

		List<String> q3 = new ArrayList<>();
		q3.add("h");
		q3.add("e");

		List<String> q4 = new ArrayList<>();
		q4.add("d");
		q4.add("h");

		List<String> q5 = new ArrayList<>();
		q5.add("g");
		q5.add("f");

		List<String> q6 = new ArrayList<>();
		q6.add("c");
		q6.add("g");
		List<List<String>> queries = new ArrayList<>();
		queries.add(q1);
		queries.add(q2);
		queries.add(q3);
		queries.add(q4);
		queries.add(q5);
		queries.add(q6);

		double[] result = calcEquation(equations, new double[] { 4.5, 2.3, 8.9, 0.44 }, queries);

		CommonMethods.display(result);

	}
}
