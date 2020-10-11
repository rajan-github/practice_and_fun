package cp3.chapter3.compleSearch;

public class Problem6 {
	public static double longestNeclace(int totalVolume, double consumed) {
		int totalNeclace = 0;
		double maxDiameter = 0;
		int discs = 0;

		while (true) {
			totalNeclace++;
			double newDiameter = computeDiameter(totalVolume / totalNeclace, consumed);
			if (newDiameter == 0)
				break;
			if (maxDiameter < newDiameter * totalNeclace) {
				discs = totalNeclace;
			}

		}
		return discs;
	}

	private static double computeDiameter(int totalVolume, double consumed) {
		if (totalVolume <= consumed)
			return 0;
		return Math.sqrt(totalVolume - consumed) * 0.3;
	}

	public static void main(String[] args) {
		System.out.println(longestNeclace(10, 1));
		System.out.println(longestNeclace(10, 2));
		System.out.println(longestNeclace(0, 0));
	}
}
