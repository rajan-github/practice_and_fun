package strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 
 * Only one letter can be changed at a time Each transformed word must exist in
 * the word list. Note that beginWord is not a transformed word.
 *TODO: Timeout
 * @author rajan-c
 *
 */
public class WordLadder2 {
	public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
		List<List<String>> ladders = new ArrayList<>();
		if (!wordList.contains(endWord))
			return ladders;
		List<String> ladder = new ArrayList<>();
		Set<String> set = new HashSet<>();
		ladder.add(beginWord);
		set.add(beginWord);
		getLadders(beginWord, endWord, wordList, ladders, ladder, set);
		return filterLists(ladders);
	}

	private List<List<String>> filterLists(List<List<String>> ladders) {
		List<List<String>> filtered = new ArrayList<>();
		int minSize = Integer.MAX_VALUE;
		for (List<String> list : ladders)
			if (list.size() < minSize)
				minSize = list.size();
		for (List<String> list : ladders)
			if (list.size() == minSize)
				filtered.add(list);
		return filtered;
	}

	private void getLadders(String beginWord, String endWord, List<String> wordList, List<List<String>> ladders,
			List<String> ladder, Set<String> usedWords) {
		if (beginWord.equals(endWord)) {
			List<String> clone = new ArrayList<>();
			for (String item : ladder)
				clone.add(item);
			ladders.add(clone);
			return;
		}
		List<String> choices = getWordsWithSingleDiff(beginWord, wordList);
		for (String choice : choices) {
			if (!usedWords.contains(choice)) {
				ladder.add(choice);
				usedWords.add(choice);
				getLadders(choice, endWord, wordList, ladders, ladder, usedWords);
				ladder.remove(choice);
				usedWords.remove(choice);
			}
		}
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
		array = new String[] { "a", "b", "c" };
//		array = new String[] { "hot", "dog", "dot" };
//		array = new String[] { "ted", "tex", "red", "tax", "tad", "den", "rex", "pee" };
		for (String item : array)
			wordList.add(item);
//		List<List<String>> ladders = new WordLadder2().findLadders("red", "tax", wordList);
//		List<List<String>> ladders = new WordLadder2().findLadders("hit", "cog", wordList);
		List<List<String>> ladders = new WordLadder2().findLadders("a", "c", wordList);
//		List<List<String>> ladders = new WordLadder2().findLadders("hot", "dog", wordList);
		System.out.println(ladders);

	}
}
