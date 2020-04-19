package backtracking.exercise;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * The set [1,2,3,...,n] contains a total of n! unique permutations.
 * 
 * By listing and labeling all of the permutations in order, we get the
 * following sequence for n = 3:
 * 
 * "123" "132" "213" "231" "312" "321" Given n and k, return the kth permutation
 * sequence.
 * 
 * @author rajan-c
 *
 */
public class PermutationSequence {

	private static void swap(StringBuilder permutation, int i, int j) {
		char temp = permutation.charAt(i);
		permutation.replace(i, i + 1, "" + permutation.charAt(j));
		permutation.replace(j, j + 1, "" + temp);
	}

	private static void getPermutations(StringBuilder permutation, int k, List<String> permutations) {
		if (k == permutation.length()) {
			permutations.add(permutation.toString());
			return;
		} else {
			for (int i = k; i < permutation.length(); i++) {
				swap(permutation, k, i);
				getPermutations(permutation, k + 1, permutations);
				swap(permutation, k, i);
			}
		}
	}

	public static String getPermutation(int n, int k) {
		StringBuilder permutation = new StringBuilder();
		for (int i = 1; i <= n; i++)
			permutation.append(i);
		List<String> permutations = new ArrayList<>();
		getPermutations(permutation, 0, permutations);
//		permutations.sort(new SortNumbers());
		return permutations.get(k - 1);
	}

	public static void main(String[] args) {
//		System.out.println(getPermutation(3, 5));
//		System.out.println(getPermutation(4, 9));
		
		System.out.println(getPermutation(9, 273815));
	}
}

class SortNumbers implements Comparator<String> {

	@Override
	public int compare(String arg0, String arg1) {
		Long number1 = new Long(arg0);
		Long number2 = new Long(arg1);
		return number1.compareTo(number2);
	}
}
