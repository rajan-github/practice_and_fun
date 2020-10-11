package java8Features.lambda;

public interface Run extends Walk {
	public abstract boolean canHuntWhileRunning();

	abstract double getMaxSpeed();
}