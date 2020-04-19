package trees.binary.exercise;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Given two binary trees, return true if they are structurally identical. If
 * both trees are NULL then return true. • If both trees are not NULL, then
 * recursively check left and right subtree structures.
 * 
 * @author rajan-c
 *
 */
public class Exercise19 {

	public static boolean compare(BinaryTreeNode<Integer> root1, BinaryTreeNode<Integer> root2) {
		if (root1 == null && root2 == null)
			return true;
		else if ((root1 == null && root2 != null) || (root1 != null && root2 == null))
			return false;
		else if (root1.getData().equals(root2.getData()))
			return compare(root1.getLeft(), root2.getLeft()) && compare(root1.getRight(), root2.getRight());
		else
			return false;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(2);
		tree.insert(3);
		tree.insert(4);
		tree.insert(5);
		tree.insert(6);
		tree.insert(7);
//		tree.insert(8);
//		tree.insert(9);

		BinaryTree<Integer> tree1 = new BinaryTree<>();
		tree1.insert(1);
		tree1.insert(2);
		tree1.insert(3);
		tree1.insert(4);
		tree1.insert(5);
		tree1.insert(6);
		tree1.insert(7);
//		tree1.insert(8);
//		tree1.insert(9);

		System.out.println(compare(tree.getRoot(), tree1.getRoot()));
		System.out.println(compare(null, null));

	}
}
