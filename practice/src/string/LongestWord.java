package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestWord {
	public static String longestWord(String[] words) {
		if (words == null || words.length == 0)
			return "";
		WordDictionary dictionary = new WordDictionary(words);
		Arrays.sort(words);
		List<String> longestWord = new ArrayList<>();
		int longestLength = Integer.MIN_VALUE;
		for (int i = words.length - 1; i >= 0 && words[i].length() >= longestLength; i--) {
			StringBuilder word = new StringBuilder();
			word.append(words[i]);
			while (word.length() > 0) {
				if (!dictionary.wordExists(word))
					break;
				else
					word.delete(word.length() - 1, word.length());
			}
			if (word.length() == 0) {
				longestWord.add(words[i]);
//				System.out.println(words[i]);
				longestLength = Math.max(longestLength, words[i].length());
			}
		}
		Collections.sort(longestWord);
		return (longestWord.isEmpty()) ? "" : longestWord.get(0);
	}

	public static void main(String[] args) {
		String[] words = new String[] { "a", "banana", "app", "appl", "ap", "apply", "apple" };
		String temp = longestWord(words);
		System.out.println(temp);
	}

}

class WordDictionary {
	Node dictionary;
	int longestLength = 0;

	public WordDictionary(String[] words) {
		dictionary = new Node();
		for (String word : words) {
			addWord(word);
			longestLength = Math.max(longestLength, word.length());
		}

	}

	public void addWord(String word) {
		Node currentNode = dictionary;
		int length = word.length();
		for (int i = 0; i < length; i++) {
			char c = word.charAt(i);
			if (currentNode.children.containsKey(c))
				currentNode = currentNode.children.get(c);
			else {
				Node newNode = new Node();
				currentNode.children.put(c, newNode);
				currentNode = currentNode.children.get(c);
			}
		}
		currentNode.isEndOfTheWord = true;
	}

	public boolean wordExists(StringBuilder word) {
		Node currentNode = dictionary;
		int length = word.length(), i = 0;
		for (i = 0; i < length; i++) {
			char c = word.charAt(i);
			if (currentNode.children.containsKey(c))
				currentNode = currentNode.children.get(c);
			else
				return false;
		}
		return currentNode.isEndOfTheWord;
	}

	public boolean prefixExists(StringBuilder prefix) {
		Node currentNode = dictionary;
		int length = prefix.length(), i = 0;
		for (i = 0; i < length; i++) {
			char c = prefix.charAt(i);
			if (currentNode.children.containsKey(c))
				currentNode = currentNode.children.get(c);
			else
				return false;
		}
		return true;
	}
}

class Node {
	Node node;
	Map<Character, Node> children;
	boolean isEndOfTheWord;

	public Node() {
		children = new HashMap<>();
		isEndOfTheWord = false;
	}
}

/**
 * Your StreamChecker object will be instantiated and called as such:
 * StreamChecker obj = new StreamChecker(words); boolean param_1 =
 * obj.query(letter);
 */
