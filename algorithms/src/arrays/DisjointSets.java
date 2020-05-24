package arrays;

import java.util.HashSet;
import java.util.Set;

/**
 * Given two sets, verify if they are disjoint or not.
 * 
 * @author rajan-c
 *
 */
public class DisjointSets {

	public static boolean areDisjoint(int[] set1, int[] set2) {
		if (set1 == null || set2 == null)
			return true;
		int[] biggerset = set1.length < set2.length ? set2 : set1;
		Set<Integer> set = new HashSet<>();
		for (int item : biggerset)
			set.add(item);
		boolean disjoint = true;
		int[] smallerSet = biggerset == set1 ? set2 : set1;
		for (int i = 0; i < smallerSet.length && disjoint; i++)
			if (set.contains(smallerSet[i]))
				disjoint = false;
		return disjoint;
	}

	public static void main(String[] args) {
		System.out.println(areDisjoint(new int[] { 07, 1 }, new int[] { 1, 2, 3, -3, 9 }));

	}
}
