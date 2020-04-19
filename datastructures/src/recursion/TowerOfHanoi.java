package recursion;

public class TowerOfHanoi {
	public void towerOfHanoi(int n, char fromPeg, char toPeg, char auxPeg) {
		if (n == 1)
			System.out.println("Moving disk: " + n + "from " + fromPeg + " to " + toPeg + "\n");
		else {
			towerOfHanoi(n - 1, fromPeg, auxPeg, toPeg);
			towerOfHanoi(1, fromPeg, toPeg, auxPeg);
			towerOfHanoi(n - 1, auxPeg, toPeg, fromPeg);
		}
	}

	public static void main(String[] args) {
		new TowerOfHanoi().towerOfHanoi(3, 'A', 'C', 'B');
	}
}
