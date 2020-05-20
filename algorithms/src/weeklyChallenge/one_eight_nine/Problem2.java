package weeklyChallenge.one_eight_nine;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a sentence text (A sentence is a string of space-separated words) in
 * the following format:
 * 
 * First letter is in upper case. Each word in text are separated by a single
 * space. Your task is to rearrange the words in text such that all words are
 * rearranged in an increasing order of their lengths. If two words have the
 * same length, arrange them in their original order.
 * 
 * Return the new text following the format shown above.
 * 
 * @author rajan-c
 *
 */
public class Problem2 {
	public String arrangeWords(String text) {
		char c = text.charAt(0);
		text = Character.toLowerCase(c) + text.substring(1);
		String[] words = text.split(" ");
		Arrays.sort(words, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.length() - o2.length();
			}
		});

		StringBuilder sentence = new StringBuilder();
		for (int i = 0; i < words.length; i++) {
			if (i < words.length - 1) {
				sentence.append(words[i]);
				sentence.append(" ");
			} else
				sentence.append(words[i]);
		}
		c = sentence.charAt(0);
		text = Character.toUpperCase(c) + sentence.substring(1);
		return text;
	}
}
