package F21ASE_Stage2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import interfaces.Observer;
import interfaces.Subject;

public class Flight implements Subject {
	private String departure, destination, carrier;
	private String flightCode;

	private int maxNbrPassengers;

	private double maxBaggageVolume, maxBaggageWeight;

	private ArrayList<Passenger> passengersList;

	// STAGE 2
	private int nbrOfPassengerCheckedIn = 0;
	private double totalWeight = 0.0;
	private double totalVolume = 0.0;

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
	 * Sets departure
	 *
	 * @param departure
	 */
	public void setDeparture(String departure) {
		this.departure = departure;
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
	 * Sets destination
	 *
	 * @param destination
	 */
	public void setDestination(String destination) {
		this.destination = destination;
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
	 * Sets carrier
	 *
	 * @param carrier
	 */
	public void setCarrier(String carrier) {
		this.carrier = carrier;
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
	 * Sets flight code
	 *
	 * @param flightCode
	 */
	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
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
	 * Sets the number max of passengers
	 *
	 * @param maxNbrPassengers
	 */
	public void setMaxNbrPassengers(int maxNbrPassengers) {
		this.maxNbrPassengers = maxNbrPassengers;
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
	 * Sets the maximum volume of baggages
	 *
	 * @param maxBaggageVolume
	 */
	public void setMaxBaggageVolume(double maxBaggageVolume) {
		this.maxBaggageVolume = maxBaggageVolume;
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
	 * Sets the maximum weight of baggages
	 *
	 * @param maxBaggageWeight
	 */
	public void setMaxBaggageWeight(double maxBaggageWeight) {
		this.maxBaggageWeight = maxBaggageWeight;
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
	 * <p>
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
	 * Returns the array list of passenger
	 *
	 * @return passengersList
	 */
	public ArrayList<Passenger> getPassengersList() {
		return passengersList;
	}

	/**
	 * Sets the passengers list
	 *
	 * @param passengersList
	 */
	public void setPassengersList(ArrayList<Passenger> passengersList) {
		this.passengersList = passengersList;
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

	////////////////////// STAGE 2
	// OBSERVER PATTERN
	private List<Observer> registeredObservers = new LinkedList<Observer>();

	// methods to register, remove and notify observers
	public void registerObserver(Observer obs) {
		registeredObservers.add(obs);
	}

	public void removeObserver(Observer obs) {
		registeredObservers.remove(obs);
	}

	public void notifyObservers() {
		for (Observer obs : registeredObservers) {
			obs.update();
		}
	}

	@Override
	public void notifyObservers(String[] info) {

	}

	/**
	 * Gets the flight info
	 * 
	 * @return flightInfo
	 */
	public String getFlightInfo() {
		String info = "";
		String singOrPlur = "";
		String weightString = "\nTotal Baggage Weight: " + totalWeight + "kg / " + this.getMaxBaggageWeight() + "kg";
		String volumeString = "\nTotal Baggage Vol.: " + totalVolume + "m3 / " + this.getMaxBaggageVolume() + "m3";
		if (getNbrOfPassengerCheckedIn() == 1) {
			singOrPlur = " passenger is";
		} else {
			singOrPlur = " passengers are";
		}
		if (totalWeight > this.getMaxBaggageWeight()) {
			weightString = "\nWARNING WEIGHT CAPACITY EXCEEDED";

		}
		if (totalVolume > this.getMaxBaggageVolume()) {
			volumeString = "\nWARNING VOLUME CAPACITY EXCEEDED";
		}
		info += "Flight " + this.getFlightCode() + " to " + this.getDestination() + "\n" + getNbrOfPassengerCheckedIn()
				+ singOrPlur + " currently checked in " + weightString + volumeString;

		return info;
	}

	/**
	 * Add a passenger to the flight
	 * 
	 * @param weight
	 * @param volume
	 */
	public void addFlightPassenger(double weight, double volume) {
		this.nbrOfPassengerCheckedIn++;
		totalWeight += weight;
		totalWeight = Math.round(totalWeight * 100.0) / 100.0;
		totalVolume += volume;
		totalVolume = Math.round(totalVolume * 100.0) / 100.0;
		notifyObservers();

	}

	/**
	 * Get the number of passengers checked in
	 * 
	 * @return nbrOfPassengerCheckedIn
	 */
	public int getNbrOfPassengerCheckedIn() {
		return nbrOfPassengerCheckedIn;
	}

}
