package linkedlist.examples;

public class DoublyNode {
	private int data;
	private DoublyNode next;
	private DoublyNode prev;

	public DoublyNode(int data, DoublyNode next, DoublyNode prev) {
		super();
		this.data = data;
		this.next = next;
		this.prev = prev;
	}

	public DoublyNode(int data) {
		super();
		this.data = data;
		this.next = null;
		this.prev = null;
	}

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}

	public DoublyNode getNext() {
		return next;
	}

	public void setNext(DoublyNode next) {
		this.next = next;
	}

	public DoublyNode getPrev() {
		return prev;
	}

	public void setPrev(DoublyNode prev) {
		this.prev = prev;
	}

}
