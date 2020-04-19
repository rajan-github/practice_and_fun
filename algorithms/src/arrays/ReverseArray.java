package arrays;

public class ReverseArray {
	public static void reverseString(char[] s) {
		if (s == null || s.length == 0)
			return;
		int start = 0, end = s.length - 1;
		while (start < end) {
			char temp = s[start];
			s[start] = s[end];
			s[end] = temp;
			end--;
			start++;
		}
	}

	public static void main(String[] args) {
		char[] s = new char[] { 'H', 'a', 'n', 'n', 'a', 'h' };
		reverseString(s);
		for (char c : s)
			System.out.print(c + ", ");
	}
}
