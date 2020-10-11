package cp3.chapter3.compleSearch;

public class Problem5 {
	public static int count(int k) {
		int ans = 0;
		outer: for (int i = 1; i <= 10000; i++) {
			for (int j = i; j <= 10000; j++) {
				double temp = (i * j * 1.0) / (i + j);
				if (temp == k)
					ans++;

				else if (temp > k)
					continue outer;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		System.out.println(count(2));
		System.out.println(count(12));
		System.out.println(count(1000));
	}
}
