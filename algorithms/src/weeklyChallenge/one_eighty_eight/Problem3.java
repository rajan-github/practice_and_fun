package weeklyChallenge.one_eighty_eight;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem3 {
	public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
//		TreeNode root = getTree(edges);
		return 0;
	}

	public TreeNode getTree(int[][] edges) {
		Map<Integer, TreeNode> map = new HashMap<>();
		for (int i = 0; i < edges.length; i++) {
			if (map.containsKey(edges[i][0])) {
				TreeNode node = map.get(edges[i][0]);
				if (node.left == null)
					node.left = new TreeNode(edges[i][1]);
				else
					node.right = new TreeNode(edges[i][1]);
			} else {
				TreeNode node = new TreeNode(edges[i][0]);
				map.put(edges[i][0], node);
				node.left = new TreeNode(edges[i][1]);
				if (edges[i][0] > 0) {
//					TreeNode parent = map.get(edges[i][0]);
				}
			}
		}
		return map.get(0);
	}

	public static void main(String[] args) {
		new Problem3().minTime(7, new int[][] { { 0, 1 }, { 0, 2 }, { 1, 4 }, { 1, 5 }, { 2, 3 }, { 2, 6 } },
				Arrays.asList(new Boolean[] { false, false, true, false, true, true, false }));
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int _val) {
			this.val = _val;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getEnclosingInstance().hashCode();
			result = prime * result + val;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			TreeNode other = (TreeNode) obj;
			if (!getEnclosingInstance().equals(other.getEnclosingInstance()))
				return false;
			if (val != other.val)
				return false;
			return true;
		}

		private Problem3 getEnclosingInstance() {
			return Problem3.this;
		}

	}
}
