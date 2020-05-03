package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary matrix means that all elements are 0 or 1. For each individual row
 * of the matrix, this row is sorted in non-decreasing order.
 * 
 * Given a row-sorted binary matrix binaryMatrix, return leftmost column
 * index(0-indexed) with at least a 1 in it. If such index doesn't exist, return
 * -1.
 * 
 * You can't access the Binary Matrix directly. You may only access the matrix
 * using a BinaryMatrix interface:
 * 
 * BinaryMatrix.get(x, y) returns the element of the matrix at index (x, y)
 * (0-indexed). BinaryMatrix.dimensions() returns a list of 2 elements [n, m],
 * which means the matrix is n * m. Submissions making more than 1000 calls to
 * BinaryMatrix.get will be judged Wrong Answer. Also, any solutions that
 * attempt to circumvent the judge will result in disqualification.
 * 
 * For custom testing purposes you're given the binary matrix mat as input in
 * the following four examples. You will not have access the binary matrix
 * directly.
 * 
 * @author rajan-c
 *
 */
public class LeftMostColumnWithOne {
	public static int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
		List<Integer> dimentions = binaryMatrix.dimensions();
		int rows = dimentions.get(0) - 1, columns = dimentions.get(1) - 1;
		int minColumn = Integer.MAX_VALUE;
		while (columns >= 0 && isOneInColumn(rows, columns, binaryMatrix)) {
			if (minColumn > columns)
				minColumn = columns;
			columns--;
		}
		return minColumn < Integer.MAX_VALUE ? minColumn : -1;
	}

	private static boolean isOneInColumn(int rows, int col, BinaryMatrix binaryMatrix) {
		while (rows >= 0) {
			if (binaryMatrix.get(rows, col) == 1)
				break;
			rows--;
		}
		;
		return rows >= 0;
	}

	public static void main(String[] args) {
		BinaryMatrix matrix = new BinaryMatrix();
		System.out.println(leftMostColumnWithOne(matrix));
	}
}

class BinaryMatrix {
	int[][] matrix = { { 1, 1, 1, 1, 1 }, { 0, 0, 0, 1, 1 }, { 0, 0, 1, 1, 1 }, { 0, 0, 0, 0, 1 }, { 0, 0, 0, 0, 0 } };
	List<Integer> dimensions = new ArrayList<>();

	public int get(int x, int y) {
		return matrix[x][y];
	}

	public List<Integer> dimensions() {
		dimensions.add(matrix.length);
		dimensions.add(matrix[0].length);
		return dimensions;
	}
};