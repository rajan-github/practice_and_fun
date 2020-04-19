package strings;

import java.util.Stack;

public class LongestValidParentheses {
	public static int longestValidParentheses(String s) {
		if (s == null || s.length() == 0 || s.length() == 1)
			return 0;
		int validLength = 0;
		int maxValid = 0;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				stack.push(s.charAt(i));
			} else if (s.charAt(i) == ')' && !stack.empty()) {
				stack.pop();
				validLength += 2;
			} else if (s.charAt(i) == ')' && stack.empty()) {
				if (maxValid < validLength) {
					maxValid = validLength;
				}
				validLength = 0;
			}
		}
		if (validLength > maxValid)
			maxValid = validLength;
		return maxValid;
	}

	public static void main(String[] args) {
//		System.out.println(longestValidParentheses("(()"));
//		System.out.println(longestValidParentheses("()"));
		System.out.println(longestValidParentheses("()(()"));
		System.out.println(longestValidParentheses("()(())((()))"));
//		System.out.println(longestValidParentheses("()(())((())))"));
//		System.out.println(longestValidParentheses("()(())(((()))"));
//		System.out.println(longestValidParentheses("(()(())((())))"));
		System.out.println(longestValidParentheses(")()())"));
		System.out.println(longestValidParentheses(")(()()())"));
	}
}
