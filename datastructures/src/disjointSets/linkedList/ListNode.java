package disjointSets.linkedList;

public class ListNode<T> {
	private T data;
	private ListNode<T> next;
	private Set<T> set;

	public ListNode(T data, ListNode<T> next, Set<T> set) {
		super();
		this.data = data;
		this.next = next;
		this.set = set;
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

	public Set<T> getSet() {
		return set;
	}

	public void setSet(Set<T> set) {
		this.set = set;
	}

}
