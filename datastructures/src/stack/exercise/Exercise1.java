package stack.exercise;

import java.util.Stack;

/**
 * Check for valid parentheses in O(n) time.
 * 
 * @author rajan-c
 *
 */
public class Exercise1 {

	public static boolean isValidParentheses(String expression) {
		if (expression != null && expression.length() > 0) {
			int length = expression.length();
			Stack<Character> stack = new Stack<>();
			for (int i = 0; i < length; i++) {
				if (expression.charAt(i) == '(' || expression.charAt(i) == '{' || expression.charAt(i) == '[')
					stack.push(expression.charAt(i));
				else if (stack.empty()
						&& (expression.charAt(i) == ')' || expression.charAt(i) == ']' || expression.charAt(i) == '}'))
					return false;
				else if (expression.charAt(i) == '}' && !stack.empty())
					if (stack.peek() == '{')
						stack.pop();
					else
						return false;

				else if (expression.charAt(i) == ']' && !stack.empty())
					if (stack.peek() == '[')
						stack.pop();
					else
						return false;

				else if (expression.charAt(i) == ')' && !stack.empty())
					if (stack.peek() == '(')
						stack.pop();
					else
						return false;
			}
			return stack.empty();
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(isValidParentheses("(A+B"));
		System.out.println(isValidParentheses("(A+B)"));
		System.out.println(isValidParentheses("{A+B}"));
		System.out.println(isValidParentheses("{A}+{B}"));
		System.out.println(isValidParentheses("({[]})"));
	}

}
