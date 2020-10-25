package disjointsets.problems;

import java.util.ArrayList;
import java.util.List;

import disjointsets.DisjointSetWithTree;
import disjointsets.TreeNode;

public class OfflineMinimum {
	public static List<Integer> offlineMinimum(char[] input, int m, int n) {
		DisjointSetWithTree disjointSet = new DisjointSetWithTree();
		List<TreeNode> sets = new ArrayList<>();

		for (int i = 0; i < input.length;) {
			int j = i + 1;
			while (j < input.length && input[j] != 'e')
				j++;

			TreeNode set = disjointSet.makeSet(input[i]);
			for (int index = i + 1; index < j; index++) {
				disjointSet.makeSet(input[index]);
				set = disjointSet.union(input[index - 1], input[index]);
			}
			sets.add(set);
		}

		List<Integer> minimum = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			int k = -1;
			for (k = 0; k < sets.size(); k++) {
				if (sets.get(k) == disjointSet.findSet(i))
					break;
			}

			if (k != m + 1) {
				minimum.add(i);
			}
			
			
		}

		return minimum;
	}

	public static void main(String[] args) {
//		char input[] = { 4, 8, 'e', 3, 'e', 9, 2, 6, 'e', 'e', 'e', 1, 7, 'e', 5 };

	}
}
