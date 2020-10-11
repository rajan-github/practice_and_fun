package arrays;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SearchWords {
	public List<String> findWords(char[][] board, String[] words) {
		List<String> foundWords = new ArrayList<>();
		if (board == null || board.length == 0)
			return foundWords;
		Map<Character, List<int[]>> firstCharIndexMap = new HashMap<>();
		for (String word : words) {
			char c = word.charAt(0);
			firstCharIndexMap.put(c, new ArrayList<>());
		}
		int rows = board.length, cols = board[0].length;
		for (int row = 0; row < rows; row++) {
			for (int col = 0; col < cols; col++) {
				if (firstCharIndexMap.containsKey(board[row][col]))
					firstCharIndexMap.get(board[row][col]).add(new int[] { row, col });
			}
		}

		for (String word : words) {
			if(word.equals("aabbbbabb"))
				System.out.println("This is the word to track.");
			char firstChar = word.charAt(0);
			List<int[]> indexes = firstCharIndexMap.get(firstChar);
			inner: for (int[] index : indexes) {
				boolean found = dfs(board, new int[board.length][board[0].length], index[0], index[1], word, 1);
				if (found) {
					foundWords.add(word);
					break inner;
				}
			}
		}

		return foundWords;
	}

	private boolean dfs(char[][] board, int[][] color, int row, int col, String word, int index) {
//		color[row][col] = 1;
		if (index >= word.length())
			return true;
		char c = word.charAt(index);
		if (row > 0 && color[row - 1][col] == 0 && board[row - 1][col] == c) {
			color[row - 1][col] = 1;
			return dfs(board, color, row - 1, col, word, index + 1);
		}
		if (row < board.length - 1 && color[row + 1][col] == 0 && board[row + 1][col] == c) {
			color[row + 1][col] = 1;
			return dfs(board, color, row + 1, col, word, index + 1);
		}

		if (col > 0 && board[row][col - 1] == c && color[row][col - 1] == 0) {
			color[row][col - 1] = 1;
			return dfs(board, color, row, col - 1, word, index + 1);
		}
		if (col < board[0].length - 1 && board[row][col + 1] == c && color[row][col + 1] == 0) {
			color[row][col + 1] = 1;
			return dfs(board, color, row, col + 1, word, index + 1);
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] board = new char[][] { { 'b', 'a', 'a', 'b', 'a', 'b' }, { 'a', 'b', 'a', 'a', 'a', 'a' },
				{ 'a', 'b', 'a', 'a', 'a', 'b' }, { 'a', 'b', 'a', 'b', 'b', 'a' }, { 'a', 'a', 'b', 'b', 'a', 'b' },
				{ 'a', 'a', 'b', 'b', 'b', 'a' }, { 'a', 'a', 'b', 'a', 'a', 'b' } };
		String[] words = new String[] { "bbaabaabaaaaabaababaaaaababb", "aabbaaabaaabaabaaaaaabbaaaba",
				"babaababbbbbbbaabaababaabaaa", "bbbaaabaabbaaababababbbbbaaa", "babbabbbbaabbabaaaaaabbbaaab",
				"bbbababbbbbbbababbabbbbbabaa", "babababbababaabbbbabbbbabbba", "abbbbbbaabaaabaaababaabbabba",
				"aabaabababbbbbbababbbababbaa", "aabbbbabb", "ababaababaaabbabbaabbaabbaba",
				"abaabbbaaaaababbbaaaaabbbaab", "aabbabaabaabbabababaaabbbaab", "baaabaaaabbabaaabaabababaaaa",
				"aaabbabaaaababbabbaabbaabbaa", "aaabaaaaabaabbabaabbbbaabaaa", "abbaabbaaaabbaababababbaabbb",
				"baabaababbbbaaaabaaabbababbb", "aabaababbaababbaaabaabababab", "abbaaabbaabaabaabbbbaabbbbbb",
				"aaababaabbaaabbbaaabbabbabab", "bbababbbabbbbabbbbabbbbbabaa", "abbbaabbbaaababbbababbababba",
				"bbbbbbbabbbababbabaabababaab", "aaaababaabbbbabaaaaabaaaaabb", "bbaaabbbbabbaaabbaabbabbaaba",
				"aabaabbbbaabaabbabaabababaaa", "abbababbbaababaabbababababbb", "aabbbabbaaaababbbbabbababbbb",
				"babbbaabababbbbbbbbbaabbabaa" };
		System.out.println(new SearchWords().findWords(board, words));
	}

}
