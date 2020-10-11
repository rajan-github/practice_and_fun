package java8Features.streams;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class PrimitivePipelines {
	public static void main(String[] args) {
		IntStream intStream = IntStream.of(1, 2, 3);
		OptionalDouble avg = intStream.average();
		System.out.println(avg.getAsDouble());

		LongStream longs = LongStream.of(5, 10);
		long sum = longs.sum();
		System.out.println(sum);

		DoubleStream doubles = DoubleStream.generate(() -> Math.PI);
		OptionalDouble min = doubles.min();
		System.out.println(min.orElse(-1));
	}
}
