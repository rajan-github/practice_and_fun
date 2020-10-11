package disjointset.linkedlist;

public class ListNode<T extends Comparable<T>> {
	private T data;
	private ListNode<T> next;
	private SetNode<T> set;

	public ListNode(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ListNode<T> getNext() {
		return next;
	}

	public void setNext(ListNode<T> next) {
		this.next = next;
	}

	public SetNode<T> getSet() {
		return set;
	}

	public void setSet(SetNode<T> set) {
		this.set = set;
	}

}
