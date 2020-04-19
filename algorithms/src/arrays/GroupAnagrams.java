package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an array of strings, group anagrams together. 
 * All inputs will be in
 * lowercase. The order of your output does not matter.
 * 
 * @author rajan-c
 *
 */
public class GroupAnagrams {

	public List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> groups = new ArrayList<>();
		if (strs == null || strs.length == 0)
			return groups;
		Map<String, List<String>> map = new HashMap<>();
		for (String str : strs) {
			String sortedString = sortString(str);
			if (map.containsKey(sortedString)) {
				List<String> anagramGroup = map.get(sortedString);
				anagramGroup.add(str);
				map.replace(sortedString, anagramGroup);
			} else {
				List<String> anagramGroup = new ArrayList<>();
				anagramGroup.add(str);
				map.put(sortedString, anagramGroup);
			}
		}

		for (Map.Entry<String, List<String>> entry : map.entrySet())
			groups.add(entry.getValue());
		return groups;
	}

	private static String sortString(String str) {
		if (str == null || str.length() == 0)
			return str;
		StringBuilder temp = new StringBuilder();
		char[] sortedChars = mergeSort(str.toCharArray(), 0, str.length() - 1);
		for (char c : sortedChars)
			temp.append(c);
		return temp.toString();
	}

	private static char[] mergeSort(char[] str, int left, int right) {
		if (left < right) {
			int middle = (left + right) / 2;
			char[] leftArray = mergeSort(str, left, middle);
			char[] rightArray = mergeSort(str, middle + 1, right);
			return merge(leftArray, rightArray);
		}
		return new char[] { str[left] };
	}

	private static char[] merge(char[] leftArray, char[] rightArray) {
		int leftLength = leftArray.length, rightLength = rightArray.length;
		char[] merged = new char[leftLength + rightLength];
		int leftIndex = 0, rightIndex = 0, index = 0;

		while (leftIndex < leftArray.length && rightIndex < rightArray.length) {
			if (leftArray[leftIndex] <= rightArray[rightIndex]) {
				merged[index++] = leftArray[leftIndex++];
			} else
				merged[index++] = rightArray[rightIndex++];
		}

		while (leftIndex < leftArray.length)
			merged[index++] = leftArray[leftIndex++];

		while (rightIndex < rightArray.length)
			merged[index++] = rightArray[rightIndex++];

		return merged;
	}

}
