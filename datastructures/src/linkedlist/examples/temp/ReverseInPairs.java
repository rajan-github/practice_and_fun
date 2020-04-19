package linkedlist.examples.temp;

public class ReverseInPairs {

	public static ListNode swapPairs(ListNode head) {
		if (head == null || (head != null && head.next == null))
			return head;
		ListNode newHead = head.next, tail = head.next, temp;
		temp = head.next.next;
		tail.next = head;
		head.next = swapPairs(temp);
		return newHead;
	}

	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
//		list1.next = new ListNode(2);
//		list1.next.next = new ListNode(3);
//		list1.next.next.next = new ListNode(4);
//		list1.next.next.next.next = new ListNode(5);

		list1 = swapPairs(list1);
		
		while (list1 != null) {
			System.out.print(list1.val);
			list1 = list1.next;
		}
		System.out.print("This is all in list");
	}
}
