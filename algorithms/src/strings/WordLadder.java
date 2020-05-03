package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 * 
 * Only one letter can be changed at a time. Each transformed word must exist in
 * the word list.
 * 
 * @author rajan-c
 *
 */
public class WordLadder {
	public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		int cost = 1;
		Queue<String> queue = new LinkedList<>();
		queue.add(beginWord);
		queue.add(null);
		Set<String> usedWords = new HashSet<>();
		usedWords.add(beginWord);
		while (!queue.isEmpty()) {
			String word = queue.remove();
			if (word != null) {
				if (word.equals(endWord))
					return cost;
				List<String> choices = getWordsWithSingleDiff(word, wordList);
				for (String choice : choices) {
					if (!usedWords.contains(choice)) {
						usedWords.add(choice);
						queue.add(choice);
					}
				}
			} else {
				cost++;
				if (!queue.isEmpty())
					queue.add(null);
			}
		}
		return 0;
	}

	/**
	 * Wrong method
	 * 
	 * @param beginWord
	 * @param endWord
	 * @param wordList
	 * @return
	 */
	public static int ladderLengthFast(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord))
			return 0;
		int costBegin = 1, costEnd = 1;
		Queue<String> queueBegin = new LinkedList<>(), queueEnd = new LinkedList<>();
		queueBegin.add(beginWord);
		queueBegin.add(null);

		queueEnd.add(endWord);
		queueEnd.add(null);

		Set<String> usedWordsBegin = new HashSet<>(), usedWordsEnd = new HashSet<>();
		usedWordsBegin.add(beginWord);
		usedWordsEnd.add(endWord);
		while (!queueBegin.isEmpty() && !queueEnd.isEmpty()) {
			String wordFromBegin = queueBegin.remove(), wordFromEnd = queueEnd.remove();
			if (wordFromBegin != null && wordFromEnd != null) {
				List<String> beginChoices = getWordsWithSingleDiff(wordFromBegin, wordList),
						endChoices = getWordsWithSingleDiff(wordFromEnd, wordList);
				for (String beginChoice : beginChoices) {
					if (beginChoice.equals(endWord))
						return costBegin + 1;
					else if (usedWordsEnd.contains(beginChoice))
						return costBegin + costEnd;
					else if (!usedWordsBegin.contains(beginChoice)) {
						usedWordsBegin.add(beginChoice);
						queueBegin.add(beginChoice);
					}
				}
				for (String endChoice : endChoices) {
					if (endChoice.equals(beginWord))
						return costEnd + 1;
					else if (usedWordsBegin.contains(endChoice))
						return costBegin + costEnd + 1;
					else if (!usedWordsEnd.contains(endChoice)) {
						usedWordsEnd.add(endChoice);
						queueEnd.add(endChoice);
					}
				}

			} else {
				if (wordFromBegin == null) {
					++costBegin;
					if (!queueBegin.isEmpty())
						queueBegin.add(null);
				}
				if (wordFromEnd == null) {
					++costEnd;
					if (!queueEnd.isEmpty())
						queueEnd.add(null);
				}
			}
		}
		return 0;
	}

	private static List<String> getWordsWithSingleDiff(String word, List<String> wordList) {
		List<String> wordsWithSingleDiff = new ArrayList<>();
		for (String item : wordList)
			if (wordDiff(word, item) == 1)
				wordsWithSingleDiff.add(item);
		return wordsWithSingleDiff;
	}

	private static int wordDiff(String word1, String word2) {
		int diff = 0, length = word1.length();
		for (int i = 0; i < length; i++)
			if (word1.charAt(i) != word2.charAt(i))
				diff++;
		return diff;
	}

	public static void main(String[] args) {
		List<String> wordList = new ArrayList<>();
		String[] array = new String[] { "hot", "cog", "dog", "tot", "hog", "hop", "pot", "dot" };
		array = new String[] { "hot", "dot", "dog", "lot", "log", "cog" };
//		array = new String[] { "a", "b", "c" };
//		array = new String[] { "ted", "tex", "red", "tax", "tad", "den", "rex", "pee" };
		for (String item : array)
			wordList.add(item);
		System.out.println(ladderLengthFast("red", "tax", wordList));
		System.out.println(ladderLengthFast("a", "c", wordList));
//		System.out.println(ladderLength("hit", "cog", wordList) == ladderLengthFast("hit", "cog", wordList));
		System.out.println(ladderLengthFast("hit", "cog", wordList));
		System.out.println(ladderLength("hot", "dog", wordList) == ladderLengthFast("hot", "dog", wordList));
	}
}
