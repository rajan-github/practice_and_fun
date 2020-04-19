package linkedlist.examples;

public class DoublyList {
	private int length;
	private DoublyNode head;

	public DoublyList() {
		super();
		this.head = null;
		this.length = 0;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public DoublyNode getHead() {
		return head;
	}

	public void setHead(DoublyNode head) {
		this.head = head;
	}

	public void insertAtFront(int data) {
		DoublyNode node = new DoublyNode(data);
		if (head != null) {
			head.setPrev(node);
		}
		node.setNext(head);
		head = node;
		length++;
	}

	public void insertAtEnd(int data) {
		DoublyNode node = new DoublyNode(data);
		if (head != null) {
			DoublyNode temp = head;
			while (temp.getNext() != null)
				temp = temp.getNext();
			node.setPrev(temp);
			temp.setNext(node);
			node.setNext(null);
		} else {
			head = node;
		}
		length++;
	}

	public void insertInMiddle(int data, int index) {
		if (index <= 1)
			insertAtFront(data);
		else if (index > length)
			insertAtEnd(data);
		else {
			DoublyNode node = new DoublyNode(data);
			DoublyNode temp = head;
			while (index-- > 1)
				temp = temp.getNext();

			node.setNext(temp);
			node.setPrev(temp.getPrev());
			node.getPrev().setNext(node);
			temp.setPrev(node);
			length++;
		}
	}

	public void display() {
		if (head != null) {
			DoublyNode temp = head;
			while (temp != null) {
				System.out.print(temp.getData() + ", ");
				temp = temp.getNext();
			}
		}
	}

	public static void main(String[] args) {
		DoublyList list = new DoublyList();
		list.insertAtEnd(1);
		list.insertAtEnd(2);
		list.insertAtEnd(3);
		list.insertAtEnd(4);
		list.insertAtEnd(5);
		list.display();

		list.insertInMiddle(16, 2);
		list.display();
	}

}
