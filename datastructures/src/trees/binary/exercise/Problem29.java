package trees.binary.exercise;

import java.util.HashMap;
import java.util.Map;

import trees.binary.examples.BinaryTreeNode;
import trees.binary.practice.InorderTraversal;

/**
 * Give an algorithm for constructing binary tree from given Inorder and
 * Preorder traversals.
 * 
 * @author rajan-c
 *
 */
public class Problem29 {

	public static BinaryTreeNode<Integer> binaryTreeFromInorderAndPreorder(int[] inorder, int[] preorder) {
		if (inorder == null || preorder == null || inorder.length != preorder.length || inorder.length == 0)
			return null;
		Map<Integer, Integer> inorderIndexMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
			inorderIndexMap.put(inorder[i], i);
		return binaryTreeFromInorderAndPreorder(inorder, preorder, 0, inorder.length - 1, 0, inorder.length - 1,
				inorderIndexMap);
	}

	private static BinaryTreeNode<Integer> binaryTreeFromInorderAndPreorder(int[] inorder, int[] preorder, int prestart,
			int preend, int instart, int inend, Map<Integer, Integer> inorderIndexMap) {
		if (prestart >= 0 && prestart <= preend && instart >= 0 && instart <= inend) {
			BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(preorder[prestart]);
			Integer inoderIndex = inorderIndexMap.get(preorder[prestart]);
			if (inoderIndex != null) {
				BinaryTreeNode<Integer> left = binaryTreeFromInorderAndPreorder(inorder, preorder, prestart + 1,
						prestart + (inoderIndex - instart), instart, inoderIndex - 1, inorderIndexMap);
				BinaryTreeNode<Integer> right = binaryTreeFromInorderAndPreorder(inorder, preorder,
						prestart + (inoderIndex - instart) + 1, preend, inoderIndex + 1, inend, inorderIndexMap);

				root.setLeft(left);
				root.setRight(right);
			}
			return root;
		}
		return null;
	}

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = binaryTreeFromInorderAndPreorder(new int[] { 8, 4, 2, 5, 1, 6, 3, 7 },
				new int[] { 1, 2, 4, 8, 5, 3, 6, 7 });

		InorderTraversal.inorder(root);
	}

}
