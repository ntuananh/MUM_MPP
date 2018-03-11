package main.java.entity;

public class Package extends Shipment {
	private double dimension1;
	private double dimension2;
	private double dimension3;
	private double weight;

	public Package(double dimension1, double dimension2, double dimension3, double weight) {
		super();
		this.dimension1 = dimension1;
		this.dimension2 = dimension2;
		this.dimension3 = dimension3;
		this.weight = weight;
		this.feeCalculator = new DimensionCalc();
	}

	public double getDimension1() {
		return dimension1;
	}

	public double getDimension2() {
		return dimension2;
	}

	public double getDimension3() {
		return dimension3;
	}

	public double getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Shipment infomation");
		// sb.append("\tId: " + this.getId() + ", sent from " +
		// this.getFromLocation().getName() + " to "
		// + this.getToLocation().getName());
		return sb.toString();
	}

}
