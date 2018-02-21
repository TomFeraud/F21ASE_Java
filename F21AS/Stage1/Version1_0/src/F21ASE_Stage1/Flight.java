package F21ASE_Stage1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Flight {
	private String departure, destination, carrier;
	private String flightCode;

	private int maxNbrPassengers;

	private double maxBaggageVolume, maxBaggageWeight;

	private ArrayList<Passenger> passengersList;

	/**
	 * Constructor
	 * 
	 * @param departure
	 * @param destination
	 * @param carrier
	 * @param flightCode
	 * @param maxNbrPassengers
	 * @param maxBaggageWeight
	 */
	public Flight(String departure, String destination, String carrier, String flightCode, int maxNbrPassengers,
			double maxBaggageWeight, double maxBaggageVolume) {
		this.departure = departure;
		this.destination = destination;
		this.carrier = carrier;
		if (!flightCodeValidation(flightCode)) {
			throw new InvalidFormatException(flightCode);
		} else {
			this.flightCode = flightCode;
		}
		this.maxNbrPassengers = maxNbrPassengers;
		this.maxBaggageWeight = maxBaggageWeight;
		this.maxBaggageVolume = maxBaggageVolume;
		this.passengersList = new ArrayList<Passenger>();
	}

	/**
	 * get departure
	 * 
	 * @return departure
	 */
	public String getDeparture() {
		return this.departure;
	}

	/**
	 * get destination
	 * 
	 * @return destination
	 */
	public String getDestination() {
		return this.destination;
	}

	/**
	 * get carrier
	 * 
	 * @return
	 */
	public String getCarrier() {
		return this.carrier;
	}

	/**
	 * get flight code
	 * 
	 * @return flightCode
	 */
	public String getFlightCode() {
		return this.flightCode;
	}

	/**
	 * get max number of passenger
	 * 
	 * @return
	 */
	public int getMaxNbrPassengers() {
		return this.maxNbrPassengers;
	}

	/**
	 * get max baggage volume
	 * 
	 * @return maxBaggageVolume
	 */
	public double getMaxBaggageVolume() {
		return this.maxBaggageVolume;
	}

	/**
	 * get max baggage volume
	 * 
	 * @return maxBaggageWeight
	 */
	public double getMaxBaggageWeight() {
		return this.maxBaggageWeight;
	}

	/**
	 * get flight information
	 * 
	 * @return String
	 */
	public String toString() {

		String info = "\n";
		info += String.format("%-35s", "Carrier: '" + this.carrier + "', ");
		info += String.format("%-24s", "Flight Code: '" + this.flightCode + "', ");
		info += String.format("%-28s", "Departure: '" + this.departure + "', ");
		info += String.format("%-30s", "Destination: '" + this.destination + "', ");
		info += String.format("%-24s", "Max Passengers: '" + this.maxNbrPassengers + "', ");
		info += String.format("%-24s", "Max Baggage Weight: '" + this.maxBaggageWeight + "', ");
		info += String.format("%-24s", "Max Baggage Volume: '" + this.maxBaggageVolume + "'");

		return info;

	}

	/**
	 * Validate the flight code
	 *
	 * Correct flight code should start with 2 capital letters following by 3-4
	 * numbers
	 *
	 * @param flightCode
	 * @return boolean
	 */
	public static boolean flightCodeValidation(String flightCode) {
		Pattern p = Pattern.compile("^[A-Z]{2}\\d{3,4}$");
		Matcher m = p.matcher(flightCode);

		return m.find(); // returns true if flight code matches, otherwise false
	}

	/**
	 * add a passenger to the flight
	 * 
	 * @param p
	 */
	public void addPassenger(Passenger p) {
		passengersList.add(p);
	}

	private double getTotalBaggageWeight() {
		double weight = 0;
		for (Passenger p : passengersList) {
			weight += p.getBaggage().getWeight();
		}
		return weight;
	}

	/**
	 * get the total baggage volume
	 * 
	 * @return volume
	 */
	private double getTotalBaggageVolume() {
		double volume = 0;
		for (Passenger p : passengersList) {
			volume += p.getBaggage().getDimensionT();
		}
		return volume;
	}

	/**
	 * get the extra baggage fee
	 * 
	 * @return fee
	 */
	private double getTotalExtraFee() {
		double fee = 0;
		for (Passenger p : passengersList) {
			fee += p.getBaggage().getExcessBagFee();
		}
		return fee;
	}

	/**
	 * check any capacity exceeds
	 * 
	 * @return report
	 */
	private String checkCapacity() {
		String report = "";
		if (this.getTotalBaggageWeight() > this.maxBaggageWeight) {
			report += "Baggage Weight Exceeds\t";
		}
		if (this.getTotalBaggageVolume() > this.maxBaggageVolume) {
			report += "Baggage Volume Exceeds\t";
		}
		if (this.passengersList.size() > this.maxNbrPassengers) {
			report += "Passenger Number Exceeds\t";
		}
		if (report.equals("")) {
			report = "None";
		}
		return report;
	}

	/**
	 * print Report in a table
	 * 
	 * @return table
	 */
	public String printReport() {

		String Table = "";
		Table += String.format("%-20s", this.flightCode);
		Table += String.format("%-22d", passengersList.size());
		Table += String.format("%-23s", this.getTotalBaggageWeight());
		Table += String.format("%-21s", this.getTotalBaggageVolume());
		Table += String.format("%-18s", this.getTotalExtraFee());
		Table += String.format("%-4s", this.checkCapacity());
		Table += "\n";
		return Table;
	}
}
