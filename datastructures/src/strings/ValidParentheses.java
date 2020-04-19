package strings;

import java.util.Stack;

public class ValidParentheses {
	public boolean isValid(String s) {
		boolean valid = true;
		if (s != null && s.length() % 2 != 0)
			valid = false;
		else if (s != null && s.length() > 0) {
			Stack<Character> stack = new Stack<>();
			int length = s.length();
			for (int i = 0; i < length; i++) {
				char temp = s.charAt(i);
				if (temp == '(' || temp == '{' || temp == '[') {
					stack.push(temp);
				} else if (!stack.isEmpty()) {
					char temp2 = stack.pop();
					if ((temp == ')' && temp2 == '(') || (temp == '}' && temp2 == '{')
							|| (temp == ']' && temp2 == '[')) {
						continue;
					} else {
						valid = false;
						break;
					}
				} else {
					valid = false;
					break;
				}
			}
			if (!stack.isEmpty())
				valid = false;
		}
		return valid;
	}

	public static void main(String[] args) {
		ValidParentheses paran = new ValidParentheses();
		System.out.println(paran.isValid(""));
		System.out.println(paran.isValid("]]"));
		System.out.println(paran.isValid("["));
		System.out.println(paran.isValid("{{"));
		System.out.println(paran.isValid("}}"));
		System.out.println(paran.isValid(""));
//		System.out.println(paran.isValid("[]"));
//		System.out.println(paran.isValid("[)"));
//		System.out.println(paran.isValid("()()((()))"));
//		System.out.println(paran.isValid("{([])}"));
//		System.out.println(paran.isValid("{{{([])}})"));
	}
}
