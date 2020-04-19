package designPatterns.singleton;

import java.util.HashSet;
import java.util.Set;

/**
 * Let's suppose we are going to put on a show. We have one performance of this
 * show and we only have a few seats in the theater. This is singleton pattern
 * implementation with the help of enum.
 * 
 * @author rajan-c
 *
 */
public enum ShowEnum {
	INSTANCE;

	private Set<String> availableSeats;

	private ShowEnum() {
		availableSeats = new HashSet<>();
		availableSeats.add("1A");
		availableSeats.add("1B");
	}

	public boolean bookSeat(String seat) {
		return availableSeats.remove(seat);
	}

	public static void main(String[] args) {
		ticketAgentBooks("1A");
		ticketAgentBooks("1A");
	}

	private static void ticketAgentBooks(String seat) {
		ShowEnum show = ShowEnum.INSTANCE;
		System.out.println(show.bookSeat(seat));
	}
}
