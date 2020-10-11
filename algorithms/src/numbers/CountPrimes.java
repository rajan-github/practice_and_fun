package numbers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CountPrimes {
	public int countPrimes(int n) {
		Map<Integer, List<Integer>> primesMap = new HashMap<>();
		List<Integer> primes = new ArrayList<>();
		primes.add(2);
		primes.add(3);
		primesMap.put(3, primes);
		primesMap.put(0, new ArrayList<>());
		primesMap.put(1, new ArrayList<>());
		primesMap.put(2, new ArrayList<>());
		primesMap.get(2).add(2);
		countPrimes(n, primesMap);
		return primesMap.get(n - 1).size();
	}

	private void countPrimes(int n, Map<Integer, List<Integer>> primesMap) {
		for (int i = 4; i < n; i++) {
			List<Integer> previousPrimeList = primesMap.get(i - 1);
			boolean isPrime = true;
			primesMap.put(i, new ArrayList<>(previousPrimeList));
			for (int prime : previousPrimeList)
				if (i % prime == 0) {
					isPrime = false;
					break;
				}
			if (isPrime)
				primesMap.get(i).add(i);
		}
	}
}
