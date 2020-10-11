package graph.exercise.chap22;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

import auxiliaryMethods.CommonMethods;

/**
 * There are two types of professional wrestlers: “babyfaces” (“good guys”) and
 * “heels” (“bad guys”). Between any pair of professional wrestlers, there may
 * or may not be a rivalry. Suppose we have n professional wrestlers and we have
 * a list of r pairs of wrestlers for which there are rivalries. Give an O(n+r)
 * time algorithm that determines whether it is possible to designate some of
 * the wrestlers as babyfaces and the remainder as heels such that each rivalry
 * is between a babyface and a heel. If it is possible to perform such a
 * designation, your algorithm should produce it.
 * 
 * @author rajan-c
 *
 */
public class ProfessionalWrestlers {
	/**
	 * Returns null if designation is not possible. Otherwise returns an array with
	 * designations(0,1).
	 * 
	 * @param n
	 * @param rivalries
	 * @return
	 */
	public static int[] designateWrestlers(int n, int[][] rivalries) {
		int[] designation = new int[n + 1];
		Map<Integer, Set<Integer>> adjacencyMap = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			adjacencyMap.put(i, new HashSet<>());
			designation[i] = -1;
		}

		for (int[] rivalry : rivalries)
			adjacencyMap.get(rivalry[0]).add(rivalry[1]);

		int source = 1;
		Queue<Integer> queue = new LinkedList<>();
		Set<Integer> processed = new HashSet<>();
		queue.add(source);
		designation[source] = 0;
		while (!queue.isEmpty()) {
			int node = queue.remove();
			Set<Integer> adjacencyList = adjacencyMap.get(node);
			for (int adjacent : adjacencyList) {
				if (designation[adjacent] == designation[node])
					return null;
				if (!processed.contains(adjacent)) {
					processed.add(adjacent);
					designation[adjacent] = 1 - designation[node];
					queue.add(adjacent);
				}
			}
		}
		return designation;
	}

	public static void main(String[] args) {
		int[] desig = designateWrestlers(3, new int[][] { { 1, 2 }, { 1, 3 } });
//		CommonMethods.display(desig);

		desig = designateWrestlers(5, new int[][] { { 1, 2 }, { 1, 3 }, { 2, 5 }, { 2, 4 }, { 3, 4 }, { 3, 5 } });
		CommonMethods.display(desig);
	}
}
