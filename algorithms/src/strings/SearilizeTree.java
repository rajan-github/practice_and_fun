package strings;

import java.util.Arrays;

/**
 * Serialization is the process of converting a data structure or object into a
 * sequence of bits so that it can be stored in a file or memory buffer, or
 * transmitted across a network connection link to be reconstructed later in the
 * same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary search tree. There
 * is no restriction on how your serialization/deserialization algorithm should
 * work. You just need to ensure that a binary search tree can be serialized to
 * a string and this string can be deserialized to the original tree structure.
 * 
 * The encoded string should be as compact as possible.
 * 
 * Note: Do not use class member/global/static variables to store states. Your
 * serialize and deserialize algorithms should be stateless.
 * 
 * @author rajan-c
 *
 */
public class SearilizeTree {

	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		StringBuilder inorder = new StringBuilder(), postorder = new StringBuilder();
		inorder(root, inorder);
		postorder(root, postorder);
		inorder.append("#");
		inorder.append(postorder);
		return inorder.toString();
	}

	private void inorder(TreeNode root, StringBuilder inorder) {
		if (root == null)
			return;
		inorder(root.left, inorder);
		if (inorder.length() == 0)
			inorder.append(root.val);
		else
			inorder.append("," + root.val);
		inorder(root.right, inorder);
	}

	private void postorder(TreeNode root, StringBuilder postorder) {
		if (root == null)
			return;
		postorder(root.left, postorder);
		postorder(root.right, postorder);
		if (postorder.length() == 0)
			postorder.append(root.val);
		else
			postorder.append("," + root.val);
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		System.out.println(data);
		String[] treeTraversals = data.split("#");
		if (treeTraversals.length == 2) {
			String inorder = treeTraversals[0], postorder = treeTraversals[1];
			String[] inorderNodes = inorder.split(","), postorderNodes = postorder.split(",");
			return buildTree(inorderNodes, postorderNodes, 0, inorderNodes.length - 1, 0, inorderNodes.length - 1);
		}
		return null;
	}

	private TreeNode buildTree(String[] inorder, String[] postorder, int inorderStart, int inorderEnd,
			int postorderStart, int postorderEnd) {
		if (inorderStart > inorderEnd || postorderStart > postorderEnd)
			return null;
		int rootValue = new Integer(postorder[postorderEnd]);
		int index = Arrays.binarySearch(inorder, postorder[postorderEnd], (String str1, String str2) -> {
			return new Integer(str1).compareTo(new Integer(str2));
		});
		int postOrderIndex = search(postorder, postorderStart, postorderEnd, postorder[postorderEnd]);
		TreeNode root = new TreeNode(rootValue);
		root.left = buildTree(inorder, postorder, inorderStart, index - 1, postorderStart, postOrderIndex);
		root.right = buildTree(inorder, postorder, index + 1, inorderEnd, postOrderIndex + 1, postorderEnd - 1);
		return root;
	}

	private int search(String[] postorder, int start, int end, String target) {
		int i;
		for (i = start; i <= end; i++) {
			if (new Integer(postorder[i]).compareTo(new Integer(target)) >= 0)
				return i - 1;
		}
		return i - 1;
	}

	private boolean compareTrees(TreeNode tree1, TreeNode tree2) {
		if (tree1 == null && tree2 == null)
			return true;
		else if (tree1 == null || tree2 == null)
			return false;
		return tree1.val == tree2.val
				&& (compareTrees(tree1.left, tree2.left) && compareTrees(tree1.right, tree2.right));
	}

	public static void main(String[] args) {
		SearilizeTree serialize = new SearilizeTree();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(8);
		root.right.left = new TreeNode(12);
		root.right.right = new TreeNode(20);

		String serialized = serialize.serialize(root);
		TreeNode tree = serialize.deserialize(serialized);
		System.out.println(serialize.compareTrees(root, tree));
	}
}
