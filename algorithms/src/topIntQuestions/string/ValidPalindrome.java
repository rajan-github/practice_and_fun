package topIntQuestions.string;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * Note: For the purpose of this problem, we define empty string as valid
 * palindrome.
 * 
 * @author rajan-c
 *
 */
public class ValidPalindrome {

	public static boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		boolean isPalindrome = true;
		while (left < right && isPalindrome) {
			char leftChar = Character.toLowerCase(s.charAt(left)), rightChar = Character.toLowerCase(s.charAt(right));
			boolean isleftAlphanum = (Character.isAlphabetic(leftChar) || Character.isDigit(leftChar)),
					isrightAlphanum = (Character.isAlphabetic(rightChar) || Character.isDigit(rightChar));

			if (!isleftAlphanum)
				left++;
			else if (!isrightAlphanum)
				right--;
			else {
				if (leftChar != rightChar)
					isPalindrome = false;
				else {
					left++;
					right--;
				}
			}
		}
		return isPalindrome;
	}

	public static void main(String[] args) {
		System.out.println(isPalindrome("A man, a plan, a canal: Panama"));
	}
}
