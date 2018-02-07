package F21ASE_Stage1;

public class Baggage {
	private double weight;
	private double dimensionX;
	private double dimensionY;
	private double dimensionZ;
	private double dimensionT; 

	public Baggage(double weight, double dimensionT) {
		this.weight = weight;
		this.dimensionT = dimensionT;
		//weight = 0.0;
		//dimensionT = 0.0;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public double getDimensionX() {
		return dimensionX;
	}

	public void setDimensionX(double dimensionX) {
		this.dimensionX = dimensionX;
	}
	
	public double getDimensionY() {
		return dimensionY;
	}

	public void setDimensionY(double dimensionY) {
		this.dimensionY = dimensionY;
	}
	
	public double getDimensionZ() {
		return dimensionZ;
	}

	public void setDimensionZ(double dimensionZ) {
		this.dimensionZ = dimensionZ;
	}
	
	
	public double getDimensionT() {
		return dimensionT;
	}

	public void setDimensionT(double dimensionT) {
		this.dimensionT = dimensionT;
	}
	
	public String toString() {
		return "\n Baggage's weight: " +getWeight() +"kg, baggage dimension :" +getDimensionT() +"cm^3";
	}

}
