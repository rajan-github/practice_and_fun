package graph.practice;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

/**
 * The file contains the adjacency list representation of a simple undirected
 * graph. There are 200 vertices labeled 1 to 200. The first column in the file
 * represents the vertex label, and the particular row (other entries except the
 * first column) tells all the vertices that the vertex is adjacent to. So for
 * example, the 6^{th}6 th row looks like : "6 155 56 52 120 ......". This just
 * means that the vertex with label 6 is adjacent to (i.e., shares an edge with)
 * the vertices with labels 155,56,52,120,......,etc Your task is to code up and
 * run the randomized contraction algorithm for the min cut problem and use it
 * on the above graph to compute the min cut. (HINT: Note that you'll have to
 * figure out an implementation of edge contractions. Initially, you might want
 * to do this naively, creating a new graph from the old every time there's an
 * edge contraction. But you should also think about more efficient
 * implementations.) (WARNING: As per the video lectures, please make sure to
 * run the algorithm many times with different random seeds, and remember the
 * smallest cut that you ever find.) Write your numeric answer in the space
 * provided. So e.g., if your answer is 5, just type 5 in the space provided.
 * 
 * @author rajan-c
 *
 */
public class MinCutByContraction {
	public long minCut(Set<String> vertices, List<String[]> edges) {
		while (vertices.size() > 2) {
			int randomIndex = ThreadLocalRandom.current().nextInt(0, edges.size());
			String[] randomEdge = edges.get(randomIndex);
			String newVertex = randomEdge[0] + "+" + randomEdge[1];
			List<String[]> newEdgeSet = new ArrayList<>();
			for (String[] edge : edges) {
				if (edge == randomEdge || (edge[0].equals(randomEdge[0]) && edge[1].equals(randomEdge[1]))
						|| (edge[0].equals(randomEdge[1]) && edge[1].equals(randomEdge[0])))
					continue;

				if (edge[0].equals(randomEdge[0]) || edge[0].equals(randomEdge[1]))
					edge[0] = newVertex;
				if (edge[1].equals(randomEdge[1]) || edge[1].equals(randomEdge[0]))
					edge[1] = newVertex;
				newEdgeSet.add(edge);
			}
			edges = newEdgeSet;
			vertices.remove(randomEdge[0]);
			vertices.remove(randomEdge[1]);
			vertices.add(newVertex);
		}
		return edges.size() / 2;
	}

	private Set<String> cloneSet(Set<String> vertices) {
		Set<String> clone = new HashSet<>();
		for (String v : vertices)
			clone.add(new String(v));
		return clone;
	}

	private List<String[]> cloneEdges(List<String[]> edges) {
		List<String[]> clone = new ArrayList<>();
		for (String[] edge : edges)
			clone.add(new String[] { new String(edge[0]), new String(edge[1]) });
		return clone;
	}

	public static void main(String[] args) throws IOException {
		MinCutByContraction minCut = new MinCutByContraction();
		Set<String> vertices = new HashSet<>();
		List<String[]> edges = new ArrayList<>();
		Path path = Paths.get(Paths.get("").toAbsolutePath() + "\\src\\graph\\practice\\kargarMincut.txt");
		List<String> lines = Files.readAllLines(path);
		for (String line : lines) {
			String[] nodes = line.split("\\t");
			int i = 1;
			vertices.add(nodes[0]);
			for (; i < nodes.length; i++) {
				if (nodes[i].length() > 0)
					edges.add(new String[] { nodes[0], nodes[i] });
			}
		}
		long cutSize = Integer.MAX_VALUE;
		for (int i = 0; i < Math.pow(vertices.size(), 1); i++)
			cutSize = Math.min(cutSize, minCut.minCut(minCut.cloneSet(vertices), minCut.cloneEdges(edges)));

		System.out.println("minCut is: " + cutSize);
	}
}
