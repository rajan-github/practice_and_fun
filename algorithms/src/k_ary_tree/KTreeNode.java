package k_ary_tree;

/**
 * This is k-ary tree node. Tree is represented with left child and right
 * sibling. Each Node would have pointer to its parent as well.
 * 
 * @author rajan-c
 *
 */
public class KTreeNode {

	private KTreeNode left;
	private KTreeNode rightsibling;
	private KTreeNode parent;

	private String name;
	private double conviviality;

	public KTreeNode(String name, double conviviality) {
		this.name = name;
		this.conviviality = conviviality;
	}

	public KTreeNode getLeft() {
		return left;
	}

	public void setLeft(KTreeNode left) {
		this.left = left;
	}

	public KTreeNode getRightsibling() {
		return rightsibling;
	}

	public void setRightsibling(KTreeNode rightsibling) {
		this.rightsibling = rightsibling;
	}

	public KTreeNode getParent() {
		return parent;
	}

	public void setParent(KTreeNode parent) {
		this.parent = parent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getConviviality() {
		return conviviality;
	}

	public void setConviviality(double conviviality) {
		this.conviviality = conviviality;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(conviviality);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((left == null) ? 0 : left.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((parent == null) ? 0 : parent.hashCode());
		result = prime * result + ((rightsibling == null) ? 0 : rightsibling.hashCode());
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
		KTreeNode other = (KTreeNode) obj;
		if (Double.doubleToLongBits(conviviality) != Double.doubleToLongBits(other.conviviality))
			return false;
		if (left == null) {
			if (other.left != null)
				return false;
		} else if (!left.equals(other.left))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (parent == null) {
			if (other.parent != null)
				return false;
		} else if (!parent.equals(other.parent))
			return false;
		if (rightsibling == null) {
			if (other.rightsibling != null)
				return false;
		} else if (!rightsibling.equals(other.rightsibling))
			return false;
		return true;
	}

}
