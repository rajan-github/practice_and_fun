package strings;

/**
 * Return minimum paths from leaf to root made of characters. Tree node has
 * value ranging in between 0 and 25. Convert number to character and return
 * smallest string lexicographically.
 * 
 * @author rajan-c
 *
 */
public class SmallestStringFromLeaf {
	public static String smallestFromLeaf(TreeNode root) {
		if (root == null)
			return "";
		char[] chars = new char[] { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
		return smallestFromLeaf(root, "", new StringBuilder(), chars);
	}

	private static String smallestFromLeaf(TreeNode root, String minimum, StringBuilder currentBuilder,
			char[] charArray) {
		if (root == null) {
			String current = currentBuilder.toString();
			if (minimum.length() > 0)
				return minimum.compareTo(current) > 0 ? current : minimum;
			return current;
		}
		currentBuilder.insert(0, charArray[root.val]);
		String left = smallestFromLeaf(root.left, minimum, currentBuilder, charArray);
		String right = smallestFromLeaf(root.right, minimum, currentBuilder, charArray);
		currentBuilder.delete(0, 1);
		if (root.left == null)
			return right;
		else if (root.right == null)
			return left;
		return left.compareTo(right) > 0 ? right : left;
	}

	public static void main(String[] args) {
//		TreeNode root = new TreeNode(0);
//		root.left = new TreeNode(1);
//		root.right = new TreeNode(2);
//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(4);
//
//		root.right.left = new TreeNode(3);
//		root.right.right = new TreeNode(4);

		TreeNode root = new TreeNode(0);
//		root.left = new TreeNode(1);
		root.right = new TreeNode(1);
		root.right.left = new TreeNode(2);

		System.out.println(smallestFromLeaf(root));
	}
}
