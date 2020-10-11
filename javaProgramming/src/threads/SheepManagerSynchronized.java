package threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SheepManagerSynchronized {
	private int sheepCount = 0;

	private synchronized void incrementAndReport() {
		System.out.println((++sheepCount) + "");
	}

	public static void main(String[] args) {
		ExecutorService service = null;
		try {
			SheepManagerSynchronized manager = new SheepManagerSynchronized();
			service = Executors.newFixedThreadPool(20);
			for (int i = 0; i < 10; i++)
				service.submit(() -> manager.incrementAndReport());
		} finally {
			if (service != null)
				service.shutdown();
		}
	}

}
