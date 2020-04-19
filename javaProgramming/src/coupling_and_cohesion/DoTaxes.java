package coupling_and_cohesion;

public class DoTaxes {
	float rate;

	float doColorado() {
		SalesTaxRates str = new SalesTaxRates();
		rate = str.salesRate; // ouch this should be a method call like: rate=str.getSalesRate("co");
		// do stuff with rate
		return -1;
	}
}

class SalesTaxRates {
	public float salesRate; // should be private
	public float adjustedSalesRate; // should be private

	public float getSalesRate(String region) {
		salesRate = new DoTaxes().doColorado(); // ouch again, do region based calculations
		return adjustedSalesRate;
	}
}
