package threads;

import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class BlockingQueueExample {
	public static void blockingQueueExaple() throws InterruptedException {
		Queue<Integer> queue = new LinkedBlockingQueue<>();
		queue.offer(4);
		System.out.println(queue.poll());
		BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
		blockingQueue.offer(3, 4, TimeUnit.MILLISECONDS);

		System.out.println(blockingQueue.poll(4, TimeUnit.MICROSECONDS));
	}

	public static void blockingDequeueExample() throws InterruptedException {
		BlockingDeque<Integer> deque = new LinkedBlockingDeque<>();
		deque.offerFirst(5, 2, TimeUnit.SECONDS);
		System.out.println(deque.pollFirst());
	}

	public static void main(String[] args) throws InterruptedException {
		blockingQueueExaple();
		blockingDequeueExample();
	}
}
