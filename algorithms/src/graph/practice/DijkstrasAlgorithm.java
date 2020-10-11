package graph.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class DijkstrasAlgorithm {
	private int vertices;

	public DijkstrasAlgorithm(int vertices) {
		this.vertices = vertices;
	}

	public String shortestPath() throws IOException {
		int[] weights = new int[vertices + 1];
		Set<Integer> updatedNodes = new HashSet<>();
		Map<Integer, List<Vertex>> graph = loadGraph();
		initialize(weights);
		while (updatedNodes.size() < vertices) {
			int minNode = findMin(weights, updatedNodes);
			updatedNodes.add(minNode);
			List<Vertex> adjacents = graph.getOrDefault(minNode, new ArrayList<>());
			for (Vertex adjacent : adjacents) {
				int y = adjacent.y;
				if (weights[y] > weights[minNode] + adjacent.weight)
					weights[y] = weights[minNode] + adjacent.weight;
			}
		}
		StringBuilder ans = new StringBuilder();
		int[] desiredVertices = new int[] { 7, 37, 59, 82, 99, 115, 133, 165, 188, 197 };
		for (int i = 0; i < desiredVertices.length; i++) {
			int item = desiredVertices[i];
			ans.append(weights[item]);
			if (i < desiredVertices.length - 1)
				ans.append(",");
		}

		return ans.toString();
	}

	private int findMin(int[] weights, Set<Integer> updatedNodes) {
		int min = -1;
		for (int i = 1; i < weights.length; i++)
			if (!updatedNodes.contains(i)) {
				min = i;
				break;
			}

		for (int i = 1; i < weights.length; i++) {
			if (!updatedNodes.contains(i) && weights[i] < weights[min])
				min = i;
		}
		return min;
	}

	private void initialize(int[] weights) {
		for (int i = 2; i <= vertices; i++)
			weights[i] = 1000000;
		weights[1] = 0;
	}

	private Map<Integer, List<Vertex>> loadGraph() throws IOException {
		Path path = Paths.get("").toAbsolutePath();
		path = Paths.get(path + "\\src\\graph\\practice\\dijkstraData.txt");
		List<String> lines = Files.readAllLines(path);
		Map<Integer, List<Vertex>> graph = new HashMap<>();
		for (String line : lines) {
			String[] vertexData = line.split("\t");
			int source = Integer.parseInt(vertexData[0]);
			for (int i = 1; i < vertexData.length; i++) {
				String item = vertexData[i];
				String[] vertexWithWeight = item.split(",");
				Vertex vertex = new Vertex(Integer.parseInt(vertexWithWeight[0]),
						Integer.parseInt(vertexWithWeight[1]));
				graph.putIfAbsent(source, new ArrayList<>());
				graph.get(source).add(vertex);
			}
		}
		return graph;
	}

	public static void main(String[] args) throws IOException {
		DijkstrasAlgorithm algorithm = new DijkstrasAlgorithm(200);
		System.out.println(algorithm.shortestPath());
	}
}

class Vertex {
	int y;
	int weight;

	public Vertex(int y, int weight) {
		this.y = y;
		this.weight = weight;
	}
}
