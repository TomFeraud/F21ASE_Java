package F21ASE_Stage1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Flight {
    private String departure,
            destination,
            carrier;
    private FlightCode flightCode;

    private int maxNbrPassengers;

    private double maxBaggageVolume,
            maxBaggageWeight;

    /**
     * Constructor
     * @param departure
     * @param destination
     * @param carrier
     * @param flightCode
     * @param maxNbrPassengers
     * @param maxBaggageWeight
     */
    public Flight(String departure, String destination, String carrier, FlightCode flightCode, int maxNbrPassengers, double maxBaggageWeight, double maxBaggageVolume)
    {
        this.departure = departure;
        this.destination = destination;
        this.carrier = carrier;
        this.flightCode = flightCode;
        this.maxNbrPassengers = maxNbrPassengers;
        this.maxBaggageWeight = maxBaggageWeight;
        this.maxBaggageVolume = maxBaggageVolume;
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

    public FlightCode getFlightCode() {
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
}
