package java8Features.lambda;

import java.util.Optional;

public class OptionalUsages {
	public static Optional<Double> average(int... scores) {
		if (scores.length == 0)
			return Optional.empty();
		int sum = 0;
		for (int score : scores)
			sum += score;
		return Optional.of((double) sum / scores.length);
	}

	public static void main(String[] args) {
		Optional<Double> opt = average(90, 100);
		if (opt.isPresent())
			System.out.println(opt.get());
		Optional<Double> average = average();
		System.out.println(average.get());
	}
}
