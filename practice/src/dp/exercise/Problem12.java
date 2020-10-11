package dp.exercise;

public class Problem12 {
	public static int maxScoreb(int[] cards, int i, int j, boolean isElmoTurn) {
		if (i > j)
			return 0;
		if (isElmoTurn) {
			if (cards[i] > cards[j])
				return maxScoreb(cards, i + 1, j, !isElmoTurn);
			else
				return maxScoreb(cards, i, j - 1, !isElmoTurn);
		}
		return Math.max(maxScoreb(cards, i + 1, j, !isElmoTurn) + cards[i],
				maxScoreb(cards, i, j - 1, !isElmoTurn) + cards[j]);
	}

	public static int maxScoreD(int[] cards, int i, int j, boolean isElmoTurn) {
		if (i > j)
			return 0;
		if (isElmoTurn) {
			int oponentScoreWithi = maxScoreD(cards, i + 1, j, !isElmoTurn);
			int oponentScoreWithj = maxScoreD(cards, i, j - 1, !isElmoTurn);
			if (oponentScoreWithi > oponentScoreWithj)
				return maxScoreD(cards, i, j - 1, !isElmoTurn);
			else
				return maxScoreD(cards, i + 1, j, !isElmoTurn);
		} else {
			return Math.max(maxScoreD(cards, i + 1, j, !isElmoTurn) + cards[i],
					maxScoreD(cards, i, j - 1, !isElmoTurn) + cards[j]);
		}
	}

	public static void main(String[] args) {
		int[] cards = new int[] { 1, 16, 10, 2 };
		System.out.println(maxScoreb(cards, 0, cards.length - 1, true));
		System.out.println(maxScoreD(cards, 0, cards.length - 1, true));

		cards = new int[] { 1, 2, 10, 2 };

		System.out.println(maxScoreb(cards, 0, cards.length - 1, true));
		System.out.println(maxScoreD(cards, 0, cards.length - 1, true));
	}
}
