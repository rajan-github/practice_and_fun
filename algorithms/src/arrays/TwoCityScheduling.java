package arrays;

import java.util.HashSet;
import java.util.Set;

public class TwoCityScheduling {
	public static int twoCitySchedCost(int[][] costs) {
		if (costs == null)
			return 0;
		return twoCitySchedCost(costs, new HashSet<>());
	}

	private static int twoCitySchedCost(int[][] costs, Set<Integer> indexA) {
		if ((indexA.size() * 2) >= costs.length)
			return computeCost(costs, indexA);
		int cost = Integer.MAX_VALUE;
		for (int i = 0; i < costs.length; i++) {
			if (!indexA.contains(i)) {
				indexA.add(i);
				cost = Math.min(cost, twoCitySchedCost(costs, indexA));
				indexA.remove(i);
			}
		}
		return cost;
	}

	private static int computeCost(int[][] costs, Set<Integer> indexes) {
		int sum = 0;
		for (int index : indexes)
			sum += costs[index][0];
		for (int i = 0; i < costs.length; i++)
			if (!indexes.contains(i))
				sum += costs[i][1];
		return sum;
	}

	public static void main(String[] args) {

		System.out.println(twoCitySchedCost(new int[][] { { 10, 20 }, { 30, 200 }, { 400, 50 }, { 30, 20 } }));
		System.out.println(twoCitySchedCost(new int[][] { { 918, 704 }, { 77, 778 }, { 239, 457 }, { 284, 263 },
				{ 872, 779 }, { 976, 416 }, { 860, 518 }, { 13, 351 }, { 137, 238 }, { 557, 596 }, { 890, 227 },
				{ 548, 143 }, { 384, 585 }, { 165, 54 } }));
	}
}
