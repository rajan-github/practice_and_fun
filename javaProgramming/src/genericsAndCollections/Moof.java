package genericsAndCollections;

/**
 * This class has only value: moofvalue. We are trying to understand the equals
 * method implementation through this simple class.
 * 
 * @author rajan-c
 *
 */
public class Moof {
	private int moofValue;

	public Moof(int val) {
		moofValue = val;
	}

	public int getMoofValue() {
		return moofValue;
	}

	public void setMoofValue(int moofValue) {
		this.moofValue = moofValue;
	}

	@Override
	public boolean equals(Object o) {
		if ((o instanceof Moof) && ((Moof) o).getMoofValue() == this.moofValue)
			return true;
		return false;
	}
}
