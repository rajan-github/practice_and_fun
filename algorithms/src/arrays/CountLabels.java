package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountLabels {
	public int[] countSubTrees(int n, int[][] edges, String labels) {
		Map<Integer, List<Integer>> tree = new HashMap<>();
		int[] parent = new int[n];

		for (int i = 0; i < n; i++) {
			tree.put(i, new ArrayList<>());
			parent[i] = -1;
		}

		for (int[] edge : edges) {
			if (edge[0] != 0) {
				if (parent[edge[0]] == -1) {
					parent[edge[0]] = edge[1];
					tree.get(edge[1]).add(edge[0]);
				} else {
					tree.get(edge[0]).add(edge[1]);
					parent[edge[1]] = edge[0];
				}
			} else {
				tree.get(0).add(edge[1]);
				parent[edge[1]] = 0;
			}

		}

		Map<Integer, Integer> sameLabelChildCount = new HashMap<>();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			int count = countSimilarChildren(i, tree, labels, labels.charAt(i));
			sameLabelChildCount.put(i, count);
		}
		for (Map.Entry<Integer, Integer> entry : sameLabelChildCount.entrySet())
			array[entry.getKey()] = entry.getValue();
		return array;
	}

	private int countSimilarChildren(int source, Map<Integer, List<Integer>> tree, String labels, char parentLabel) {
		List<Integer> children = tree.get(source);
		if (children.isEmpty())
			return labels.charAt(source) == parentLabel ? 1 : 0;
		else {
			int count = 0;
			for (Integer child : children) {
				int similarChildren = countSimilarChildren(child, tree, labels, parentLabel);
				count += similarChildren;
			}
			if (parentLabel == labels.charAt(source))
				count += 1;
			return count;
		}
	}

	public static void main(String[] args) {
		System.out.println(Arrays.toString(new CountLabels().countSubTrees(6,
				new int[][] { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 3, 4 }, { 4, 5 } }, "cbabaa")));

		System.out.println(Arrays
				.toString(new CountLabels().countSubTrees(4, new int[][] { { 0, 2 }, { 0, 3 }, { 1, 2 } }, "aeed")));
	}

}
