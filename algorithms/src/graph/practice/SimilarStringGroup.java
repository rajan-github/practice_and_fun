package graph.practice;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * Two strings X and Y are similar if we can swap two letters (in different
 * positions) of X, so that it equals Y. Also two strings X and Y are similar if
 * they are equal.
 * 
 * For example, "tars" and "rats" are similar (swapping at positions 0 and 2),
 * and "rats" and "arts" are similar, but "star" is not similar to "tars",
 * "rats", or "arts".
 * 
 * Together, these form two connected groups by similarity: {"tars", "rats",
 * "arts"} and {"star"}. Notice that "tars" and "arts" are in the same group
 * even though they are not similar. Formally, each group is such that a word is
 * in the group if and only if it is similar to at least one other word in the
 * group.
 * 
 * We are given a list A of strings. Every string in A is an anagram of every
 * other string in A. How many groups are there?
 * 
 * @author rajan-c
 *
 */
public class SimilarStringGroup {
	public static int numSimilarGroups(String[] array) {
		if (array == null || array.length == 0)
			return 0;
		else if (isSingleCharString(array[0]))
			return 1;
		Map<String, Integer> strToIntegerMap = new HashMap<>();
		Map<Integer, Set<Integer>> adjacentMap = new HashMap<>();

		for (int i = 0; i < array.length; i++) {
			strToIntegerMap.put(array[i], i);
			adjacentMap.put(i, new HashSet<>());
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (i != j && areSame(array[i], array[j])) {
					adjacentMap.get(i).add(j);
					adjacentMap.get(j).add(i);
				}
			}
		}

		int count = 0;
		int[] color = new int[array.length];
		for (int i = 0; i < array.length; i++) {
			if (color[i] == 0) {
				color[i] = 1;
				count += 1;
				bfs(adjacentMap, color, i);
			}
		}
		return count;
	}

	private static void bfs(Map<Integer, Set<Integer>> graph, int[] color, int source) {
		Queue<Integer> queue = new LinkedList<>();
		color[source] = 1;
		queue.add(source);
		while (!queue.isEmpty()) {
			int node = queue.remove();
			Set<Integer> adjacents = graph.get(node);
			for (int adjacent : adjacents) {
				if (color[adjacent] == 0) {
					color[adjacent] = 1;
					queue.add(adjacent);
				}
			}
			color[source] = 2;
		}
	}

	private static boolean isSingleCharString(String str) {
		int index = 0, length = str.length();
		char c = str.charAt(0);
		while (index < length)
			if (str.charAt(index++) != c)
				return false;
		return true;
	}

	private static boolean areSame(String str1, String str2) {
		int leftIndex = 0, rightIndex = str1.length() - 1;
		boolean mismatchFound = false;
		while (leftIndex < rightIndex) {
			char leftChar1 = str1.charAt(leftIndex), rightChar1 = str1.charAt(rightIndex),
					leftChar2 = str2.charAt(leftIndex), rightChar2 = str2.charAt(rightIndex);
			if (leftChar1 == leftChar2)
				leftIndex++;
			else if (rightChar1 == rightChar2)
				rightIndex--;
			else if (leftChar1 != leftChar2 && rightChar1 != rightChar2 && leftChar1 == rightChar2
					&& leftChar2 == rightChar1 && !mismatchFound) {
				leftIndex++;
				rightIndex--;
				mismatchFound = true;
			} else
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String[] array = new String[] { "tars", "rats", "arts", "star" };
		System.out.println(areSame("arts", "star"));
		System.out.println(areSame("rats", "star"));
		System.out.println(numSimilarGroups(array));
		System.out.println(isSingleCharString("aaa"));
	}
}
