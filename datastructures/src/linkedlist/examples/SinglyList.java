package linkedlist.examples;

public class SinglyList {
	private int length = 0;
	private LinkNode head = null;

	public synchronized void insertAtFront(int data) {
		LinkNode newNode = new LinkNode(data);
		length++;
		newNode.setNext(head);
		head = newNode;
	}

	public synchronized void insertAtEnd(int data) {
		LinkNode newNode = new LinkNode(data);
		length++;
		LinkNode temp = head;
		if (head == null) {
			head = newNode;
		} else {
			while (temp.getNext() != null)
				temp = temp.getNext();
			temp.setNext(newNode);
		}
	}

	public synchronized void insertInMiddle(int index, int data) {
		if (index <= 1)
			insertAtFront(data);
		else if (index > length)
			insertAtEnd(data);
		else {
			LinkNode temp = head;
			while (index > 1) {
				index--;
				temp = temp.getNext();
			}
			LinkNode newNode = new LinkNode(data);
			newNode.setNext(temp != null ? temp.getNext() : null);
			temp.setNext(newNode);
		}
	}

	public void display() {
		if (head == null) {
			System.out.println("List is empty!");
		} else {
			LinkNode temp = head;
			while (temp != null) {
				System.out.print(temp.getData() + ", ");
				temp = temp.getNext();
			}
		}
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public LinkNode getHead() {
		return head;
	}

	public void setHead(LinkNode head) {
		this.head = head;
	}

	public static void main(String[] args) {
		SinglyList list = new SinglyList();
		list.insertInMiddle(0, 1);
		list.insertInMiddle(2, 2);
		list.insertInMiddle(3, 3);
		list.insertInMiddle(4, 4);
		list.insertInMiddle(5, 5);
		list.insertInMiddle(6, 6);
		list.insertInMiddle(7, 7);
		list.display();
	}
}
