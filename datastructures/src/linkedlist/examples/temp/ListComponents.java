package linkedlist.examples.temp;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ListComponents {
	public int numComponents(ListNode head, int[] G) {
		Map<Integer, ListNode> valueMap = new HashMap<>();
		ListNode iterator = head;
		while (iterator != null) {
			valueMap.put(iterator.val, iterator);
			iterator = iterator.next;
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < G.length; i++)
			set.add(G[i]);
		int components = 0;
		boolean counted = false;
		while (head != null) {
			counted = false;
			int item = head.val;
			while (set.contains(item)) {
				if (!counted) {
					components++;
					counted = true;
				}
				set.remove(item);
				head = head.next;
				if (head != null)
					item = head.val;
			}
			if (head != null)
				head = head.next;
		}
		return components;
	}
}
