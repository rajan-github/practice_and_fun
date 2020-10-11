package dp.examples;

import java.util.Arrays;

public class FreedomTrail {

}

class State {
	char[] ring;
	int index;

	public State(char[] ring, int index) {
		super();
		this.ring = ring;
		this.index = index;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + index;
		result = prime * result + Arrays.hashCode(ring);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		if (index != other.index)
			return false;
		if (!Arrays.equals(ring, other.ring))
			return false;
		return true;
	}

}
