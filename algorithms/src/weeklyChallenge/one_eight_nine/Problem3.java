package weeklyChallenge.one_eight_nine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given the array favoriteCompanies where favoriteCompanies[i] is the list of
 * favorites companies for the ith person (indexed from 0).
 * 
 * Return the indices of people whose list of favorite companies is not a subset
 * of any other list of favorites companies. You must return the indices in
 * increasing order.
 * 
 * @author rajan-c
 *
 */
public class Problem3 {
	public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
		Map<Integer, Set<String>> map = new HashMap<>();
		int candidateCount = favoriteCompanies.size();
		for (int i = 0; i < candidateCount; i++) {
			List<String> companies = favoriteCompanies.get(i);
			Set<String> set = new HashSet<>();
			for (String name : companies) {
				set.add(name);
			}
			map.put(i, set);
		}
		List<Integer> people = new ArrayList<>();
		for (int i = 0; i < candidateCount; i++) {
			if (!isSubset(map, i, favoriteCompanies.get(i)))
				people.add(i);
		}

		return people;
	}

	private static boolean isSubset(Map<Integer, Set<String>> favoriteCompanies, int person, List<String> companies) {
		outer: for (Map.Entry<Integer, Set<String>> entry : favoriteCompanies.entrySet()) {
			if (entry.getKey() != person && entry.getValue().size() >= companies.size()) {
				for (String company : companies) {
					if (!entry.getValue().contains(company))
						continue outer;
				}
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		Map<Integer, Set<String>> map = new HashMap<>();

		Set<String> set1 = new HashSet<>();
		set1.add("google");
		set1.add("linkedin");
		set1.add("microsoft");
		map.put(0, set1);

		Set<String> set2 = new HashSet<>();
		set2.add("google");
		map.put(1, set2);

		Set<String> set3 = new HashSet<>();
		set3.add("google");
		set3.add("linkedin");
		map.put(2, set3);

		Set<String> set4 = new HashSet<>();
		set4.add("amazon");
		set4.add("linkedin");
		map.put(3, set4);

		System.out.println(isSubset(map, 0, Arrays.asList(new String[] { "google", "linkedin", "microsoft" })));
		System.out.println(isSubset(map, 1, Arrays.asList(new String[] { "google" })));
		System.out.println(isSubset(map, 2, Arrays.asList(new String[] { "google", "linkedin" })));
		System.out.println(isSubset(map, 3, Arrays.asList(new String[] { "amazon", "linkedin" })));
	}
}
