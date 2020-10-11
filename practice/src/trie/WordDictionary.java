package trie;

import java.util.Map;
import java.util.HashMap;

public class WordDictionary {
	Node dictionary;

	public WordDictionary(String[] words) {
		dictionary = new Node();
		for (String word : words)
			addWord(word);
	}

	public void addWord(String word) {
		if (wordExists(word))
			return;
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

	public boolean wordExists(String word) {
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

	public boolean prefixExists(String prefix) {
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

	public static void main(String[] args) {
		WordDictionary dictionary = new WordDictionary(new String[] { "ab", "ba", "aaab", "abab", "baa" });
		System.out.println(dictionary.prefixExists("a"));
		System.out.println(dictionary.prefixExists("aa"));
		System.out.println(dictionary.prefixExists("aaa"));
		System.out.println(dictionary.prefixExists("aaaa"));
		System.out.println(dictionary.prefixExists("aaaaa"));
		System.out.println(dictionary.prefixExists("aaaaab"));
		System.out.println(dictionary.prefixExists("abab"));
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