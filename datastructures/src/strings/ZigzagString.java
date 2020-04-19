package strings;

public class ZigzagString {
	public static String zigzag(String s, int rows) {
		StringBuilder zigzag = new StringBuilder();
		if (s != null && rows > 0) {
			int length = s.length();
			char array[][] = new char[rows][length];
			boolean incrementing = true;
			int row = 0;

			for (row = 0; row < rows; row++) {
				for (int i = 0; i < length; i++) {
					array[row][i] = '\0';
				}
			}
			row = 0;
			for (int column = 0; column < length; column++) {

				if (incrementing) {
					array[row][column] = s.charAt(column);
					row = (row + 1) % rows;
					incrementing = row == (rows - 1) ? false : true;
				} else {
					array[row][column] = s.charAt(column);
					row = row > 0 ? (row - 1) : row;
					incrementing = row == 0 ? true : false;
				}

			}

			for (row = 0; row < rows; row++) {
				for (int i = 0; i < length; i++) {
					if (array[row][i] != '\0')
						zigzag.append(array[row][i]);
				}
			}
		}
		return zigzag.toString();
	}

	public static String zigzagOptimal(String s, int rows) {
		return null;
	}

	public static void main(String[] args) {
		System.out.println("Zigzag is: " + zigzag("PAYPALISHIRING", 4));
	}
}
