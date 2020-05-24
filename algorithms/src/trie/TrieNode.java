package trie;

import java.util.HashMap;
import java.util.Map;

/*
 * Trie datastructure. Its like tree but which stores common prefix only once. Thus its space efficient and speed efficient.
 */
public class TrieNode {
	private Map<Character, TrieNode> node = new HashMap<>();
	private boolean endOfWord;

	public Map<Character, TrieNode> getNode() {
		return node;
	}

	public void setNode(Map<Character, TrieNode> node) {
		this.node = node;
	}

	public boolean isEndOfWord() {
		return endOfWord;
	}

	public void setEndOfWord(boolean endOfWord) {
		this.endOfWord = endOfWord;
	}

}
