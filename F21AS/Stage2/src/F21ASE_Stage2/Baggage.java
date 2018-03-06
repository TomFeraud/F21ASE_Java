package F21ASE_Stage2;

/**
 * @author Ombeline Gabriel
 * @version 1.0
 */

public class Baggage {
	private double weight;
	private double dimensionX;
	private double dimensionY;
	private double dimensionZ;
	private double dimensionT;
	private double excessBagFee;

	/**
	 * Constructor of Baggage with the weight and dimensions
	 * 
	 * @param weight
	 * @param dimensionX
	 * @param dimensionY
	 * @param dimensionZ
	 */
	public Baggage(double weight, double dimensionX, double dimensionY, double dimensionZ) {
		this.weight = weight;
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;
		this.dimensionZ = dimensionZ;
	}

	/**
	 * Calculates the total dimension of the baggage and rounds it up to two decimal
	 * points
	 * 
	 * @return the total dimension
	 */
	public double calculateDimT() {
		dimensionT = dimensionX * dimensionY * dimensionZ;
		dimensionT = Math.round(dimensionT * 100.0) / 100.0;
		return dimensionT;
	}

	/**
	 * Calculates the excess fee the customer will have to pay according to their
	 * baggage's weight
	 * 
	 * @return excess bag fee
	 */
	public double calculateBagFee() {
		if (weight < 20) {
			excessBagFee = 0;
		} else {
			excessBagFee = (weight - 20) * 5; // £5 per extra kg
			excessBagFee = Math.round(excessBagFee * 100.0) / 100.0;
		}
		return excessBagFee;
	}

	/**
	 * get the baggage weight
	 * 
	 * @return baggage weight rounded up to two decimals
	 */
	public double getWeight() {
		return Math.round(weight * 100.0) / 100.0;
	}

	/**
	 * sets the weight to the parameter in the ()
	 * 
	 * @param weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * get dimensionX
	 * 
	 * @return dimensionX
	 */
	public double getDimensionX() {
		return dimensionX;
	}

	/**
	 * sets dimensionX
	 * 
	 * @param dimensionX
	 */
	public void setDimensionX(double dimensionX) {
		this.dimensionX = dimensionX;
	}

	/**
	 * get dimensionY
	 * 
	 * @return dimensionY
	 */
	public double getDimensionY() {
		return dimensionY;
	}

	/**
	 * sets dimensionY
	 * 
	 * @param dimensionY
	 */
	public void setDimensionY(double dimensionY) {
		this.dimensionY = dimensionY;
	}

	/**
	 * get dimensionZ
	 * 
	 * @return dimensionZ
	 */
	public double getDimensionZ() {
		return dimensionZ;
	}

	/**
	 * sets dimensionZ
	 * 
	 * @param dimensionZ
	 */
	public void setDimensionZ(double dimensionZ) {
		this.dimensionZ = dimensionZ;
	}

	/**
	 * get dimensionT
	 * 
	 * @return dimensionT
	 */
	public double getDimensionT() {
		return dimensionT;
	}
	
	
	/////STAGE 2
	public Baggage(double weight, double dimensionT) {
		this.weight = weight;
		this.dimensionT = dimensionT;
	}

	/**
	 * sets dimension total
	 * 
	 * @param dimensionT
	 */
	public void setDimensionT(double dimensionT) {
		this.dimensionT = dimensionT;
	}

	/**
	 * get extra baggage fee
	 * 
	 * @return excessBagFee
	 */
	public double getExcessBagFee() {
		return excessBagFee;
	}

	/**
	 * sets excess fee
	 * 
	 * @param excessBagFee
	 */
	public void setExcessBagFee(double excessBagFee) {
		this.excessBagFee = excessBagFee;
	}

	public String toString() {
		return "\n Baggage's weight: " + getWeight() + "kg, baggage dimension:" + calculateDimT()
				+ "M^3, excess baggage fee: £" + this.excessBagFee;

	}

}
