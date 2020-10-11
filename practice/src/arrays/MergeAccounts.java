package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

/**
 * Given a list accounts, each element accounts[i] is a list of strings, where
 * the first element accounts[i][0] is a name, and the rest of the elements are
 * emails representing emails of the account.
 * 
 * Now, we would like to merge these accounts. Two accounts definitely belong to
 * the same person if there is some email that is common to both accounts. Note
 * that even if two accounts have the same name, they may belong to different
 * people as people could have the same name. A person can have any number of
 * accounts initially, but all of their accounts definitely have the same name.
 * 
 * After merging the accounts, return the accounts in the following format: the
 * first element of each account is the name, and the rest of the elements are
 * emails in sorted order. The accounts themselves can be returned in any order.
 * 
 * @author rajan-c
 *
 */
public class MergeAccounts {
	public List<List<String>> accountsMerge(List<List<String>> accounts) {
		if (accounts == null || accounts.isEmpty())
			return new ArrayList<>();
		Map<String, Integer> map = new HashMap<>();
		DisjointSet sets = new DisjointSet();
		int size = accounts.size();
		for (int i = 0; i < size; i++) {
			List<String> account = accounts.get(i);
			int accountSize = account.size();
			sets.makeSet(i);
			for (int j = 1; j < accountSize; j++) {
				String mail = account.get(j);
				if (map.containsKey(mail)) {
					sets.union(i, map.get(mail));
				} else {
					map.put(mail, i);
				}
			}
		}

		Map<Integer, Node> valueToNodeMap = sets.valueToNodeMap;
		Map<Integer, PriorityQueue<Integer>> clusters = new HashMap<>();
		for (Map.Entry<Integer, Node> entry : valueToNodeMap.entrySet()) {
			int parent = sets.findSet(entry.getKey()).data;
			clusters.putIfAbsent(parent, new PriorityQueue<>());
			clusters.get(parent).add(parent);
			clusters.get(parent).add(entry.getKey());
		}

		Set<Integer> processed = new HashSet<>();
		Set<String> addedMails = new HashSet<>();
		List<List<String>> mergedAccounts = new ArrayList<>();
		for (Map.Entry<Integer, PriorityQueue<Integer>> entry : clusters.entrySet()) {
			PriorityQueue<Integer> queue = entry.getValue();
			processed.clear();
			addedMails.clear();
			String name = null;
			List<String> mergedAccount = new ArrayList<>();
			while (!queue.isEmpty()) {
				int listIndex = queue.remove();
				if (!processed.contains(listIndex)) {
					List<String> account = accounts.get(listIndex);
					int accountSize = account.size();
					for (int i = 1; i < accountSize; i++) {
						String mail = account.get(i);
						if (!addedMails.contains(mail)) {
							mergedAccount.add(mail);
							addedMails.add(mail);
						}

					}

					name = account.get(0);
					processed.add(listIndex);
				}
			}
			Collections.sort(mergedAccount);

			mergedAccount.add(0, name);
			mergedAccounts.add(mergedAccount);
		}

		return mergedAccounts;
	}

}

class DisjointSet {
	Map<Integer, Node> valueToNodeMap = new HashMap<>();

	Node makeSet(int x) {
		if (valueToNodeMap.containsKey(x))
			return valueToNodeMap.get(x);
		Node newNode = new Node(x);
		newNode.parent = newNode;
		valueToNodeMap.put(x, newNode);
		return newNode;
	}

	Node findSet(int x) {
		Node node = valueToNodeMap.get(x);
		if (node.parent == node)
			return node;
		node.parent = findSet(node.parent.data);
		return node.parent;
	}

	Node union(int x, int y) {
		return link(findSet(x), findSet(y));
	}

	Node link(Node root1, Node root2) {
		if (root1.rank > root2.rank) {
			root1.parent = root2;
			return root1;
		} else {
			root1.parent = root2;
			if (root1.rank == root2.rank)
				root2.rank += 1;
			return root2;
		}
	}
}

class Node {
	Node parent;
	int data;
	int rank;

	Node(int _data) {
		this.data = _data;
	}

	Node(int _data, Node parent) {
		this.data = _data;
		this.parent = parent;
	}
}
