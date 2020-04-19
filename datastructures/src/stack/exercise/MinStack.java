package stack.exercise;

class ListNode {
	int val;
	int min;
	ListNode next;

	ListNode(int x, int minValue) {
		val = x;
		min = minValue;
	}
}

public class MinStack {

	private ListNode head = null;

	/** initialize your data structure here. */
	public MinStack() {
		head = null;
	}

	public void push(int x) {
		ListNode newNode;
		if (head != null)
			newNode = new ListNode(x, head.min < x ? head.min : x);
		else
			newNode = new ListNode(x, x);
		if (head == null)
			head = newNode;
		else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void pop() {
		if (head != null)
			head = head.next;
	}

	public int top() {
		return head.val;
	}

	public int getMin() {
		return head.min;
	}

	public static void main(String[] args) {
		MinStack stack = new MinStack();
		stack.push(1);
		stack.push(2);
		stack.push(3);
		stack.push(4);
		System.out.println(stack.getMin());
		stack.pop();
		stack.pop();
		stack.pop();
		System.out.println(stack.top());
	}
}
