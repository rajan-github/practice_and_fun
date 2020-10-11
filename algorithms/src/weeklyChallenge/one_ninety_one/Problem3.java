package weeklyChallenge.one_ninety_one;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Problem3 {
	public static int minReorder(int n, int[][] connections) {
		int count = 0;
		Set<Integer> canReachZero = new HashSet<>(), processed = new HashSet<>();
		canReachZero.add(0);
		Map<Integer, Set<Integer>> adjacentMap = new HashMap<>();
		for (int[] connection : connections) {
			if (connection[1] == 0)
				canReachZero.add(connection[0]);

			if (!adjacentMap.containsKey(connection[1]))
				adjacentMap.put(connection[1], new HashSet<>());

			if (!adjacentMap.containsKey(connection[0]))
				adjacentMap.put(connection[0], new HashSet<>());

			adjacentMap.get(connection[0]).add(connection[1]);
		}

		while (canReachZero.size() < n) {
			List<Integer> unreachable = getUnreachableToZero(processed, canReachZero, adjacentMap);
			for (int item : unreachable) {
				canReachZero.add(item);
				count++;

				for (Map.Entry<Integer, Set<Integer>> entry : adjacentMap.entrySet()) {
					if (entry.getValue().contains(item))
						canReachZero.add(entry.getKey());
				}
			}
		}
		return count;
	}

	private static List<Integer> getUnreachableToZero(Set<Integer> processed, Set<Integer> canReachZero,
			Map<Integer, Set<Integer>> adjacentMap) {
		List<Integer> unreachable = new ArrayList<>();
		Iterator<Integer> reachZeroIterator = canReachZero.iterator();
		while (reachZeroIterator.hasNext()) {
			int item = reachZeroIterator.next();
			if (item != 0 && !processed.contains(item)) {
				processed.add(item);
				Set<Integer> adjacentList = adjacentMap.get(item);
				Iterator<Integer> iterator = adjacentList.iterator();
				List<Integer> changed = new ArrayList<>();
				while (iterator.hasNext()) {
					int next = iterator.next();
					if (!canReachZero.contains(next)) {
						unreachable.add(next);
						adjacentMap.get(next).add(item);
						changed.add(next);
					}
				}
				// remove changed adjacent from the node's adjacencyList.
				for (int removedItem : changed)
					adjacentList.remove(removedItem);
			}
		}
		return unreachable;
	}

	public static void main(String[] args) {
//		System.out.println(minReorder(3, new int[][] { { 1, 0 }, { 2, 0 } }));
		System.out.println(minReorder(5, new int[][] { { 1, 0 }, { 1, 2 }, { 3, 2 }, { 3, 4 } }));
	}
}
