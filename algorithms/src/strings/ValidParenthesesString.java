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
public class ValidParenthesesString {

	public static boolean checkValidString(String s) {
		if (s == null || s.length() == 0)
			return true;
		int length = s.length();
		Stack<Integer> stack1 = new Stack<>();
		Stack<Integer> stack2 = new Stack<>();
		for (int i = 0; i < length; i++) {
			char c = s.charAt(i);
			if (c == '(' && i < length - 1)
				stack1.push(i);
			else if (c == '(' && i >= length - 1)
				return false;
			else if (c == '*')
				stack2.push(i);
			else if (!stack1.empty())
				stack1.pop();
			else if (!stack2.empty())
				stack2.pop();
			else
				return false;
		}
		while (!stack1.empty() && !stack2.isEmpty()) {
			if (stack1.peek() < stack2.peek()) {
				stack1.pop();
				stack2.pop();
			} else
				return false;
		}
		return stack1.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(checkValidString(
				"(((()))())))*))())()(**(((())(()(*()((((())))*())(())*(*(()(*)))()*())**((()(()))())(*(*))*))())"));
//		System.out.println(checkValidString(""));
//		System.out.println(checkValidString("()"));
//		System.out.println(checkValidString("(())"));
		System.out.println(checkValidString("(()())"));
		System.out.println(checkValidString("(("));
		System.out.println(checkValidString("(*)"));
		System.out.println(checkValidString("(*))"));
		System.out.println(checkValidString("****))))"));
		System.out.println(checkValidString("))))))******"));
		System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
		System.out.println(checkValidString("()(*(*()()(*)(()())((*))()(()(*((*)))))*)()(()))(("));
		System.out.println(checkValidString("((*)"));
		System.out.println(checkValidString("***"));
		System.out.println(checkValidString("****()("));
	}
}
