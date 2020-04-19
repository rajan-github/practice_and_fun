package linkedlist.exercise;

import linkedlist.examples.LinkNode;

/**
 * This is the implementation of the stack.
 * 
 * @author rajan-c
 *
 */
public class Problem1 {

	private LinkNode top;
	private int length;

	public Problem1() {
		super();
		top = null;
		length = 0;
	}

	public void push(int data) {
		LinkNode node = new LinkNode(data);
		node.setNext(top);
		top = node;
		length++;
	}

	public int pop() {
		if (length == 0) {
			throw new IllegalStateException("Stack Underflow error!", null);
		}
		int data = top.getData();
		top.setNext(top.getNext());
		length--;
		return data;
	}

	public void display() {
		LinkNode temp = top;
		while (temp != null) {
			System.out.println(temp.getData() + ", ");
			temp = temp.getNext();
		}
	}

	public static void main(String[] args) {
		Problem1 stack = new Problem1();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		stack.push(6);
		stack.display();
	}
}
