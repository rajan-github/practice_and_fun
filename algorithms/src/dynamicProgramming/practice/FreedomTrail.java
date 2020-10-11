package dynamicProgramming.practice;

public class FreedomTrail {
	public int findRotateSteps(String ring, String key) {
		int ringLength = ring.length();
		char[] ringArray = new char[ringLength];
		for (int i = 0; i < ringLength; i++)
			ringArray[i] = ring.charAt(i);
		return findRotateSteps(ringArray, key, 0);
	}

	private int findRotateSteps(char[] ring, String key, int currentIndex) {
		if (currentIndex >= key.length())
			return 0;
		int minSteps = Integer.MAX_VALUE;
		char keyChar = key.charAt(currentIndex);
		if (keyChar == ring[0])
			minSteps = Math.min(minSteps, 1 + findRotateSteps(ring, key, currentIndex + 1));
		else {
			rotateClockwise(ring);
			minSteps = Math.min(minSteps, 1 + findRotateSteps(ring, key, currentIndex));
			rotateAnticlockwise(ring);
			rotateAnticlockwise(ring);
			minSteps = Math.min(minSteps, 1 + findRotateSteps(ring, key, currentIndex));
			rotateClockwise(ring);
		}
		return minSteps;
	}

	private void rotateClockwise(char[] ring) {
		char newFirstChar = ring[ring.length - 1];
		for (int i = ring.length - 1; i > 0; i--)
			ring[i] = ring[i - 1];
		ring[0] = newFirstChar;
	}

	private void rotateAnticlockwise(char[] ring) {
		char newLastChar = ring[0];
		for (int i = 1; i < ring.length; i++)
			ring[i - 1] = ring[i];
		ring[ring.length - 1] = newLastChar;
	}

	public static void main(String[] args) {
		System.out.println(new FreedomTrail().findRotateSteps("godding", "gd"));
	}
}
