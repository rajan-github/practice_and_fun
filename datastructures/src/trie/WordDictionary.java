package trie;

public class WordDictionary {

	private TrieNode root;

	public WordDictionary() {
		this.root = new TrieNode();
	}

	public void insert(String string) {
		if (string == null || string.length() == 0)
			return;
		int length = string.length();
		TrieNode head = root;
		for (int i = 0; i < length; i++) {
			char c = string.charAt(i);
			if (!head.getChildren().containsKey(c)) {
				TrieNode newNode = new TrieNode();
				if (i == length - 1)
					newNode.setEndOfWord(true);
				head.getChildren().put(c, newNode);
			}
			head = head.getChildren().get(c);
		}
	}

	public boolean prefixSearch(String prefix) {
		if (prefix == null)
			return false;
		TrieNode head = root;
		int length = prefix.length();
		for (int i = 0; i < length; i++) {
			char c = prefix.charAt(i);
			if (!head.getChildren().containsKey(c))
				return false;
			else
				head = head.getChildren().get(c);
		}
		return true;
	}

	public boolean wordSearch(String word) {
		if (word == null)
			return false;
		TrieNode head = root;
		int length = word.length();
		for (int i = 0; i < length; i++) {
			char c = word.charAt(i);
			if (!head.getChildren().containsKey(c))
				return false;
			head = head.getChildren().get(c);
			if (i == length - 1 && head.isEndOfWord())
				return true;
		}
		return false;
	}

	public void delete(String word) {
		if (word == null || word.length() == 0)
			return;
		delete(word, 0, root);
	}

	private void delete(String word, int index, TrieNode head) {
		int length = word.length();
		if (index < length) {
			char c = word.charAt(index);
			if (head.getChildren().containsKey(c))
				delete(word, index + 1, head.getChildren().get(c));
			else
				return;
		}
		if (index == length && head.isEndOfWord())
			head.setEndOfWord(false);
		else if (index < word.length()) {
			char c = word.charAt(index);
			if (head.getChildren().get(c).getChildren().isEmpty())
				head.getChildren().remove(c);
		}
	}

	public void clear() {
		this.root.getChildren().clear();
		this.root.setEndOfWord(false);
	}

	public static void main(String[] args) {
		WordDictionary dictionary = new WordDictionary();
		dictionary.insert("abc");
		dictionary.insert("abcd");
		dictionary.insert("abgl");
		dictionary.insert("jkl");
		dictionary.insert("cdf");

//		System.out.println(dictionary.prefixSearch("abc"));
//		System.out.println(dictionary.prefixSearch("abcd"));
//		System.out.println(dictionary.wordSearch("abcd"));
//		System.out.println(dictionary.wordSearch("abcde"));
//		System.out.println(dictionary.wordSearch("jkl"));
//		System.out.println(dictionary.wordSearch("abgl"));
//		System.out.println(dictionary.wordSearch("cdf"));

		dictionary.delete("cdf");
		System.out.println(dictionary.wordSearch("cdf"));
		System.out.println(dictionary.prefixSearch("c"));
		System.out.println(dictionary.prefixSearch("cd"));
		System.out.println(dictionary.prefixSearch("cdf"));
		dictionary.delete("abc");
		System.out.println(dictionary.wordSearch("abcd"));

	}
}
