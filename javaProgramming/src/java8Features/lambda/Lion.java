package java8Features.lambda;

public class Lion implements Run {

	@Override
	public boolean isQuadruped() {
		return false;
	}

	@Override
	public boolean canHuntWhileRunning() {
		return false;
	}

	@Override
	public double getMaxSpeed() {
		return 0;
	}

}
