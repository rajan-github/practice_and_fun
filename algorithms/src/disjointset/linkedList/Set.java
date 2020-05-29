package disjointset.linkedList;

public class Set<T> {
	private ListNode<T> head;
	private ListNode<T> tail;
	private int length;

	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}

	public ListNode<T> getTail() {
		return tail;
	}

	public void setTail(ListNode<T> tail) {
		this.tail = tail;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
