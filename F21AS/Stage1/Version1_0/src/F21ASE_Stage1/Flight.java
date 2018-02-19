package F21ASE_Stage1;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Flight {
    private String departure,
            destination,
            carrier;
    private String flightCode;

    private int maxNbrPassengers;

    private double maxBaggageVolume,
            maxBaggageWeight;

    private ArrayList<Passenger> passengersList;

    /**
     * Constructor
     * @param departure
     * @param destination
     * @param carrier
     * @param flightCode
     * @param maxNbrPassengers
     * @param maxBaggageWeight
     */
    public Flight(String departure, String destination, String carrier, String flightCode, int maxNbrPassengers, double maxBaggageWeight, double maxBaggageVolume)
    {
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

    public String getDeparture() {
        return this.departure;
    }

    public String getDestination() {
        return this.destination;
    }

    public String getCarrier() {
        return this.carrier;
    }

    public String getFlightCode() {
        return this.flightCode;
    }

    public int getMaxNbrPassengers() {
        return this.maxNbrPassengers;
    }

    public double getMaxBaggageVolume() {
        return this.maxBaggageVolume;
    }

    public double getMaxBaggageWeight() {
        return this.maxBaggageWeight;
    }

    public String toString() {
        return "Carrier: " +this.carrier+ ", Flight Code: "+this.flightCode+", Departure: " +this.departure+", Destination: "
                +this.destination+", Max Passengers: "+this.maxNbrPassengers+", Max Baggage Weight: "+this.maxBaggageWeight+", Max Baggage Volume: "
                +this.maxBaggageVolume;
    }

    /**
     * Validate the flight code
     *
     * Correct flight code should start with 2 capital letters following by 2-4
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

    public void addPassenger(Passenger p) {
        passengersList.add(p);
    }

    private double getTotalBaggageWeight() {
        double weight = 0;
        for (Passenger p: passengersList) {
            weight += p.getBaggage().getWeight();
        }
        return weight;
    }

    private double getTotalBaggageVolume() {
        double volume = 0;
        for (Passenger p: passengersList) {
            volume += p.getBaggage().getDimensionT();
        }
        return volume;
    }

    private double getTotalExtraFee() {
        double fee = 0;
        for (Passenger p: passengersList) {
            fee += p.getBaggage().getExcessBagFee();
        }
        return fee;
    }

    private String checkCapacity() {
        String report = "";
        if(this.getTotalBaggageWeight() > this.maxBaggageWeight) {
            report += "Baggage Weight Exceeds\t";
        }
        if(this.getTotalBaggageVolume() > this.maxBaggageVolume) {
            report += "Baggage Volume Exceeds\t";
        }
        if(this.passengersList.size() > this.maxNbrPassengers) {
            report += "Passenger Number Exceeds\t";
        }
        if(report.equals("")) {
            report = "None";
        }
        return report;
    }

    public String printReport() {
        return this.flightCode + " ---- Total Number of Passenger:  " + passengersList.size() + ", Total Baggage Weight: "
                + this.getTotalBaggageWeight() + "KG, Total Baggage Volume: " + this.getTotalBaggageVolume() +
                "M^3, Extra Fee: £" +this.getTotalExtraFee()+", Capacity Exceeds: " + this.checkCapacity() + "\n";
    }
}
