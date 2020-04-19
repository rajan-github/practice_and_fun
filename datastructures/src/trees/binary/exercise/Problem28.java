package trees.binary.exercise;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Given two trees, give an algorithm for checking whether they are mirrors of
 * each other.
 * 
 * @author rajan-c
 *
 */
public class Problem28 {
	public static boolean areMirrors(BinaryTreeNode<Integer> root) {
		if (root == null || (root.getLeft() == null && root.getRight() == null))
			return true;
		return areMirrors(root.getLeft(), root.getRight());
	}

	private static boolean areMirrors(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
		if (root1 == null && root2 == null)
			return true;
		else if (root1 == null || root2 == null)
			return false;
		return root1.getData() == root2.getData() && areMirrors(root1.getLeft(), root2.getRight())
				&& areMirrors(root1.getRight(), root2.getLeft());
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(4);
		tree.insert(3);
		Problem27.treeMirror(tree.getRoot());
		System.out.println(areMirrors(tree.getRoot()));
	}
}
