package disjointSets.linkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
public class SetOperations<T> {
	private Map<T, ListNode<T>> listReferences = new HashMap<>();

	/*
	 * This operation would make a new set for item 'data'.
	 */
	public Set<T> makeSet(T data) {
		Set<T> set = new Set<>();
		ListNode<T> node = new ListNode<>(data, null, set);
		listReferences.put(data, node);
		set.setHead(node);
		set.setLength(1);
		set.setTail(node);
		return set;
	}

	/**
	 * This method returns the representative of the set in constant time. If item
	 * is not present in the set then it returns null.
	 * 
	 * @param x
	 * @return
	 */
	public ListNode<T> findSet(T x) {
		if (listReferences.containsKey(x)) {
			ListNode<T> node = listReferences.get(x);
			Set<T> set = node.getSet();
			return set.getHead();
		}
		return null;
	}

	/**
	 * This function takes union of two sets set1 and set2. It appends smaller set
	 * behind the bigger one. Because of this heuristic it only takes O(log n) time
	 * for n sets to unite into one set.
	 * 
	 * @param set1
	 * @param set2
	 * @return
	 */
	public Set<T> union(Set<T> set1, Set<T> set2) {
		ListNode<T> head, tailOfFatherSet;
		Set<T> fatherSet, childSet;
		if (set1.getLength() < set2.getLength()) {
			head = set1.getHead();
			tailOfFatherSet = set2.getTail();
			fatherSet = set2;
			childSet = set1;
		} else {
			head = set2.getHead();
			tailOfFatherSet = set1.getTail();
			fatherSet = set1;
			childSet = set2;
		}

		while (head != null) {
			tailOfFatherSet.setNext(head);
			head.setSet(fatherSet);
			fatherSet.setLength(fatherSet.getLength() + 1);
			fatherSet.setTail(head);
			tailOfFatherSet = head;
			head = head.getNext();
		}
		childSet.setTail(null);
		childSet.setHead(null);
		return fatherSet;
	}

	public void display(Set<T> set) {
		if (set == null)
			System.out.println("Set is null!");
		else {
			System.out.println("Length of the set: " + set.getLength());
			ListNode<T> head = set.getHead();
			while (head != null) {
				System.out.print(head.getData() + "->");
				head = head.getNext();
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		List<Set<Integer>> setList = new ArrayList<>();
		SetOperations<Integer> setOperations = new SetOperations<>();
		for (int item : nums)
			setList.add(setOperations.makeSet(item));

//		for (Set<Integer> set : setList)
//			setOperations.display(set);

		int initialSize = setList.size();
		while (initialSize > 1) {
			Set<Integer> set1 = setList.remove(0);
			Set<Integer> set2 = setList.remove(0);
			Set<Integer> union = setOperations.union(set1, set2);
			setList.add(union);
			initialSize--;
		}
		setOperations.display(setList.get(0));

		System.out.println(setOperations.findSet(1).getData());
		System.out.println(setOperations.findSet(1).getData());
		System.out.println(setOperations.findSet(2).getData());
		System.out.println(setOperations.findSet(3).getData());
		System.out.println(setOperations.findSet(4).getData());

		System.out.println(setOperations.findSet(5).getData());
		System.out.println(setOperations.findSet(6).getData());

		System.out.println(setOperations.findSet(7).getData());
		System.out.println(setOperations.findSet(8).getData());
		System.out.println(setOperations.findSet(9).getData());
//		System.out.println(setOperations.findSet(0).getData());

	}
}
