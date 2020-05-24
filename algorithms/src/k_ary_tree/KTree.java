package k_ary_tree;

/**
 * This is k-ary tree. Single rooted tree, which can have n children at
 * different levels.
 * 
 * @author rajan-c
 *
 */
public class KTree {

	private KTreeNode root = null;

	/**
	 * level defines at what level this node should be inserted in the tree.
	 * 
	 * @param name
	 * @param convivial
	 * @param level
	 */
	public void insert(String name, double conviviality, int parentlevel, int siblingnumber) {
		KTreeNode node = new KTreeNode(name, conviviality);
		if (root == null) {
			root = node;
		} else {
			KTreeNode parent = root;
			while (parentlevel-- > 0 && parent.getLeft() != null)
				parent = parent.getLeft();

			while (siblingnumber-- > 1 && parent.getRightsibling() != null)
				parent = parent.getRightsibling();
			if (parent.getLeft() == null) {
				// No node .
				parent.setLeft(node);
				node.setParent(parent);
			} else {
				KTreeNode head = parent.getLeft();
				while (head.getRightsibling() != null)
					head = head.getRightsibling();
				head.setRightsibling(node);
				node.setParent(parent);
			}
		}
	}

	public void display() {
		if (root != null) {
			KTreeNode head = root;
			while (head != null) {
				System.out.print(head.getName() + "-" + head.getConviviality() + " \t");
				KTreeNode sibling = head.getRightsibling();
				while (sibling != null) {
					System.out.print(sibling.getName() + "-" + sibling.getConviviality() + "\t");
					sibling = sibling.getRightsibling();
				}
				head = head.getLeft();
				System.out.println();
			}
		} else
			System.out.println("Tree is empty!");
	}

	public static void main(String[] args) {
		KTree tree = new KTree();
		tree.insert("President", 3.5, -1, 1);
		tree.insert("Vice President", 5, 0, 0);
		tree.insert("Vice President", 6, 0, 0);
		tree.insert("Vice President", 5.5, 0, 1);
		tree.insert("Supervisor", 9, 1, 1);
		tree.insert("Supervisor1", 11, 1, 2);
		tree.insert("labour", 16, 2, 1);
		tree.insert("labour1", 16, 2, 2);
		tree.display();

	}
}
