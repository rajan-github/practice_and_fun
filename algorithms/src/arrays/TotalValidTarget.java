package arrays;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TotalValidTarget {

	public long countValidTarget(long[] nums) {
		Set<Long> set = new HashSet<>();
		for (long item : nums)
			set.add(item);
		long count = 0;
		for (int target = -10000; target <= 10000; target++) {
			inner: for (long item : set) {
				long part2 = target - item;
				if (item != part2 && set.contains(part2)) {
					count++;
					break inner;
				}
			}
		}
		return count;
	}

	public static void main(String[] args) throws IOException {
		Path path = Paths.get(Paths.get("").toAbsolutePath() + "\\src\\arrays\\2sum.txt");
		List<String> lines = Files.readAllLines(path);
		long[] data = new long[lines.size()];
		for (int i = 0; i < data.length; i++)
			data[i] = Long.parseLong(lines.get(i));

		System.out.println(new TotalValidTarget().countValidTarget(data));
	}

}
