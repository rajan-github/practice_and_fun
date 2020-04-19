package strings;

public class LastWordLength {
	public static int lengthOfLastWord(String s) {
		if (s == null || s.length() == 0)
			return 0;
		int currentLastword = 0, index = s.length() - 1;

		while (index >= 0 && s.charAt(index) == ' ')
			index--;

		if (index >= 0) {
			while (index >= 0 && s.charAt(index) != ' ') {
				currentLastword++;
				index--;
			}

		}
		return currentLastword;
	}

	public static void main(String[] args) {
		System.out.println(lengthOfLastWord(""));
//		System.out.println(lengthOfLastWord("hello world"));
//		System.out.println(lengthOfLastWord("       "));
//
//		System.out.println(lengthOfLastWord(" r aa jan m l a"));
//		System.out.println(lengthOfLastWord(" r aa jan m l aaaaaaaa"));
//		System.out.println(lengthOfLastWord("  hello world "));
	}
}
