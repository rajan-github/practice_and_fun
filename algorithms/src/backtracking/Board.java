package backtracking;

public class Board {
	private int DIMENSION = 9;

	private int[][] content = new int[DIMENSION + 1][DIMENSION + 1];
	private int freeCount = DIMENSION * DIMENSION;
	private Point[] moves = new Point[DIMENSION * DIMENSION + 1];

	public int getDIMENSION() {
		return DIMENSION;
	}

	public void setDIMENSION(int dIMENSION) {
		DIMENSION = dIMENSION;
	}

	public int[][] getContent() {
		return content;
	}

	public void setContent(int[][] content) {
		this.content = content;
	}

	public int getFreeCount() {
		return freeCount;
	}

	public void setFreeCount(int freeCount) {
		this.freeCount = freeCount;
	}

	public Point[] getMoves() {
		return moves;
	}

	public void setMoves(Point[] moves) {
		this.moves = moves;
	}

	public void fillSquare(int x, int y, int choice) {
		content[x][y] = choice;
		freeCount--;
	}

	public void freeSquare(int x, int y) {
		content[x][y] = 0;
		freeCount++;
	}
}
