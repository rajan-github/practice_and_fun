package arrays;

public class Node {
	Node next = null;
	int data;
	
	public Node(int d) {
		this.data = d;

	}

	void appendToTail(int d) {
		Node end = new Node(d);
		Node current = this;
		while (current.next != null)
			current = current.next;
		current.next = end;
		end.next = null;
	}
}
