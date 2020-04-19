package numbers;

public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		if (x < 0)
			return false;
		else if (x < 10)
			return true;
		else {
			int reverse = 0;
			while (reverse < x) {
				reverse = reverse * 10 + (x % 10);
				x = x / 10;
			}
			if (reverse == x || (reverse > 9 && reverse / 10 == x))
				return true;
			return false;
		}
	}

	public static void main(String[] args) {
		PalindromeNumber number = new PalindromeNumber();
//		System.out.println(number.isPalindrome(1));
//		System.out.println(number.isPalindrome(-19991));
		System.out.println(number.isPalindrome(0000001));
	}
}
