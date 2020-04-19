package strings;

import java.util.Stack;

/**
 * Given a string containing only three types of characters: '(', ')' and '*',
 * write a function to check whether this string is valid. We define the
 * validity of a string by these rules:
 * 
 * Any left parenthesis '(' must have a corresponding right parenthesis ')'. Any
 * right parenthesis ')' must have a corresponding left parenthesis '('. Left
 * parenthesis '(' must go before the corresponding right parenthesis ')'. '*'
 * could be treated as a single right parenthesis ')' or a single left
 * parenthesis '(' or an empty string. An empty string is also valid.
 * 
 * @author rajan-c
 *
 */
public class ValidateParenthesesBacktracking {
	public static boolean checkValidString(String s) {
		if (s == null || s.length() == 0)
			return true;
		char[] parenArray = s.toCharArray();
		if (!isParenthesesValid(parenArray))
			return validateParentheses(0, parenArray);
		return true;
	}

	private static boolean validateParentheses(int k, char[] parentheses) {
		if (k >= parentheses.length)
			return isParenthesesValid(parentheses);
		boolean isValid = false;
		for (int i = k; i < parentheses.length && !isValid; i++) {
			if (parentheses[i] == '*') {
				parentheses[i] = '\0';
				isValid = validateParentheses(i + 1, parentheses);
				if (!isValid) {
					parentheses[i] = ')';
					isValid = validateParentheses(i + 1, parentheses);
				}
				if (!isValid) {
					parentheses[i] = '(';
					isValid = validateParentheses(i + 1, parentheses);
				}
				if (!isValid)
					parentheses[i] = '*';
			}
		}
		return isValid ? isValid : isParenthesesValid(parentheses);
	}

	private static boolean isParenthesesValid(char[] parentheses) {
		if (parentheses.length == 0)
			return true;
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < parentheses.length; i++) {
			if (parentheses[i] != '\0') {
				if (parentheses[i] == '(')
					stack.push('(');
				else if (parentheses[i] == ')' && !stack.isEmpty())
					stack.pop();
				else
					return false;
			}
		}
		return stack.isEmpty();
	}
}
