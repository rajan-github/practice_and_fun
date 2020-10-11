package weeklyChallenge.one_ninety_three;

import java.util.HashMap;
import java.util.Map;

public class Problem2 {
	public static int findLeastNumOfUniqueInts(int[] arr, int k) {
		Map<Integer, Integer> frequencyMap = new HashMap<>();

		for (int item : arr) {
			if (!frequencyMap.containsKey(item))
				frequencyMap.put(item, 1);
			else
				frequencyMap.replace(item, frequencyMap.get(item)+1);
		}

		while (k > 0) {
			int number = findLeastFrequencyNumber(frequencyMap);
			if (frequencyMap.containsKey(number)) {
				int freq = frequencyMap.get(number);
				if (freq > 1)
					frequencyMap.replace(number, freq - 1);
				else
					frequencyMap.remove(number);
				k--;
			}
		}
		return frequencyMap.size();
	}

	private static int findLeastFrequencyNumber(Map<Integer, Integer> frequency) {
		int leastNumber = -1, leastFrequency = Integer.MAX_VALUE;
		for (Map.Entry<Integer, Integer> entry : frequency.entrySet()) {
			if (entry.getValue() < leastFrequency) {
				leastNumber = entry.getKey();
				leastFrequency = entry.getValue();
			}
		}
		return leastNumber;
	}

	public static void main(String[] args) {
		System.out.println(findLeastNumOfUniqueInts(new int[] { 4, 3, 1, 1, 3, 3, 2 }, 3));
	}
}
