package backtracking.practice;

/**
 * In order to transform one source string of text xOE1: : m to a target string
 * yOE1: : n, we can perform various transformation operations. Our goal is,
 * given x and y, to produce a series of transformations that change x to y. We
 * use an array ´—assumed to be large enough to hold all the characters it will
 * need—to hold the intermediate results.
 * 
 * @author rajan-c
 *
 */
public class EditDistance {
	enum Operation {
		COPY(1), REPLACE(1), DELETE(1), INSERT(1), TWIDDLE(2), KILL(1);

		private int cost;

		Operation(int cost) {
			this.cost = cost;
		}

		public int getCost() {
			return cost;
		}

		public void setCost(int cost) {
			this.cost = cost;
		}
	}

	public static void editDistance(char[] text, char[] pattern) {
		char[] aux = new char[pattern.length];

		CostEntry[][] memory = new CostEntry[text.length + 1][pattern.length + 1];
		for (int row = 0; row < memory.length; row++)
			for (int col = 0; col < memory[0].length; col++)
				memory[row][col] = null;

		for (int row = 0; row < memory.length; row++)
			memory[row][0] = new CostEntry(Operation.DELETE, row * Operation.DELETE.getCost());
		for (int col = 0; col < memory[0].length; col++)
			memory[0][col] = new CostEntry(Operation.INSERT, col * Operation.INSERT.getCost());
		editDistance(text, aux, pattern, 0, 0, memory);
		display(memory);
		printOperations(memory);
//		if()
//		return memory[1][1].costsofar;
	}

	private static void printOperations(CostEntry[][] array) {
		int rows = array.length, cols = array[0].length, row = 1, col = 1;
		while (row < rows && col < cols) {
			System.out.println(array[row][col].operation);
			switch (array[row][col].operation) {
			case COPY: {
				row++;
				col++;
				break;
			}
			case REPLACE: {
				row++;
				col++;
				break;
			}
			case TWIDDLE: {
				row += 2;
				col += 2;
				break;
			}
			case DELETE: {
				row += 1;
				break;
			}
			case INSERT: {
				col += 1;
				break;
			}
			case KILL: {
				row = rows;
				col = cols;
				System.out.println(Operation.KILL);
				break;
			}
			}
		}
	}

	private static void display(CostEntry[][] array) {
		for (CostEntry[] row : array) {
			System.out.print("[");
			for (CostEntry item : row) {
				if (item != null)
					System.out.print(item.operation + ":" + item.costsofar + ", ");
			}
			System.out.println("]");
		}
	}

	public static CostEntry editDistance(char[] text, char[] aux, char[] pattern, int i, int j, CostEntry[][] memory) {
		if (i >= text.length) {
			int diff = (pattern.length - j), cost = 0;
			for (int k = 0; k < diff; k++)
				cost += (insert(aux, j + k, pattern[j + k]));
			memory[i][j + 1] = new CostEntry(Operation.INSERT, cost);
			return memory[i][j + 1];
		}

		else if (j >= pattern.length) {
			int killCost = Operation.KILL.getCost();
			int deleteCost = (text.length - i) * Operation.DELETE.getCost();
			memory[i + 1][j] = (killCost < deleteCost) ? new CostEntry(Operation.KILL, killCost)
					: new CostEntry(Operation.DELETE, deleteCost);
			return memory[i + 1][j];
		}

		if (memory[i + 1][j + 1] != null)
			return memory[i + 1][j + 1];

		Operation minOperation = Operation.COPY;
		int minCost = Integer.MAX_VALUE, currentCost = Integer.MAX_VALUE;
		char temp;
		if (pattern[j] == text[i]) {
			temp = aux[j];
			currentCost = copy(text, aux, i, j) + editDistance(text, aux, pattern, i + 1, j + 1, memory).costsofar;
			aux[j] = temp;
		}
		if (minCost > currentCost) {
			minOperation = Operation.COPY;
			minCost = currentCost;
		}
		temp = aux[j];
		currentCost = replace(pattern[j], aux, j) + editDistance(text, aux, pattern, i + 1, j + 1, memory).costsofar;
		aux[j] = temp;
		if (minCost > currentCost) {
			minOperation = Operation.REPLACE;
			minCost = currentCost;
		}
		currentCost = delete() + editDistance(text, aux, pattern, i + 1, j, memory).costsofar;
		if (minCost > currentCost) {
			minOperation = Operation.DELETE;
			minCost = currentCost;
		}
		temp = aux[j];
		currentCost = insert(aux, j, pattern[j]) + editDistance(text, aux, pattern, i, j + 1, memory).costsofar;
		aux[j] = temp;
		if (minCost > currentCost) {
			minOperation = Operation.INSERT;
			minCost = currentCost;
		}

		if (i < text.length - 2 && j < aux.length - 2) {
			temp = aux[j];
			char temp1 = aux[j + 1];
			currentCost = twiddle(text, aux, i, j) + editDistance(text, aux, pattern, i + 2, j + 2, memory).costsofar;
			aux[j] = temp;
			aux[j + 1] = temp1;
		}
		if (minCost > currentCost) {
			minOperation = Operation.TWIDDLE;
			minCost = currentCost;
		}

		currentCost = kill() + editDistance(text, aux, pattern, text.length, j, memory).costsofar;
		if (minCost > currentCost) {
			minOperation = Operation.KILL;
			minCost = currentCost;
		}
		memory[i + 1][j + 1] = new CostEntry(minOperation, minCost);
		return memory[i + 1][j + 1];
	}

	private static int copy(char[] x, char[] z, int i, int j) {
		z[j] = x[i];
		return Operation.COPY.getCost();
	}

	private static int replace(char c, char[] z, int j) {
		z[j] = c;
		return Operation.REPLACE.getCost();
	}

	private static int delete() {
		return Operation.DELETE.getCost();
	}

	private static int kill() {
		return Operation.KILL.getCost();
	}

	private static int twiddle(char[] x, char[] z, int i, int j) {
		z[j] = x[i + 1];
		z[j + 1] = x[i];
		return Operation.TWIDDLE.getCost();
	}

	private static int insert(char[] z, int j, char c) {
		z[j] = c;
		return Operation.INSERT.getCost();
	}

	static class CostEntry {
		private Operation operation;
		private int costsofar;

		public CostEntry(Operation operation, int costsofar) {
			super();
			this.operation = operation;
			this.costsofar = costsofar;
		}

		public Operation getOperation() {
			return operation;
		}

		public void setOperation(Operation operation) {
			this.operation = operation;
		}

		public int getCostsofar() {
			return costsofar;
		}

		public void setCostsofar(int costsofar) {
			this.costsofar = costsofar;
		}
	}

	public static void main(String[] args) {
//		editDistance(new char[] { 'a', 'l', 'g', 'o', 'r', 'i', 't', 'h', 'm' },
//				new char[] { 'a', 'l', 't', 'r', 'u', 'i', 's', 't', 'i', 'c' });

		editDistance(new char[] { 'a', 'l', 't', 'i' }, new char[] { 'a', 't', 'i' });
//		System.out.println();
	}
}
