package weeklyChallenge.one_ninety;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and an integer k.
 * 
 * Return the maximum number of vowel letters in any substring of s with length
 * k.
 * 
 * Vowel letters in English are (a, e, i, o, u).
 * 
 * @author rajan-c
 *
 */
public class Problem2 {

	public static int maxVowels(String s, int k) {
		if (s == null || s.length() == 0 || k <= 0)
			return 0;
		Set<Character> vowels = new HashSet<>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		int length = s.length(), maxVowelCount = 0, previousCount = 0;
		for (int i = 0; i <= (length - k); i++) {
			if (i == 0) {
				int count = countVowels(s, i, i + k, vowels);
				if (count > maxVowelCount)
					maxVowelCount = count;
				previousCount = count;
			} else {
				char last = s.charAt(i - 1), current = s.charAt(i + k - 1);
				if (!vowels.contains(last) && vowels.contains(current))
					previousCount += 1;

				else if (vowels.contains(last) && !vowels.contains(current))
					previousCount -= 1;

				if (previousCount > maxVowelCount)
					maxVowelCount = previousCount;
			}
		}
		return maxVowelCount;
	}

	private static int countVowels(String str, int start, int end, Set<Character> vowels) {
		int count = 0;
		for (int i = start; i < end; i++) {
			if (vowels.contains(str.charAt(i)))
				count++;
		}
		return count;
	}

	public static void main(String[] args) {
		System.out.println(maxVowels("abciiidef", 3));
		System.out.println(maxVowels("aeiou", 2));
		System.out.println(maxVowels("leetcode", 3));
		System.out.println(maxVowels("rhythms", 4));

	}
}
