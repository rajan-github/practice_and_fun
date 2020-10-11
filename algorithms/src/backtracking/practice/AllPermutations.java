package backtracking.practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AllPermutations {
	public static List<String> printPermutations(int n) {
		Set<Integer> set = new HashSet<>();
		for (int i = 1; i <= n; i++)
			set.add(i);
		return permutations(n, 1, set);
	}

	private static List<String> permutations(int n, int current, Set<Integer> set) {
		if (set.size() == 1) {
			List<String> permList = new ArrayList<>();
			permList.add(set.iterator().next() + "");
			return permList;
		}
		List<String> permutations = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (set.contains(i)) {
				set.remove(i);
				List<String> permutationList = permutations(n, current, set);
				for (String str : permutationList)
					permutations.add(i + str);
				set.add(i);
			}
		}
		return permutations;
	}

	public static void main(String[] args) {
		System.out.println(printPermutations(3));
		System.out.println(printPermutations(4));
	}
}
