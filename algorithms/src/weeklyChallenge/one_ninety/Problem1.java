package weeklyChallenge.one_ninety;

/**
 * Given a sentence that consists of some words separated by a single space, and
 * a searchWord.
 * 
 * You have to check if searchWord is a prefix of any word in sentence.
 * 
 * Return the index of the word in sentence where searchWord is a prefix of this
 * word (1-indexed).
 * 
 * If searchWord is a prefix of more than one word, return the index of the
 * first word (minimum index). If there is no such word return -1.
 * 
 * A prefix of a string S is any leading contiguous substring of S.
 * 
 * @author rajan-c
 *
 */
public class Problem1 {
	public static int isPrefixOfWord(String sentence, String searchWord) {
		if ((sentence == null || searchWord == null) || sentence.length() == 0 && searchWord.length() > 0)
			return -1;
		String[] words = sentence.split(" ");
		return prefixExist(words, searchWord);
	}

	private static int prefixExist(String[] words, String prefix) {
		int i = 0, length = words.length;
		outer: for (i = 0; i < length; i++) {
			String word = words[i];
			int prefixLength = prefix.length();
			if (word.length() >= prefixLength) {
				for (int index = 0; index < prefixLength; index++)
					if (word.charAt(index) != prefix.charAt(index))
						continue outer;
				return i + 1;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		System.out.println(isPrefixOfWord("i love eating burger", "burg"));
		System.out.println(isPrefixOfWord("this problem is an easy problem", "pro"));
	}
}
