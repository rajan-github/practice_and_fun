package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together. Input: ["eat", "tea",
 * "tan", "ate", "nat", "bat"], Output: [ ["ate","eat","tea"], ["nat","tan"],
 * ["bat"] ]
 * 
 * @author rajan-c
 *
 */
public class GroupAnagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> lists = new ArrayList<>();
		if (strs != null) {
			Map<Map<Character, Integer>, List<String>> anagrams = new HashMap<>();

			for (String str : strs) {
				Map<Character, Integer> map = new HashMap<>();
				for (int i = 0; i < str.length(); i++) {
					if (map.containsKey(str.charAt(i))) {
						map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
					} else {
						map.put(str.charAt(i), 1);
					}
				}
				anagrams.putIfAbsent(map, new ArrayList<String>());
			}

			for (String str : strs) {
				Map<Character, Integer> map = new HashMap<>();
				for (int i = 0; i < str.length(); i++) {
					if (map.containsKey(str.charAt(i))) {
						map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
					} else {
						map.put(str.charAt(i), 1);
					}
				}
				if (anagrams.containsKey(map)) {
					List<String> temp = anagrams.get(map);
					temp.add(str);
				}
			}

			for (Map.Entry<Map<Character, Integer>, List<String>> entry : anagrams.entrySet()) {
				lists.add(entry.getValue());
			}
		}
		return lists;
	}

	private static void display(List<List<String>> lists) {
		for (List<String> list : lists)
			System.out.println(list);
	}

	public static void main(String[] args) {
		String[] strs = {

				"hos", "boo", "nay", "deb", "wow", "bop", "bob", "brr", "hey", "rye", "eve", "elf", "pup", "bum", "iva",
				"lyx", "yap", "ugh", "hem", "rod", "aha", "nam", "gap", "yea", "doc", "pen", "job", "dis", "max", "oho",
				"jed", "lye", "ram", "pup", "qua", "ugh", "mir", "nap", "deb", "hog", "let", "gym", "bye", "lon", "aft",
				"eel", "sol", "jab" };

		display(groupAnagrams(strs));
	}
}
