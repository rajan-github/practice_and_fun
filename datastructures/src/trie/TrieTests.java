package trie;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TrieTests {
	WordDictionary dictionary = new WordDictionary();

	@Test
	public void testInsert() {
		dictionary.insert("abc");
		dictionary.insert("abcd");
		dictionary.insert("abgl");
		dictionary.insert("jkl");
		dictionary.insert("cdf");
		assertTrue(dictionary.wordSearch("abc"));
		assertTrue(dictionary.wordSearch("abcd"));
		assertTrue(dictionary.wordSearch("abgl"));
		assertTrue(dictionary.wordSearch("jkl"));
		assertTrue(dictionary.wordSearch("cdf"));
		assertFalse(dictionary.wordSearch("adcde"));
		dictionary.insert("abcde");
		assertTrue(dictionary.wordSearch("abcde"));
		dictionary.insert("aaaa");
		assertTrue(dictionary.wordSearch("aaaa"));
		assertFalse(dictionary.wordSearch("aaa"));
		assertFalse(dictionary.wordSearch("aaaaa"));
	}

	@Test
	public void testDelete() {
		dictionary.clear();
		dictionary.insert("abcd");
		dictionary.insert("abcde");
		dictionary.delete("abcd");
		assertTrue(dictionary.wordSearch("abcde"));
		assertFalse(dictionary.wordSearch("abcd"));
		dictionary.delete("abcde");
		assertFalse(dictionary.wordSearch("abcde"));
		assertFalse(dictionary.prefixSearch("abcde"));
		assertFalse(dictionary.prefixSearch("a"));
		assertFalse(dictionary.prefixSearch("ab"));
		assertFalse(dictionary.prefixSearch("abc"));
		assertFalse(dictionary.prefixSearch("abcd"));
		dictionary.insert("aaaa");
		dictionary.delete("aaa");
		assertTrue(dictionary.wordSearch("aaaa"));
		assertTrue(dictionary.prefixSearch("aaa"));
	}
}
