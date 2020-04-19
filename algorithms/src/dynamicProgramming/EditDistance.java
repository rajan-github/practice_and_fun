package dynamicProgramming;

/**
 * We are matching pattern to the give text. We compute total changes/editions
 * required in the pattern to match pattern to the text. We have three
 * operations on pattern: insert, delete or match/substitution.
 * 
 * @author rajan-c
 *
 */
public class EditDistance {

	private static int match(char c1, char c2) {
		return c1 == c2 ? 0 : 1;
	}

	private static int indel(char c) {
		return 1;
	}

	public static int stringCompare(String pattern, String text, int i, int j) {
		if (i == 0)
			return j * indel(' ');
		else if (j == 0)
			return i * indel(' ');
		int match = stringCompare(pattern, text, i - 1, j - 1) + match(pattern.charAt(i), text.charAt(j));
		int insert = stringCompare(pattern, text, i, j - 1) + indel(text.charAt(j));
		int delete = stringCompare(pattern, text, i - 1, j) + indel(pattern.charAt(i));
		return min(match, insert, delete);
	}

	private static int min(int a, int b, int c) {
		if (a <= b && a <= c)
			return a;
		else if (b <= a && b <= c)
			return b;
		return c;
	}

	public static void main(String[] args) {
//		System.out.println(stringCompare("rajan", "klmph", 4, 4));

//		System.out.println(stringCompare("rajan", "najar", 4, 4));
		System.out.println(stringCompare("thou shalt not", "you should not", 12, 13));
	}
}
