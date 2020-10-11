package disjointset.linkedlist;

import java.util.ArrayList;
import java.util.List;

/**
 * Disjoint set operations. It supports union, findSet, and make set operations.
 * Find set and make set are constant time operations. While make-set operation
 * takes O(n) if we are taking union of two set and smaller one is appended at
 * the larger set. Note: this data structure doesn't support duplicate items.
 * 
 * @author rajan-c
 *
 * @param <T>
 */
public class SetOperations<T extends Comparable<T>> {
	public SetNode<T> makeSet(T data) {
		ListNode<T> node = new ListNode<T>(data);
		SetNode<T> set = new SetNode<>();
		set.setHead(node);
		set.setTail(node);
		set.setLength(1);
		return set;
	}

	public ListNode<T> findSet(SetNode<T> set) {
		if (set != null)
			return set.getHead();
		return null;
	}

	public SetNode<T> union(SetNode<T> set1, SetNode<T> set2) {
		SetNode<T> newParent = null;
		if (set1 != null && set2 != null) {
			int length1 = set1.getLength(), length2 = set2.getLength();
			if (length1 < length2) {
				ListNode<T> list1 = set1.getHead();
				while (list1 != null) {
					set2.getTail().setNext(list1);
					set2.setTail(list1);
					list1.setSet(set2);
					list1 = list1.getNext();
				}
				newParent = set2;
			} else {
				ListNode<T> list2 = set2.getHead();
				while (list2 != null) {
					set1.getTail().setNext(list2);
					list2.setSet(set1);
					set1.setTail(list2);
					list2 = list2.getNext();
				}
				newParent = set1;
			}
		}
		return newParent;
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
