package linkedlist.examples.temp;

public class Solution {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head1 = l1, head2 = l2, sumListTail = null;
		int carry = 0, sum = 0;
		while (head1 != null || head2 != null) {
			if (head1 != null && head2 != null) {
				sum = head1.val + head2.val + carry;
				carry = sum >= 10 ? 1 : 0;
				sumListTail = addAtEnd(sumListTail, (carry == 1) ? sum - 10 : sum);
				head1 = head1.next;
				head2 = head2.next;
			} else if (head1 != null) {
				sum = head1.val + carry;
				carry = sum >= 10 ? 1 : 0;
				sumListTail = addAtEnd(sumListTail, (carry == 1) ? sum - 10 : sum);
				head1 = head1.next;

			} else {
				sum = head2.val + carry;
				carry = sum >= 10 ? 1 : 0;
				sumListTail = addAtEnd(sumListTail, (carry == 1) ? sum - 10 : sum);
				head2 = head2.next;
			}
		}
		if (carry == 1) {
			sumListTail = addAtEnd(sumListTail, carry);
			carry = 0;
		}
		ListNode head = sumListTail.next;
		sumListTail.next = null;
		return head;
	}

	public ListNode addAtEnd(ListNode tail, int data) {
		ListNode node = new ListNode(data);
		if (tail == null) {
			tail = node;
			node.next = tail;
			return tail;
		} else {
			node.next = tail.next;
			tail.next = node;
			tail = node;
			return tail;
		}
	}

	public void display(ListNode head) {
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
	}

	public static void main(String[] args) {
		ListNode node = new ListNode(2);
		node.next = new ListNode(4);
		node.next.next = new ListNode(3);

		ListNode node2 = new ListNode(5);
		node2.next = new ListNode(6);
		node2.next.next = new ListNode(4);

		Solution sol = new Solution();
		ListNode sum = sol.addTwoNumbers(node, node2);
		sol.display(sum);
	}

}
