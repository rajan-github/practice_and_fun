package trees.binary.exercise;

import java.util.LinkedList;
import java.util.Queue;

import trees.binary.examples.BinaryTree;
import trees.binary.examples.BinaryTreeNode;

/**
 * Give an algorithm for deleting an element (assuming data is given) from
 * binary tree.
 * 
 * @author rajan-c
 *
 */
public class Exercise15 {

	public static void deleteItem(BinaryTree<Integer> tree, int item) {
		BinaryTreeNode<Integer> node;
		if (tree != null && tree.getRoot().getLeft() == null && tree.getRoot().getRight() == null
				&& tree.getRoot().getData() == item)
			tree.setRoot(null);
		else if (tree != null && ((node = tree.search(item)) != null)) {
			BinaryTreeNode<Integer> deepestNode = deepestNode(tree.getRoot());
			BinaryTreeNode<Integer> lastNodeParent = findParent(tree.getRoot(), deepestNode);
			if (lastNodeParent != null && lastNodeParent.getLeft() == deepestNode)
				lastNodeParent.setLeft(null);
			else if (lastNodeParent != null)
				lastNodeParent.setRight(null);
			if (node == tree.getRoot()) {
				deepestNode.setLeft(tree.getRoot().getLeft());
				deepestNode.setRight(tree.getRoot().getRight());
				tree.setRoot(deepestNode);
			} else {
				BinaryTreeNode<Integer> nodeTobeDeleted = tree.search(item);
				if (nodeTobeDeleted != null) {
					BinaryTreeNode<Integer> parentOfDeletable = findParent(tree.getRoot(), nodeTobeDeleted);
					deepestNode.setLeft(nodeTobeDeleted.getLeft());
					deepestNode.setRight(nodeTobeDeleted.getRight());

					if (parentOfDeletable.getLeft() == nodeTobeDeleted)
						parentOfDeletable.setLeft(deepestNode);
					else
						parentOfDeletable.setRight(deepestNode);
				}
			}
		}
	}

	private static BinaryTreeNode<Integer> deepestNode(BinaryTreeNode<Integer> root) {
		if (root != null && (root.getLeft() != null || root.getRight() != null)) {
			BinaryTreeNode<Integer> deepestNode = null;
			Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				deepestNode = queue.remove();
				if (deepestNode.getLeft() != null)
					queue.add(deepestNode.getLeft());
				if (deepestNode.getRight() != null)
					queue.add(deepestNode.getRight());
			}
			return deepestNode;
		} else
			return root;
	}

	private static BinaryTreeNode<Integer> findParent(BinaryTreeNode<Integer> root, BinaryTreeNode<Integer> node) {
		if (root.equals(node))
			return null;
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		BinaryTreeNode<Integer> parent = null;
		while (!queue.isEmpty()) {
			BinaryTreeNode<Integer> temp = queue.remove();
			if (temp.getLeft() == node || temp.getRight() == node) {
				parent = temp;
				break;
			}
			if (temp.getLeft() != null)
				queue.add(temp.getLeft());
			if (temp.getRight() != null)
				queue.add(temp.getRight());
		}
		return parent;
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

		deleteItem(tree, 2);
//		tree.preOrder(tree.getRoot());

		deleteItem(tree, 4);
//		tree.preOrder(tree.getRoot());

//		deleteItem(tree, 3);
//		deleteItem(tree, 7);
//		deleteItem(tree, 6);
//		deleteItem(tree, 5);
//		deleteItem(tree, 1);
		tree.preOrder(tree.getRoot());
	}
}
