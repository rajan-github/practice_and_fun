package strings;

import java.util.ArrayList;
import java.util.List;

/**
 * Return all the paths of the binary tree.
 * 
 * @author rajan-c
 *
 */
public class BinaryTreePaths {
	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		if (root != null)
			binaryTreePaths(root, paths, new StringBuilder());
		return paths;
	}

	private static void binaryTreePaths(TreeNode root, List<String> paths, StringBuilder currentString) {
		if (root.left == null && root.right == null) {
			StringBuilder val = new StringBuilder();
			val.append(root.val);
			if (currentString.length() == 0)
				currentString.append(val);
			else
				currentString.append("->" + val);
			paths.add(currentString.toString());
			currentString.delete(currentString.length() - val.length(), currentString.length());
			if (currentString.length() > 1 && currentString.substring(currentString.length() - 2).equals("->"))
				currentString.delete(currentString.length() - 2, currentString.length());
		} else {
			StringBuilder val = new StringBuilder();
			val.append(root.val);
			if (currentString.length() == 0)
				currentString.append(val);
			else
				currentString.append("->" + val);
			if (root.left != null)
				binaryTreePaths(root.left, paths, currentString);
			if (root.right != null)
				binaryTreePaths(root.right, paths, currentString);
			currentString.delete(currentString.length() - val.length(), currentString.length());
			if (currentString.length() > 1 && currentString.substring(currentString.length() - 2).equals("->"))
				currentString.delete(currentString.length() - 2, currentString.length());

		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		System.out.println(binaryTreePaths(root));
	}
}
