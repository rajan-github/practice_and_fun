package backtracking.exercise;

/**
 * Anagrams are rearrangements of the letters of a word or phrase into a
 * different word or phrase. Sometimes the results are quite striking. For
 * example, “MANY VOTED BUSH RETIRED” is an anagram of “TUESDAY NOVEMBER THIRD,”
 * which correctly predicted the result of the 1992 U.S. presidential election.
 * Design and implement an algorithm for finding anagrams using combinatorial
 * search and a dictionary.
 * 
 * @author rajan-c
 *
 */
public class Anagrams {

	private static void swap(StringBuilder string, int i, int j) {
		char temp = string.charAt(i);
		string.setCharAt(i, string.charAt(j));
		string.setCharAt(j, temp);
	}

	private static void anagrams(StringBuilder string, int index) {
		if (index == string.length()) {
			System.out.println(string);
			return;
		}
		for (int i = index; i < string.length(); i++) {
			swap(string, index, i);
			anagrams(string, index + 1);
			swap(string, index, i);
		}
	}

	public static void anagrams(String string) {
		if (string == null || string.length() == 0) {
			System.out.println(string);
			return;
		}
		StringBuilder strWithoutSpace = new StringBuilder();
		for (int i = 0; i < string.length(); i++)
			if (string.charAt(i) != ' ')
				strWithoutSpace.append(string.charAt(i));
		anagrams(strWithoutSpace, 0);
	}

	public static void main(String[] args) {
		StringBuilder string = new StringBuilder("TUESDAY NOVEMBER THIRD");
		anagrams(string.toString());
	}

}
