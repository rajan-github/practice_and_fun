package strings;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, sort it in decreasing order based on the frequency of
 * characters.
 * 
 * @author rajan-c
 *
 */
public class SortByFrequency {
	public static String frequencySort(String s) {
		StringBuilder sortedString = new StringBuilder();
		if (s != null && s.length() > 0) {
			Map<Character, Integer> frequency = new HashMap<>();
			int length = s.length(), size = 0;
			char[] characters = new char[length];
			for (int i = 0; i < length; i++) {
				char c = s.charAt(i);
				characters[i] = c;
				if (frequency.containsKey(c))
					frequency.replace(c, frequency.get(c) + 1);
				else {
					frequency.put(c, 1);
					characters[size++] = c;
				}

			}
			characters = mergeSort(characters, 0, size - 1, frequency);
			for (char c : characters) {
				int f = frequency.get(c);
				while (f-- > 0)
					sortedString.append(c);
			}

		}
		return sortedString.toString();
	}

	public static char[] mergeSort(char[] array, int start, int end, Map<Character, Integer> frequency) {
		if (start < end) {
			int middle = (start + end) / 2;
			char[] left = mergeSort(array, start, middle, frequency);
			char[] right = mergeSort(array, middle + 1, end, frequency);
			return merge(left, right, frequency);

		} else
			return new char[] { array[start] };
	}

	private static char[] merge(char[] left, char[] right, Map<Character, Integer> frequency) {
		char[] merged = new char[left.length + right.length];
		int leftIndex = 0, rightIndex = 0, index = 0;
		while (leftIndex < left.length && rightIndex < right.length) {
			if (frequency.get(left[leftIndex]) >= frequency.get(right[rightIndex])) {
				char c = left[leftIndex];
				while (leftIndex < left.length && c == left[leftIndex]) {
					merged[index++] = c;
					leftIndex++;
				}
			} else {
				char c = right[rightIndex];
				while (rightIndex < right.length && c == right[rightIndex]) {
					merged[index++] = c;
					rightIndex++;
				}
			}
		}

		while (leftIndex < left.length) {
			merged[index++] = left[leftIndex];
			leftIndex++;
		}

		while (rightIndex < right.length) {
			merged[index++] = right[rightIndex];
			rightIndex++;
		}
		return merged;
	}

	public static void main(String[] args) {
		System.out.println(frequencySort("tree"));
		System.out.println(frequencySort("cccaaa"));
		System.out.println(frequencySort("Aabb"));
		System.out.println(frequencySort("loveleetcode"));

	}
}
