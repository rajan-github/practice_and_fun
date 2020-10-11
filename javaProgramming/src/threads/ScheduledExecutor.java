package threads;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		Runnable task = () -> System.out.println("Hello zoo");
		Callable<String> task2 = () -> "Monkey";

		Future<?> result = service.schedule(task, 10, TimeUnit.SECONDS);
		Future<?> result2 = service.schedule(task2, 8, TimeUnit.SECONDS);
		System.out.println(result2.get());
		System.out.println(result);
	}
}
