package stack.exercise;

import java.util.Stack;

/**
 * This class evaluates the postfix expression with the help of stack. It only
 * supports 4 operations("+","-","*","/"). It supports infix operations only of
 * single digit numbers.
 * 
 * @author rajan-c
 *
 */
public class Exercise4 {
	private static int calculate(int op1, int op2, char operation) {
		int result = 0;
		switch (operation) {
		case '+':
			result += (op1 + op2);
			break;
		case '-':
			result += (op1 - op2);
			break;
		case '*':
			result += (op1 * op2);
			break;
		case '/': {
			if (op2 == 0)
				throw new IllegalArgumentException();
			else
				result += (op1 / op2);
		}
		}
		return result;
	}

	public static void evaluatePostfix(String postfix) {
		Stack<Integer> stack = new Stack<>();
		if (postfix == null || postfix.length() == 0) {
			System.out.println("Invalid expression!");
			return;
		}
		int index = 0;
		while (index < postfix.length()) {
			char character = postfix.charAt(index);
			if (Character.isDigit(character)) {
				stack.push(Character.digit(character, 10));
				index += 1;
			} else if (character == '+' || character == '-' || character == '*' || character == '/') {
				if (stack.size() >= 2) {
					int op2 = stack.pop();
					int op1 = stack.pop();
					stack.push(calculate(op1, op2, character));
					index++;
				} else
					throw new IllegalArgumentException("Invalid postfix expression!");
			} else
				throw new IllegalArgumentException("Invalid character in the postfix expression: " + character);
		}
		System.out.println(stack.pop());
	}

	public static void main(String[] args) {
		String postfix = "92+3+";
		evaluatePostfix(postfix);

		postfix = "4572+-*";
		evaluatePostfix(postfix);

		postfix = "42351-+*+*";
		evaluatePostfix(postfix);
	}

}
