package dynamicProgramming;

public class EditDistanceEntry {
	private int cost;
	private EditDistanceOperations operation;

	public EditDistanceEntry(int cost, EditDistanceOperations operation) {
		this.cost = cost;
		this.operation = operation;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public EditDistanceOperations getOperation() {
		return operation;
	}

	public void setOperation(EditDistanceOperations operation) {
		this.operation = operation;
	}

}
