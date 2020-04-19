package strings;

import java.util.Stack;

/**
 * Given two strings S and T, return if they are equal when both are typed into
 * empty text editors. # means a backspace character. Input: S = "ab#c", T =
 * "ad#c" Output: true Explanation: Both S and T become "ac".
 * 
 * @author rajan-c
 *
 */
public class BackspaceStringComparison {
	public static boolean backspaceCompare(String S, String T) {
		return removeBackspaced(S).equals(removeBackspaced(T));
	}

	private static String removeBackspaced(String S) {
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < S.length(); i++) {
			char c = S.charAt(i);
			if (c == '#' && !stack.isEmpty())
				stack.pop();
			else if (c != '#')
				stack.push(S.charAt(i));
		}
		StringBuilder s1 = new StringBuilder();
		while (!stack.empty())
			s1.append(stack.pop());
		return s1.toString();
	}

	public static void main(String[] args) {
		System.out.println(backspaceCompare("ab#c", "ad#c"));
		System.out.println(backspaceCompare("ab##", "c#d#"));
		System.out.println(backspaceCompare("a##c", "#a#c"));
		System.out.println(backspaceCompare("a#c", "b"));
	}
}
