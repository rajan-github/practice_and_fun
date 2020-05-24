package strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a string S and a string T, count the number of distinct subsequences of
 * S which equals T.
 * 
 * A subsequence of a string is a new string which is formed from the original
 * string by deleting some (can be none) of the characters without disturbing
 * the relative positions of the remaining characters. (ie, "ACE" is a
 * subsequence of "ABCDE" while "AEC" is not).
 * 
 * It's guaranteed the answer fits on a 32-bit signed integer.
 * 
 * @author rajan-c
 *
 */
public class DistinctSubsequences {
	public static int numDistinct(String s, String t) {
		if (s == null || t == null)
			return 0;
		Set<Character> set = new HashSet<>();
		for (int i = 0; i < t.length(); i++)
			set.add(t.charAt(i));
		StringBuilder refinedString = new StringBuilder();
		for (int i = 0; i < s.length(); i++)
			if (set.contains(s.charAt(i)))
				refinedString.append(s.charAt(i));

		s = refinedString.toString();
		if (s.length() < t.length())
			return 0;
		int[] permute = new int[s.length()];
		for (int i = 0; i < t.length(); i++)
			permute[i] = 1;
		Map<Integer, Integer> allOptions = new HashMap<>();
		for (int item : permute) {
			if (allOptions.containsKey(item))
				allOptions.replace(item, allOptions.get(item) + 1);
			else
				allOptions.put(item, 1);
		}
		List<String> subsequences = new ArrayList<>();
		distictPermutations(permute, 0, allOptions, s, t, subsequences);
		return subsequences.size();
	}

	private static void distictPermutations(int[] permute, int k, Map<Integer, Integer> allOptions, String s, String t,
			List<String> subsequences) {
		if (k >= permute.length) {
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < permute.length; i++) {
				if (permute[i] == 1)
					temp.append(s.charAt(i));
			}
			if ((temp.toString()).equals(t))
				subsequences.add(temp.toString());
			return;
		}
		List<Integer> choices = getChoices(permute, k, new HashMap<>(allOptions));
		for (int choice : choices) {
			int temp = permute[k];
			permute[k] = choice;
			distictPermutations(permute, k + 1, allOptions, s, t, subsequences);
			permute[k] = temp;
		}
	}

	private static List<Integer> getChoices(int[] array, int k, Map<Integer, Integer> allOptions) {
		List<Integer> choices = new ArrayList<>();
		for (int i = 0; i < k; i++) {
			int frequency = allOptions.get(array[i]);
			if (frequency > 1)
				allOptions.replace(array[i], frequency - 1);
			else
				allOptions.remove(array[i]);
		}
		for (Map.Entry<Integer, Integer> entry : allOptions.entrySet())
			choices.add(entry.getKey());
		return choices;
	}

	public static void main(String[] args) {
		System.out.println(numDistinct("rabbbit", "rabbit"));
		System.out.println(numDistinct("bccbcdcabadabddbccaddcbabbaaacdba", "bccbbdc"));
		System.out.println(numDistinct("dbaaadcddccdddcadacbadbadbabbbcad", "dadcccbaab"));
	}
}
