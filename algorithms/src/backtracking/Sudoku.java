package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Sudoku {

	private static final int DIMENSION = 9;

	private static List<Integer> constructCandidates(Board board) {
		boolean[] possible = new boolean[DIMENSION + 1];
		Point nextPoint = nextSquare(board);
		findPossible(nextPoint, board, possible);
		List<Integer> choices = new ArrayList<>();
		for (int i = 1; i < possible.length; i++) {
			if (possible[i]) {
				choices.add(i);
			}
		}
		return choices;
	}

	private static void findPossible(Point point, Board board, boolean[] possible) {
		int row = point.getX();
		int column = point.getY();

		for (int i = 0; i < possible.length; i++)
			possible[i] = true;

		for (int i = 0; i <= DIMENSION; i++) {
			if (board.getContent()[row][i] > 0) {
				possible[board.getContent()[row][i]] = false;
			}
		}

		for (int i = 0; i <= DIMENSION; i++) {
			if (board.getContent()[i][column] > 0) {
				possible[board.getContent()[i][column]] = false;
			}
		}

		Point squareCorner = getSquareCornerPoint(point);
		for (int i = squareCorner.getX(); i < squareCorner.getX() + 3; i++) {
			for (int j = squareCorner.getY(); j < squareCorner.getY() + 3; j++) {
				if (board.getContent()[i][j] > 0) {
					possible[board.getContent()[i][j]] = false;
				}
			}
		}
	}

	private static Point getSquareCornerPoint(Point point) {
		int x = point.getX();
		int y = point.getY();
		for (int i = 1; i <= 9; i += 3) {
			if (x >= i && x < i + 3) {
				x = i;
				break;
			}
		}

		for (int i = 1; i <= 9; i += 3) {
			if (y >= i && y < i + 3) {
				y = i;
				break;
			}
		}
		return new Point(x, y);
	}

	private static Point nextSquare(Board board) {
		Point nextPoint = new Point();
		for (int i = 1; i <= DIMENSION; i++) {
			for (int j = 1; j <= DIMENSION; j++) {
				if (board.getContent()[i][j] <= 0) {
					nextPoint.setX(i);
					nextPoint.setY(j);
					break;
				}
			}
		}
		return nextPoint;
	}

	public static void solveSudoku(Board board) {
		if (board.getFreeCount() == 0) {
			processSolution(board);
			return;
		}
		List<Integer> choices = constructCandidates(board);
		Point freePoint = nextSquare(board);
		for (int item : choices) {
			makeMove(board, item, freePoint);
			solveSudoku(board);
			unmakeMove(board, freePoint);
		}
	}

	public static void makeMove(Board board, int item, Point freePoint) {
		board.fillSquare(freePoint.getX(), freePoint.getY(), item);
	}

	public static void unmakeMove(Board board, Point point) {
		board.freeSquare(point.getX(), point.getY());
	}

	private static void processSolution(Board board) {
		for (int i = 1; i <= DIMENSION; i++) {
			System.out.print("[ ");
			for (int j = 1; j <= DIMENSION; j++) {
				System.out.print(board.getContent()[i][j] + ", ");
			}
			System.out.println("]");
		}
	}

	public static void main(String[] args) {
		Board board = new Board();
		board.fillSquare(2, 1, 1);
		board.fillSquare(3, 1, 9);
		board.fillSquare(2, 2, 3);
		board.fillSquare(3, 3, 5);

		board.fillSquare(1, 5, 8);
		board.fillSquare(1, 6, 4);
		board.fillSquare(2, 5, 5);
		board.fillSquare(3, 5, 1);
		board.fillSquare(3, 6, 3);

		board.fillSquare(1, 9, 3);
		board.fillSquare(2, 8, 9);
		board.fillSquare(2, 9, 4);
		board.fillSquare(3, 8, 7);

		board.fillSquare(4, 1, 4);
		board.fillSquare(5, 3, 3);
		board.fillSquare(6, 1, 7);
		board.fillSquare(6, 2, 5);

		board.fillSquare(4, 5, 9);
		board.fillSquare(4, 6, 6);
		board.fillSquare(5, 4, 7);
		board.fillSquare(6, 5, 3);

		board.fillSquare(5, 9, 1);
		board.fillSquare(6, 7, 4);
		board.fillSquare(6, 8, 6);
		board.fillSquare(6, 9, 9);

		board.fillSquare(7, 1, 5);
		board.fillSquare(7, 3, 4);
		board.fillSquare(8, 1, 3);
		board.fillSquare(8, 2, 6);
		board.fillSquare(9, 2, 2);

		board.fillSquare(7, 5, 7);
		board.fillSquare(7, 6, 8);
		board.fillSquare(8, 5, 2);
		board.fillSquare(8, 6, 9);

		board.fillSquare(7, 8, 2);
		board.fillSquare(8, 8, 5);
		board.fillSquare(9, 7, 3);
		board.fillSquare(9, 9, 7);

		solveSudoku(board);
	}
}
