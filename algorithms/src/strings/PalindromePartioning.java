package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a string s, partition s such that every substring of the partition is a
 * palindrome.
 * 
 * Return all possible palindrome partitioning of s.
 * 
 * @author rajan-c
 *
 */
public class PalindromePartioning {

	public static List<List<String>> partitions(String s) {
		List<List<String>> partitions = new ArrayList<>();
		Set<String> palindromes = new HashSet<>();
		if (s != null && s.length() > 0) {
			boolean[] cutPositions = new boolean[s.length() - 1];
			partitions(cutPositions, 0, s, partitions, palindromes);
		}
		return partitions;
	}

	private static List<String> palindromePartitions(String s, boolean[] partitions, Set<String> palindromeSet) {
		List<String> palindromes = new ArrayList<>();
		int previous = 0;
		for (int i = 0; i < partitions.length; i++) {
			if (partitions[i]) {
				String substring = s.substring(previous, i + 1);
				if (palindromeSet.contains(substring) || isPalindrome(substring, 0, substring.length() - 1)) {
					palindromes.add(substring);
					palindromeSet.add(substring);
					previous = i + 1;
				} else {
					palindromes.clear();
					return palindromes;
				}
			}
		}
		if (previous < s.length()) {
			if (isPalindrome(s, previous, s.length() - 1))
				palindromes.add(s.substring(previous, s.length()));
			else
				palindromes.clear();
		}
		return palindromes;
	}

	private static boolean isPalindrome(String s, int i, int j) {
		while (i < j && s.charAt(i) == s.charAt(j)) {
			i++;
			j--;
		}
		return i >= j;
	}

	private static void partitions(boolean[] partition, int k, String s, List<List<String>> partitions,
			Set<String> palindromeSet) {
		if (k >= partition.length) {
			List<String> palindromes = palindromePartitions(s, partition, palindromeSet);
			if (!palindromes.isEmpty())
				partitions.add(palindromes);
			return;
		}
		boolean temp = partition[k];
		partition[k] = true;
		partitions(partition, k + 1, s, partitions, palindromeSet);
		partition[k] = temp;
		partition[k] = false;
		partitions(partition, k + 1, s, partitions, palindromeSet);
		partition[k] = temp;
	}

	private static void display(boolean[][] array) {
		for (boolean[] row : array) {
			System.out.print("[");
			for (boolean item : row)
				System.out.print(item + ", ");
			System.out.println("]");
		}
	}

	public static void main(String[] args) {
		List<List<String>> palidromes = partitions("rar");
//		List<List<String>> palidromes = partitions("aaaaaaaaaaaaaaaaaaaaaaaaaaaa");
		for (List<String> p : palidromes)
			System.out.println(p);
	}
}
