package trees.nary.examples;

/**
 * This tree node is n-ary representation. It has left child and pointer to the
 * next sibling.
 * 
 * @author rajan-c
 *
 */
public class TreeNode {
	private int data;
	private TreeNode child;
	private TreeNode sibling;

	public TreeNode(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public TreeNode getChild() {
		return child;
	}

	public void setChild(TreeNode child) {
		this.child = child;
	}

	public TreeNode getSibling() {
		return sibling;
	}

	public void setSibling(TreeNode sibling) {
		this.sibling = sibling;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((child == null) ? 0 : child.hashCode());
		result = prime * result + data;
		result = prime * result + ((sibling == null) ? 0 : sibling.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TreeNode other = (TreeNode) obj;
		if (child == null) {
			if (other.child != null)
				return false;
		} else if (!child.equals(other.child))
			return false;
		if (data != other.data)
			return false;
		if (sibling == null) {
			if (other.sibling != null)
				return false;
		} else if (!sibling.equals(other.sibling))
			return false;
		return true;
	}
}
