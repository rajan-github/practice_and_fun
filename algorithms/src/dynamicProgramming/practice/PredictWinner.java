package dynamicProgramming.practice;

/**
 * Given an array of scores that are non-negative integers. Player 1 picks one
 * of the numbers from either end of the array followed by the player 2 and then
 * player 1 and so on. Each time a player picks a number, that number will not
 * be available for the next player. This continues until all the scores have
 * been chosen. The player with the maximum score wins.
 * 
 * Given an array of scores, predict whether player 1 is the winner. You can
 * assume each player plays to maximize his score.
 * 
 * @author rajan-c
 *
 */
public class PredictWinner {
	public static boolean PredictTheWinner(int[] nums) {
		if (nums == null)
			return false;
		else if (nums.length <= 1)
			return true;
		int[][][] memory = new int[nums.length][nums.length][2];
		for (int i = 0; i < memory.length; i++) {
			for (int j = 0; j < memory[0].length; j++) {
				memory[i][j] = null;
				memory[i][j] = null;
			}
		}
		int[] playerSum = predictTheWinner(nums, 0, nums.length - 1, true, memory);
		return playerSum[0] >= playerSum[1];
	}

	private static int[] predictTheWinner(int[] nums, int leftIndex, int rightIndex, boolean isFirstPlayerTurn,
			int memory[][][]) {
		if (leftIndex > rightIndex)
			return new int[2];
		if (memory[leftIndex][rightIndex] != null)
			return memory[leftIndex][rightIndex];
		int[] playerSum = new int[2];
		int[] leftIndexSum = predictTheWinner(nums, leftIndex + 1, rightIndex, !isFirstPlayerTurn, memory);
		int[] rightIndexSum = predictTheWinner(nums, leftIndex, rightIndex - 1, !isFirstPlayerTurn, memory);
		if (isFirstPlayerTurn) {
			if (leftIndexSum[0] + nums[leftIndex] > rightIndexSum[0] + nums[rightIndex]) {
				playerSum[1] += leftIndexSum[1];
				playerSum[0] += leftIndexSum[0] + nums[leftIndex];
			} else {
				playerSum[1] += rightIndexSum[1];
				playerSum[0] += rightIndexSum[0] + nums[rightIndex];
			}

		} else {
			if (leftIndexSum[1] + nums[leftIndex] > rightIndexSum[1] + nums[rightIndex]) {
				playerSum[0] += leftIndexSum[0];
				playerSum[1] += leftIndexSum[1] + nums[leftIndex];
			} else {
				playerSum[0] += rightIndexSum[0];
				playerSum[1] += rightIndexSum[1] + nums[rightIndex];
			}

		}
		memory[leftIndex][rightIndex] = playerSum;
		return playerSum;
	}

	public static void main(String[] args) {
		System.out.println(PredictTheWinner(new int[] { 1, 5, 2 }));
		System.out.println(PredictTheWinner(new int[] { 1, 5, 233, 7 }));
	}

}
