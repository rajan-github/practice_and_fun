package trie.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * Design a data structure that supports the search, delete and prefix search on
 * strings. Also uses memory efficiently.
 * 
 * @author rajan-c
 *
 */
public class WordDictionary {
	class TrieNode {
		Map<Character, TrieNode> children;
		boolean endOfWord;

		public TrieNode() {
			children = new HashMap<>();
			endOfWord = false;
		}
	}

	TrieNode root;

	/** Initialize your data structure here. */
	public WordDictionary() {
		root = new TrieNode();
	}

	/** Adds a word into the data structure. */
	public void addWord(String word) {
		if (word != null && word.length() > 0) {
			int length = word.length();
			TrieNode current = root;
			int i = 0;
			for (i = 0; i < length; i++) {
				char c = word.charAt(i);
				if (!current.children.containsKey(c)) {
					TrieNode node = new TrieNode();
					current.children.put(c, node);
					current = current.children.get(c);
				} else
					current = current.children.get(c);
			}
			current.endOfWord = true;
		}
	}

	/** Adds a word into the data structure. */
	public void addWordRecursive(String word) {
		addWordRecursive(word, 0, root);
	}

	private void addWordRecursive(String word, int index, TrieNode current) {
		if (index >= word.length()) {
			current.endOfWord = true;
			return;
		}
		char c = word.charAt(index);
		if (!current.children.containsKey(c)) {
			TrieNode node = new TrieNode();
			current.children.put(c, node);
		}
		addWordRecursive(word, index + 1, current.children.get(c));
	}

	/**
	 * Returns true if the word is in the data structure.
	 */
	public boolean search(String word) {
		if (word != null && word.length() > 0) {
			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				char c = word.charAt(i);
				if (!current.children.containsKey(c))
					return false;
				current = current.children.get(c);
			}
			return current.endOfWord;
		}
		return false;
	}

	/**
	 * Returns true if data structure contains
	 * 
	 * @param prefix
	 * @return
	 */
	public boolean prefixSearch(String prefix) {
		int i = 0, length = prefix.length();
		TrieNode current = root;
		for (i = 0; i < length; i++) {
			char c = prefix.charAt(i);
			if (!current.children.containsKey(c))
				return false;
			current = current.children.get(c);
		}
		return true;
	}

	/*
	 * delete the word from the data structure.
	 */
	public void delete(String word) {
		if (search(word))
			delete(word, 0, word.charAt(0), root);
	}

	private void delete(String word, int index, char c, TrieNode current) {
		if (index < word.length() - 1) {
			delete(word, index + 1, word.charAt(index + 1), current.children.get(c));
		}
		TrieNode child = current.children.get(c);
		if (child.children.isEmpty())
			current.children.remove(c);
		else
			child.endOfWord = false;
	}

	public static void main(String[] args) {
		WordDictionary dictionary = new WordDictionary();
		dictionary.addWordRecursive("rajan");
		dictionary.addWordRecursive("rajanam");
		dictionary.addWordRecursive("abc");
		dictionary.addWordRecursive("abcd");
		dictionary.addWordRecursive("abcde");
		dictionary.addWordRecursive("lmn");

//		System.out.println(dictionary.search("rajan"));
//		System.out.println(dictionary.search("rajanam"));
//		System.out.println(dictionary.search("abc"));
//		System.out.println(dictionary.search("abcd"));
//		System.out.println(dictionary.search("abcde"));
//		System.out.println(dictionary.search("lmn"));
//		System.out.println(dictionary.search("klm"));

		System.out.println(dictionary.prefixSearch("klm"));
		System.out.println(dictionary.prefixSearch("ab"));
		System.out.println(dictionary.prefixSearch("abc"));
		System.out.println(dictionary.prefixSearch("l"));
		System.out.println(dictionary.prefixSearch("lm"));

		System.out.println("------------------Testing delete operation-----------------------");
		dictionary.delete("klm");
		System.out.println(dictionary.search("klm"));
		dictionary.delete("abc");
		System.out.println(dictionary.search("abc"));
		System.out.println(dictionary.search("abcd"));
		System.out.println(dictionary.search("abcde"));
		System.out.println(dictionary.search("rajan"));
		dictionary.delete("abcd");
		System.out.println(dictionary.search("abcde"));

		dictionary.delete("abcde");
		System.out.println(dictionary.search("abcde"));
	}
}
