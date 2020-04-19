package stack.exercise;

/**
 * Given an array of characters formed with a’s and b’s. The string is marked
 * with special character X which represents the middle of the list (for
 * example: ababa...ababXbabab…..baaa). Check whether the string is palindrome.
 * 
 * @author rajan-c
 *
 */
public class Exercise8 {

	public static boolean isPalindrome(String string) {
		boolean isPalindrome = true;
		if (string == null || string.length() == 0)
			return isPalindrome;
		int right = 0;
		while (right < string.length() && string.charAt(right) != 'X')
			right++;
		right += 1;
		int middle = right - 2;
		while (middle >= 0 && right < string.length() && string.charAt(middle) == string.charAt(right)) {
			middle--;
			right++;
		}
		if (middle >= 0 || right < string.length())
			isPalindrome = false;

		return isPalindrome;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("ababaXababa"));
		System.out.println(isPalindrome("aXa"));
		System.out.println(isPalindrome("baXab"));
		System.out.println(isPalindrome("X"));
		System.out.println(isPalindrome("Xa"));
		System.out.println(isPalindrome("bXa"));
		System.out.println(isPalindrome("bXb"));
	}

}
