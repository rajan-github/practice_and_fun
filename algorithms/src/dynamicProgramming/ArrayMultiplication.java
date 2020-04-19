package dynamicProgramming;

public class ArrayMultiplication {
	public static int[][] multication(int[][] a, int[][] b) {
		if (a.length > 0 && b.length > 0) {
			if (a[0].length == b.length) {
				int[][] c = new int[a.length][b[0].length];
				for (int i = 0; i < a.length; i++) {
					for (int j = 0; j < b[0].length; j++) {
						int sum = 0;
						for (int k = 0; k < b.length; k++) {
							sum += a[i][k] * b[k][j];
						}
						c[i][j] = sum;
					}
				}
				return c;
			} else
				throw new IllegalArgumentException("Incompatible arrays for multiplication.");
		}
		throw new IllegalArgumentException("Invalid size of the array!");
	}

	public static int[][] findParenthesis(int[] p) {
		if (p.length > 2) {
			int[][] multiplications = new int[p.length][p.length];
			for (int i = 0; i < p.length; i++) {
				for (int k = 0; k < p.length; k++) {
					if (i == k)
						multiplications[i][k] = 0;
				}
			}
			for (int chainLength = 2; chainLength < p.length; chainLength++) {
				for (int i = 0; i < p.length - chainLength; i++) {
					int j = i + chainLength - 1;
					int cost = Integer.MAX_VALUE;
					for (int k = i; k < j; k++) {
						int temp = multiplications[i][k] + multiplications[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
						if (temp < cost)
							cost = temp;
					}
					multiplications[i][j] = cost;
				}
			}
			return multiplications;
		}
		throw new IllegalArgumentException("Invalid input!");

	}

	public static void display(int[][] array) {
		int rows = array.length;
		if (rows > 0) {
			int column = array[0].length;
			for (int i = 0; i < rows; i++) {
				for (int k = 0; k < column; k++)
					System.out.print(array[i][k] + ", ");
			}
		}
	}

	public static void main(String[] args) {
//		int[][] array1 = { { 1, 2, 3 }, { 1, 2, 3 }, { 1, 2, 3 } };
		int[] p = { 30, 35, 15, 5, 10, 20, 25 };
		display(findParenthesis(p));
//		int[][] result = findParenthesis(p);
//		System.out.println(result[0][p.length]);
	}

}
