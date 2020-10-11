package disjointset.tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * This is optimal implementation of disjoint set data structures. Running time
 * of n, operations O(nlg(n)).
 * 
 * @author rajan-c
 *
 * @param <T>
 */
public class SetOperations<T extends Comparable<T>> {
	private Map<T, TreeNode<T>> valueNodeMap = new HashMap<>();
	private Set<T> valueSet = new HashSet<>();

	public TreeNode<T> makeset(T data) {
		if (data == null)
			return null;
		if (valueSet.contains(data))
			throw new IllegalArgumentException("Data already exists: " + data);
		TreeNode<T> node = new TreeNode<>(data);
		node.setParent(node);
		valueNodeMap.put(data, node);
		valueSet.add(data);
		return node;
	}

	public TreeNode<T> findset(TreeNode<T> node) {
		if (node == null)
			return null;
		else if (node.getParent() == node)
			return node;
		node.setParent(findset(node.getParent()));
		return node.getParent();
	}

	public TreeNode<T> union(TreeNode<T> set1, TreeNode<T> set2) {
		if (set1 == null)
			return set2;
		else if (set2 == null)
			return set1;
		else
			return link(findset(set1), findset(set2));
	}

	private TreeNode<T> link(TreeNode<T> root1, TreeNode<T> root2) {
		if (root1.getRank() > root2.getRank()) {
			root2.setParent(root1.getParent());
			return root1;
		}
		root2.setParent(root1.getParent());
		if (root2.getRank() == root1.getRank())
			root1.setRank(root1.getRank() + 1);
		return root1;
	}

	public TreeNode<T> getNode(T data) {
		return valueNodeMap.get(data);
	}

	public static void main(String[] args) {
		SetOperations<Integer> setOperations = new SetOperations<>();
		Set<TreeNode<Integer>> set = new HashSet<>();
		for (int i = 1; i <= 16; i++)
			set.add(setOperations.makeset(i));
		int i = 1;
		while (i < 16) {
			TreeNode<Integer> tree1 = setOperations.getNode(i);
			set.remove(tree1);
			TreeNode<Integer> tree2 = setOperations.getNode(i + 1);
			set.remove(tree2);
			set.add(setOperations.union(tree1, tree2));
			i += 2;
		}

		i = 1;
		while (i < 15) {
			TreeNode<Integer> tree1 = setOperations.getNode(i);
			set.remove(tree1);
			TreeNode<Integer> tree2 = setOperations.getNode(i + 2);
			set.remove(tree2);
			set.add(setOperations.union(tree1, tree2));
			i += 4;
		}

		for (i = 1; i <= 16; i++) {
			System.out.println(setOperations.findset(setOperations.getNode(i)).getData());
		}
	}

}
