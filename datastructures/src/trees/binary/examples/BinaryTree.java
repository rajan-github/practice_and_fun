package trees.binary.examples;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T extends Comparable<T>> {
	private BinaryTreeNode<T> root = null;

	public BinaryTree(BinaryTreeNode<T> root) {
		super();
		this.root = root;
	}

	public BinaryTree() {
		super();
	}

	public BinaryTreeNode<T> getRoot() {
		return this.root;
	}

	public void setRoot(BinaryTreeNode<T> newRoot) {
		this.root = newRoot;
	}

	public void insert(T data) {
		BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(data);
		if (root == null) {
			this.root = newNode;
		} else {
			Queue<BinaryTreeNode<T>> queue = new LinkedList<BinaryTreeNode<T>>();
			queue.add(root);
			while (!queue.isEmpty()) {
				BinaryTreeNode<T> node = queue.remove();
				if (node.getLeft() == null) {
					node.setLeft(newNode);
					break;
				} else if (node.getRight() == null) {
					node.setRight(newNode);
					break;
				} else {
					queue.add(node.getLeft());
					queue.add(node.getRight());
				}
			}
		}
	}

	public void insert(BinaryTreeNode<T> root, T item) {
		if (root == null) {
			BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(item);
			root = newNode;
		} else if (root.getLeft() == null) {
			BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(item);
			root.setLeft(newNode);
		} else if (root.getRight() == null) {
			BinaryTreeNode<T> newNode = new BinaryTreeNode<T>(item);
			root.setRight(newNode);
		} else {
			insert(root.getLeft(), item);
		}
	}

	public void preOrder(BinaryTreeNode<T> root) {
		if (root != null) {
			System.out.println(root.getData());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}

	public List<BinaryTreeNode<T>> preOrder() {
		if (this.root == null)
			return null;
		List<BinaryTreeNode<T>> nodeList = new ArrayList<>();
		Stack<BinaryTreeNode<T>> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			BinaryTreeNode<T> node = stack.pop();
			nodeList.add(node);
			if (node.getRight() != null) {
				stack.push(node.getRight());
			}
			if (node.getLeft() != null)
				stack.push(node.getLeft());
		}
		return nodeList;
	}

	public List<BinaryTreeNode<T>> inOrder() {
		if (this.root == null)
			return null;
		List<BinaryTreeNode<T>> nodeList = new ArrayList<>();
		Stack<BinaryTreeNode<T>> stack = new Stack<>();
		BinaryTreeNode<T> node = root;
		stack.push(node);
		while (!stack.isEmpty()) {
			if (node.getLeft() != null) {
				stack.push(node.getLeft());
				node = node.getLeft();
				continue;
			} else {
				nodeList.add(node);
				if (node.getRight() != null) {
					stack.push(node.getRight());
					node = node.getRight();
				} else {
					while (!stack.isEmpty() && node.getRight() == null) {
						node = stack.pop();
						nodeList.add(node);
					}
					node = node.getRight();
				}
			}
		}
		return nodeList;
	}

	public void postOrder(BinaryTreeNode<T> root) {
		if (root != null) {
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.println(root.getData());
		}
	}

	public List<BinaryTreeNode<T>> postOrder() {
		if (this.root == null)
			return null;
		List<BinaryTreeNode<T>> nodeList = new ArrayList<>();
		Stack<BinaryTreeNode<T>> stack = new Stack<>();
		stack.push(root);
		while (!stack.isEmpty()) {
			BinaryTreeNode<T> node = stack.pop();

			nodeList.add(node);
		}
		return nodeList;
	}

	public void inOrder(BinaryTreeNode<T> root) {
		if (root != null) {
			inOrder(root.getLeft());
			System.out.println(root.getData());
			inOrder(root.getRight());
		}
	}

	public List<BinaryTreeNode<T>> levelOrder() {
		if (root == null)
			return null;
		List<BinaryTreeNode<T>> nodeList = new ArrayList<>();
		Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<T> node = queue.remove();
			nodeList.add(node);
			if (node.getLeft() != null)
				queue.add(node.getLeft());
			if (node.getRight() != null)
				queue.add(node.getRight());
		}
		return nodeList;
	}

	public List<BinaryTreeNode<T>> levelOrderInReverse() {
		List<BinaryTreeNode<T>> levelOrderReverse = new ArrayList<>();
		if (this.root != null) {
			Stack<BinaryTreeNode<T>> stack = new Stack<>();
			Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
			queue.add(root);
			while (!queue.isEmpty()) {
				BinaryTreeNode<T> node = queue.remove();
				if (node.getRight() != null)
					queue.add(node.getRight());
				if (node.getLeft() != null)
					queue.add(node.getLeft());
				stack.add(node);
			}
			while (!stack.isEmpty())
				levelOrderReverse.add(stack.pop());
		}
		return levelOrderReverse;
	}

	public BinaryTreeNode<T> findMax(BinaryTreeNode<T> root) {
		if (root == null)
			return null;
		BinaryTreeNode<T> leftMax = findMax(root.getLeft());
		BinaryTreeNode<T> rightMax = findMax(root.getRight());
		BinaryTreeNode<T> max = root;
		if (leftMax != null && leftMax.getData().compareTo(max.getData()) > 0) {
			max = leftMax;
		}
		if (rightMax != null && rightMax.getData().compareTo(max.getData()) > 0)
			max = rightMax;
		return max;
	}

	public BinaryTreeNode<T> findMax() {
		if (this.root == null)
			return root;
		BinaryTreeNode<T> max = this.root;
		Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
		queue.add(max);
		while (!queue.isEmpty()) {
			BinaryTreeNode<T> node = queue.remove();
			if (node.getLeft() != null)
				queue.add(node.getLeft());
			if (node.getRight() != null)
				queue.add(node.getRight());
			if (node.getData().compareTo(max.getData()) > 0)
				max = node;
		}
		return max;
	}

	public BinaryTreeNode<T> search(T item) {
		if (this.root == null || this.root.getData().compareTo(item) == 0)
			return root;
		Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<T> node = queue.remove();
			if (node.getData().compareTo(item) == 0)
				return node;
			if (node.getLeft() != null)
				queue.add(node.getLeft());
			if (node.getRight() != null)
				queue.add(node.getRight());
		}
		return null;
	}

	public BinaryTreeNode<T> search(BinaryTreeNode<T> root, T item) {
		if (root == null || root.getData().compareTo(item) == 0)
			return root;
		BinaryTreeNode<T> resultInLeft = search(root.getLeft(), item);
		if (resultInLeft == null)
			return search(root.getRight(), item);
		else
			return resultInLeft;
	}

	public int size(BinaryTreeNode<T> root) {
		if (root == null)
			return 0;
		else if (root.getLeft() == null && root.getRight() == null)
			return 1;
		else {
			return 1 + size(root.getLeft()) + size(root.getRight());

		}
	}

	public int height(BinaryTreeNode<T> root) {
		if (root == null || (root.getLeft() == null && root.getRight() == null))
			return 0;
		return 1 + Math.max(height(root.getLeft()), height(root.getRight()));
	}

	public int height() {
		int height = 0;
//TODO
		return height;
	}

	public int size() {
		int size = 0;
		if (root == null)
			return size;
		Queue<BinaryTreeNode<T>> queue = new LinkedList<>();
		queue.add(root);
		while (!queue.isEmpty()) {
			BinaryTreeNode<T> node = queue.remove();
			size++;
			if (node.getLeft() != null)
				queue.add(node.getLeft());

			if (node.getRight() != null)
				queue.add(node.getRight());
		}
		return size;
	}

	public void deleteTree(BinaryTreeNode<T> root) {
		this.root = null;
	}

	public static void main(String[] args) {
		BinaryTree<Integer> tree = new BinaryTree<>();
		tree.insert(1);
		tree.insert(2);
//		tree.insert(3);
//		tree.insert(4);
//		tree.insert(5);
//		tree.insert(6);
//		tree.insert(7);
//		tree.insert(8);

//		tree.deleteTree(tree.getRoot());
//		System.out.println(tree.size());
//		System.out.println(tree.levelOrderInReverse());
//		System.out.println(tree.height(tree.getRoot()));
//		System.out.println(tree.size(tree.root) == tree.size());
//		max = tree.findMax();
//		System.out.println(max != null ? max.getData() : null);

		System.out.println(tree.search(2));
	}

}
