package trees.binary.practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Return the root node of a binary search tree that matches the given preorder
 * traversal.
 * 
 * (Recall that a binary search tree is a binary tree where for every node, any
 * descendant of node.left has a value < node.val, and any descendant of
 * node.right has a value > node.val. Also recall that a preorder traversal
 * displays the value of the node first, then traverses node.left, then
 * traverses node.right.)
 * 
 * @author rajan-c
 *
 */
public class TreeFromPreorder {
	public static TreeNode bstFromPreorder(int[] preorder) {
		if (preorder == null || preorder.length == 0)
			return null;
		int[] inorder = getInorder(preorder);
		Map<Integer, Integer> inorderMap = new HashMap<>();
		for (int i = 0; i < inorder.length; i++)
			inorderMap.put(inorder[i], i);
		return bstFromPreorder(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1, inorderMap);
	}

	private static TreeNode bstFromPreorder(int[] preorder, int[] inorder, int prestart, int preend, int instart,
			int inend, Map<Integer, Integer> inorderMap) {
		if (prestart >= 0 && prestart <= preend && instart >= 0 && instart <= inend) {
			TreeNode root = new TreeNode(preorder[prestart]);

			int index = inorderMap.get(preorder[prestart]);

			if (index >= 0) {
				root.left = bstFromPreorder(preorder, inorder, prestart + 1, prestart + index - instart, instart,
						index - 1, inorderMap);
				root.right = bstFromPreorder(preorder, inorder, prestart + index - instart + 1, preend, index + 1,
						inend, inorderMap);
			}
			return root;
		}
		return null;
	}

	private static int[] getInorder(int[] items) {
		int[] inorder = new int[items.length];
		for (int i = 0; i < items.length; i++)
			inorder[i] = items[i];
		Arrays.sort(inorder);
		return inorder;
	}

	public static void main(String[] args) {
		TreeNode root = bstFromPreorder(new int[] { 8, 5, 1, 7, 10, 12 });
		System.out.println(root);
	}
}
