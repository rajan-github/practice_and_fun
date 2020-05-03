package trees.binary.exercise;

import java.util.HashMap;
import java.util.Map;

import trees.binary.examples.BinaryTreeNode;
import trees.binary.practice.InorderTraversal;

/**
 * Give an algorithm for constructing binary tree from given Inorder and
 * Postorder traversals. Assuming inorder and postorder inputs are correct
 * inputs.
 * 
 * @author rajan-c
 *
 */
public class Problem30 {
	public static BinaryTreeNode<Integer> binaryTreeFromInorderAndPostorder(int[] inorder, int[] postorder) {
		if (inorder == null || postorder == null || inorder.length != postorder.length || inorder.length == 0)
			return null;
		Map<Integer, Integer> inorderIndexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
			inorderIndexMap.put(inorder[i], i);
		return binaryTreeFromInorderAndPostorder(inorder, postorder, 0, inorder.length - 1, 0, inorder.length - 1,
				inorderIndexMap);
	}

	private static BinaryTreeNode<Integer> binaryTreeFromInorderAndPostorder(int[] inorder, int[] postorder,
			int poststart, int postend, int instart, int inend, Map<Integer, Integer> inorderIndexMap) {
		if (poststart >= 0 && postend >= poststart && instart >= 0 && instart <= inend) {
			BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(postorder[postend]);
			Integer inoderIndex = inorderIndexMap.get(postorder[postend]);
			if (inoderIndex != null) {
				BinaryTreeNode<Integer> left = binaryTreeFromInorderAndPostorder(inorder, postorder, poststart,
						poststart + (inoderIndex - instart - 1), instart, inoderIndex - 1, inorderIndexMap);
				BinaryTreeNode<Integer> right = binaryTreeFromInorderAndPostorder(inorder, postorder,
						poststart + (inoderIndex - instart), postend - 1, inoderIndex + 1, inend, inorderIndexMap);

				root.setLeft(left);
				root.setRight(right);
			}
			return root;
		}
		return null;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = binaryTreeFromInorderAndPostorder(new int[] { 8, 4, 2, 5, 1, 6, 3, 7 },
				new int[] { 8, 4, 5, 2, 6, 7, 3, 1 });

		InorderTraversal.inorder(root);
	}
}
