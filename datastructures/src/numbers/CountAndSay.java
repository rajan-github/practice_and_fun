package numbers;

/**
 * The count-and-say sequence is the sequence of integers with the first five
 * terms as following: 1 11 21 1211 etc.
 * 
 * @author rajan-c
 *
 */
public class CountAndSay {

	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		else if (n == 2)
			return "11";
		String previous = "11";
		for (int i = 3; i <= n; i++) {
			previous = countAndSay(previous);
		}
		return previous;
	}

	private static String countAndSay(String n) {
		StringBuilder output = new StringBuilder();
		for (int i = 0; i < n.length();) {
			int count = countSimilarCharacter(n, i);
			output.append(count).append(n.charAt(i));
			i += count;
		}
		return output.toString();
	}

	private static int countSimilarCharacter(String n, int index) {
		char c = n.charAt(index);
		int i = index + 1;
		while (i < n.length() && c == n.charAt(i))
			i++;
		return i - index;
	}

	public static void main(String[] args) {
		System.out.println(countAndSay(1));
		System.out.println(countAndSay(2));
		System.out.println(countAndSay(3));
		System.out.println(countAndSay(4));
		System.out.println(countAndSay(5));
		System.out.println(countAndSay(6));
		System.out.println(countAndSay(7));
		System.out.println(countAndSay(30));
	}
}
