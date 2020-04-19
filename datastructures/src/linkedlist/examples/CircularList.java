package linkedlist.examples;

public class CircularList {
	private LinkNode tail;
	private int length;

	public CircularList() {
		super();
		tail = null;
		length = 0;
	}

	public LinkNode getTail() {
		return tail;
	}

	public void setTail(LinkNode tail) {
		this.tail = tail;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public void insertAtEnd(int data) {
		LinkNode node = new LinkNode(data);
		if (tail == null) {
			tail = node;
			node.setNext(node);
		} else {
			node.setNext(tail.getNext());
			tail.setNext(node);
		}
		length++;
	}

	public void insertAtFront(int data) {
		if (tail == null)
			insertAtEnd(data);
		else {
			LinkNode head = tail.getNext();
			LinkNode node = new LinkNode(data);
			node.setNext(head);
			tail.setNext(node);
			length++;
		}
	}

	public void display() {
		if (tail != null) {
			LinkNode temp = tail;
			while (temp.getNext() != tail) {
				System.out.print(temp.getData() + ", ");
				temp = temp.getNext();
			}
			System.out.println(temp.getData());
		}
	}

	public void deleteLastNode() {
		if (tail != null) {

			if (tail.getNext() == tail) {
				tail = null;
			} else {
				LinkNode head = tail.getNext();
				while (head.getNext() != tail)
					head = head.getNext();
				head.setNext(tail.getNext());
				tail = head;
			}
		}
	}

	public void deleteFirstNode() {
		if (tail != null) {
			if (tail.getNext() == tail)
				tail = null;
			else {
				tail.setNext(tail.getNext().getNext());
			}
		}
	}

	public static void main(String[] args) {
		CircularList clist = new CircularList();
		clist.insertAtFront(1);
		clist.insertAtFront(2);
		clist.insertAtFront(3);
		clist.insertAtFront(4);
		clist.insertAtFront(5);
		clist.insertAtFront(6);
		clist.insertAtFront(7);
		clist.display();

		clist.deleteFirstNode();
		clist.deleteFirstNode();
		clist.deleteFirstNode();
		clist.deleteFirstNode();
		clist.deleteFirstNode();
		clist.deleteFirstNode();
		clist.deleteFirstNode();
		clist.display();
	}
}
