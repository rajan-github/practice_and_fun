package backtracking.practice;

import java.util.ArrayList;
import java.util.List;

public class PermutaionSequence {
	public static String getPermutation(int n, int k) {
		int[] allIntegers = new int[n + 1];
		for (int i = 1; i <= n; i++)
			allIntegers[i] = 1;
		List<StringBuilder> list = permutations(n, allIntegers, n);
		System.out.println(list);
		return list.get(k - 1).toString();
	}

	private static List<StringBuilder> permutations(int n, int[] set, int size) {
		if (size == 1) {
			List<StringBuilder> permList = new ArrayList<>();
			StringBuilder item = new StringBuilder();
			for (int i = 1; i <= n; i++)
				if (set[i] >= 1)
					item.append(i);
			permList.add(item);
			return permList;
		}
		List<StringBuilder> permutations = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			if (set[i] >= 1) {
				set[i] = -1;
				List<StringBuilder> permutationList = permutations(n, set, size - 1);
				for (StringBuilder str : permutationList) {
					str.insert(0, i);
					permutations.add(str);
				}
				set[i] = 1;
			}
		}
		return permutations;
	}

	public static void main(String[] args) {
		System.out.println(getPermutation(3, 2));
	}

}
