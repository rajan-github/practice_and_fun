package dp.examples;

import java.util.HashMap;
import java.util.Map;

public class BookShelves {
	public static int minHeightShelves(int[][] books, int shelfWidth) {
		return minHeightShelves(books, shelfWidth, 0, 0, 0, new HashMap<>());
	}

	private static int minHeightShelves(int[][] books, int shelfWidth, int index, int currentHeight, int currentWidth,
			Map<State1, Integer> stateMap) {
		if (index >= books.length)
			return 0;
		State1 state = new State1(index, currentWidth, currentHeight);

//		if (stateMap.containsKey(state))
//			return stateMap.get(state);

		int minHeight = 0;
		if (currentWidth + books[index][0] <= shelfWidth)
			minHeight += Math.min(
					Math.max(books[index][1], currentHeight) + minHeightShelves(books, shelfWidth, index + 1,
							Math.max(books[index][1], currentHeight), currentWidth + books[index][0], stateMap),
					books[index][1] + minHeightShelves(books, shelfWidth, index + 1, books[index][1], books[index][0],
							stateMap));

		else
			minHeight += books[index][1]
					+ minHeightShelves(books, shelfWidth, index + 1, books[index][1], books[index][0], stateMap);

		stateMap.put(state, minHeight);
		return minHeight;
	}

	public static void main(String[] args) {
		int[][] books = { { 1, 1 }, { 2, 3 }, { 2, 3 }, { 1, 1 }, { 1, 1 }, { 1, 1 }, { 1, 2 } };
		System.out.println(minHeightShelves(books, 4));
	}

}

class State1 {
	int index;
	int currentWidth;
	int currentHeight;

	public State1(int index, int currentWidth, int currentHeight) {
		super();
		this.index = index;
		this.currentWidth = currentWidth;
		this.currentHeight = currentHeight;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentHeight;
		result = prime * result + currentWidth;
		result = prime * result + index;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State1 other = (State1) obj;
		if (currentHeight != other.currentHeight)
			return false;
		if (currentWidth != other.currentWidth)
			return false;
		if (index != other.index)
			return false;
		return true;
	}

}
