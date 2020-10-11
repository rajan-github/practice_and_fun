package disjointset.linkedlist.alternative1;

import disjointset.linkedlist.ListNode;

/**
 * In this implementation we are not using tail pointer but instead we are using
 * only head pointer and list is added at the front of the another list instead
 * of appending in the union operation.
 * 
 * @author rajan-c
 *
 * @param <T>
 */
public class SetNode<T extends Comparable<T>> {
	private ListNode<T> head;
	private int length = 0;

	public ListNode<T> getHead() {
		return head;
	}

	public void setHead(ListNode<T> head) {
		this.head = head;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

}
