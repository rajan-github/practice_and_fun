package dynamicProgramming;

/**
 * We are matching pattern to the give text. We compute total changes/editions
 * required in the pattern to match pattern to the text. We have three
 * operations on pattern: insert, delete or match/substitution.
 * 
 * @author rajan-c
 *
 */
public class EditDistanceDP {

	private static EditDistanceEntry match(char c1, char c2, int preCost) {
		int cost = 1;
		if (c1 == c2)
			cost = 0;
		return new EditDistanceEntry(preCost + cost,
				cost == 0 ? EditDistanceOperations.MATCH : EditDistanceOperations.SUBSITUE);
	}

	private static EditDistanceEntry insert(char c, int preCost) {
		return new EditDistanceEntry(1 + preCost, EditDistanceOperations.INSERT);
	}

	private static EditDistanceEntry delete(char c, int preCost) {
		return new EditDistanceEntry(1 + preCost, EditDistanceOperations.DELETE);
	}

	private static EditDistanceEntry min(EditDistanceEntry a, EditDistanceEntry b, EditDistanceEntry c) {
		if (a.getCost() <= b.getCost() && a.getCost() <= c.getCost())
			return a;
		else if (b.getCost() <= c.getCost() && b.getCost() <= a.getCost())
			return b;
		return c;
	}

	public static int stringComapare(String pattern, String text) {
		if (pattern.length() == 0)
			return text.length();
		else if (text.length() == 0)
			return pattern.length();
		else {

			EditDistanceEntry[][] memory = new EditDistanceEntry[pattern.length() + 1][text.length() + 1];
			for (int i = 0; i <= text.length(); i++)
				memory[0][i] = new EditDistanceEntry(i, EditDistanceOperations.INSERT);

			for (int j = 0; j <= pattern.length(); j++)
				memory[j][0] = new EditDistanceEntry(j, EditDistanceOperations.DELETE);

			for (int i = 1; i <= pattern.length(); i++) {
				for (int j = 1; j <= text.length(); j++) {
					EditDistanceEntry delete = delete(pattern.charAt(i - 1), memory[i - 1][j].getCost());
					EditDistanceEntry insert = insert(text.charAt(j - 1), memory[i][j - 1].getCost());
					EditDistanceEntry match = match(pattern.charAt(i - 1), text.charAt(j - 1),
							memory[i - 1][j - 1].getCost());
					memory[i][j] = min(delete, insert, match);
				}
			}

			reconstructPath(memory, pattern.length(), text.length());
			System.out.println();
			return memory[pattern.length()][text.length()].getCost();
		}
	}

	/**
	 * List the operations to be performed to reconstruct the text from pattern in
	 * reverse order.
	 * 
	 * @param memory
	 * @param row
	 * @param col
	 */
	private static void reconstructPath(EditDistanceEntry[][] memory, int row, int col) {
		if (row == 0 || col == 0)
			return;
		if (memory[row][col].getOperation() == EditDistanceOperations.MATCH) {
			System.out.print("M");
			reconstructPath(memory, row - 1, col - 1);
		} else if (memory[row][col].getOperation() == EditDistanceOperations.SUBSITUE) {
			System.out.print("S");
			reconstructPath(memory, row - 1, col - 1);
		} else if (memory[row][col].getOperation() == EditDistanceOperations.INSERT) {
			System.out.print("I");
			reconstructPath(memory, row, col - 1);
		} else if (memory[row][col].getOperation() == EditDistanceOperations.DELETE) {
			System.out.print("D");
			reconstructPath(memory, row - 1, col);
		}
	}

	public static void main(String[] args) {
		String pattern = "thou should not";
		String text = "you should not";
		System.out.println(stringComapare(pattern, text));
	}
}
