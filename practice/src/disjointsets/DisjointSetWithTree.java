package disjointsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This implementation is with tree.
 * 
 * @author rajan-c
 *
 */
public class DisjointSetWithTree {
	private Map<Integer, TreeNode> valueToNodeMap = new HashMap<>();

	public TreeNode makeSet(int x) {
		if (valueToNodeMap.containsKey(x))
			valueToNodeMap.get(x);
		TreeNode node = new TreeNode(x);
		valueToNodeMap.put(x, node);
		node.parent = node;
		return node;
	}

	public TreeNode findSet(int x) {
		TreeNode node = valueToNodeMap.get(x);
		if (node.parent == node)
			return node;
		node.parent = findSet(node.parent.data);
		return node.parent;
	}

	public TreeNode union(int x, int y) {
		TreeNode nodex = findSet(x);
		TreeNode nodey = findSet(y);
		if (nodex != nodey)
			return link(nodex, nodey);
		return nodex;
	}

	private TreeNode link(TreeNode nodex, TreeNode nodey) {
		if (nodex.rank > nodey.rank) {
			nodey.parent = nodex;
			return nodey;
		} else if (nodex.rank < nodey.rank) {
			nodex.parent = nodey;
			return nodex;
		} else {
			nodex.parent = nodey;
			nodey.rank += 1;
			return nodey;
		}
	}

	public static void main(String[] args) {
		DisjointSetWithTree ds = new DisjointSetWithTree();
		List<TreeNode> set = new ArrayList<>();

		for (int i = 1; i <= 16; i++)
			set.add(ds.makeSet(i));

		List<TreeNode> set1 = new ArrayList<>();

		for (int i = 1; i <= 16; i += 2)
			set1.add(ds.union(i, i + 1));

		System.out.println(set1.size());

		for (TreeNode item : set1)
			System.out.println(item);

	}
}
