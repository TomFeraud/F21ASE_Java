package F21ASE_Stage1;

public class Plane {
	private double maxNbrPassengers;
	private float maxBaggageWeight;
	private float maxBaggageVolume;

	public Plane(double maxNbrPassengers, float maxBaggageWeight, float maxBaggageVolume) {
		this.maxNbrPassengers = maxNbrPassengers;
		this.maxBaggageWeight = maxBaggageWeight;
		this.maxBaggageVolume = maxBaggageVolume;
	}

	public double getMaxNbrPassengers() {
		return maxNbrPassengers;
	}

	public void setMaxNbrPassengers(double maxNbrPassengers) {
		this.maxNbrPassengers = maxNbrPassengers;
	}

	public float getMaxBaggageWeight() {
		return maxBaggageWeight;
	}

	public void setMaxBaggageWeight(float maxBaggageWeight) {
		this.maxBaggageWeight = maxBaggageWeight;
	}

	public float getMaxBaggageVolume() {
		return maxBaggageVolume;
	}

	public void setMaxBaggageVolume(float maxBaggageVolume) {
		this.maxBaggageVolume = maxBaggageVolume;
	}

}
