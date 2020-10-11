package disjointset.linkedlist.alternative1;

import java.util.ArrayList;
import java.util.List;

import disjointset.linkedlist.ListNode;
import disjointset.linkedlist.SetNode;

/**
 * Disjoint set operations. It supports union, findSet, and make set operations.
 * Find set and make set are constant time operations. While make-set operation
 * takes O(n) if we are taking union of two set and smaller one is appended at
 * the larger set. Note: this data structure doesn't support duplicate items.
 * This implementation doesn't use tail pointer in set while it only uses head
 * pointer.
 * 
 * @author rajan-c
 *
 * @param <T>
 */
public class SetOperations<T extends Comparable<T>> {

	public SetNode<T> makeSet(T data) {
		ListNode<T> node = new ListNode<>(data);
		SetNode<T> set = new SetNode<>();
		set.setHead(node);
		set.setLength(1);
		return set;
	}

	public ListNode<T> findSet(SetNode<T> set) {
		if (set == null)
			return null;
		return set.getHead();
	}

	public SetNode<T> union(SetNode<T> set1, SetNode<T> set2) {
		if (set1 == null)
			return set2;
		else if (set2 == null)
			return set1;
		else {
			if (set1.getLength() > set2.getLength()) {
				ListNode<T> leader = set1.getHead();
				ListNode<T> head2 = set2.getHead();
				int length = 0;
				while (head2.getNext() != null) {
					head2 = head2.getNext();
					length++;
				}
				head2.setNext(leader.getNext());
				set1.setHead(set2.getHead());
				leader.setNext(set1.getHead());
				set1.setHead(leader);
				set1.setLength(set1.getLength() + length + 1);
				set2.setHead(null);
				return set1;
			} else {
				ListNode<T> leader = set2.getHead();
				ListNode<T> head1 = set1.getHead();
				int length = 0;
				while (head1.getNext() != null) {
					length++;
					head1 = head1.getNext();
				}
				head1.setNext(leader.getNext());
				set2.setLength(set2.getLength() + length + 1);
				leader.setNext(set1.getHead());
				set2.setHead(leader);
				set1.setHead(null);
				return set2;
			}
		}
	}

	public void display(SetNode<T> set) {
		if (set != null) {
			ListNode<T> node = set.getHead();
			System.out.print("{");
			while (node != null) {
				System.out.print(node.getData() + (node.getNext() != null ? "," : ""));
				node = node.getNext();
			}
			System.out.println("}");
		} else
			System.out.println("Set is null: " + set);
	}

	public static void main(String[] args) {
		SetOperations<Integer> setOperations = new SetOperations<>();
		List<SetNode<Integer>> setList = new ArrayList<>();
		int totalSet = 16;
		for (int i = 0; i < totalSet; i++)
			setList.add(setOperations.makeSet(i));

		for (int i = 0; i < setList.size(); i++)
			System.out.println(setOperations.findSet(setList.get(i)).getData());

		SetNode<Integer> set1, set2;
		for (int i = 0; i < totalSet - 1; i++) {
			set1 = setList.remove(0);
			set2 = setList.remove(0);
			setList.add(0, setOperations.union(set1, set2));
		}

		for (int i = 0; i < setList.size(); i++)
			setOperations.display(setList.get(i));
	}

}
