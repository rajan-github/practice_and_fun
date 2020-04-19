package exceptions.exercise;

public class Propagate {
	public static void main(String[] args) {
		try {
			System.out.println(reverse("rajan"));
		} catch (IllegalArgumentException e) {
			System.out.println(e);
		} finally {
			System.out.println("This is the end of the main method.");
		}
	}

	private static String reverse(String s) throws IllegalArgumentException {
		if (s != null && s.length() > 0) {
			StringBuilder reversed = new StringBuilder();
			int i = s.length() - 1;
			while (i >= 0) {
				reversed.append(s.charAt(i--));
			}
			return reversed.toString();
		} else {
			throw new IllegalArgumentException("Invalid string to reverse!");
		}
	}
}
