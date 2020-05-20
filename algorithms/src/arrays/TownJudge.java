package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * In a town, there are N people labelled from 1 to N. There is a rumor that one
 * of these people is secretly the town judge.
 * 
 * If the town judge exists, then:
 * 
 * The town judge trusts nobody. Everybody (except for the town judge) trusts
 * the town judge. There is exactly one person that satisfies properties 1 and
 * 2. You are given trust, an array of pairs trust[i] = [a, b] representing that
 * the person labelled a trusts the person labelled b.
 * 
 * If the town judge exists and can be identified, return the label of the town
 * judge. Otherwise, return -1.
 * 
 * @author rajan-c
 *
 */
public class TownJudge {
	public static int findJudge(int N, int[][] trust) {
		Map<Integer, Set<Integer>> trusteeMap = new HashMap<>();
		Set<Integer> rejected = new HashSet<>(), judge = new HashSet<>();
		if (trust != null && trust.length > 0) {
			for (int[] item : trust) {
				int trustee = item[0], trusted = item[1];
				rejected.add(trustee);
				if (!rejected.contains(trusted))
					judge.add(trusted);
				judge.remove(trustee);
				trusteeMap.remove(trustee);
				if (trusteeMap.containsKey(trusted)) {
					trusteeMap.get(item[1]).add(trustee);
				} else {
					Set<Integer> set = new HashSet<>();
					set.add(trustee);
					trusteeMap.put(trusted, set);
				}
			}
			Iterator<Integer> iterator = judge.iterator();
			while (iterator.hasNext()) {
				int temp = iterator.next();
				if (trusteeMap.containsKey(temp) && trusteeMap.get(temp).size() == N - 1)
					return temp;
			}

		} else if (N == 1 && trust.length == 0)
			return 1;
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(findJudge(2, new int[][] { { 1, 2 }, { 2, 1 } }));
	}
}
