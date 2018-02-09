package F21ASE_Stage1;

/**
 * @author Tom Feraud
 * @version 1.0
 */

public class Ticket {
	private String bookingReferenceCode;
	private FlightCode flightCode;

	/**
	 * Constructor of Ticket with a unique booking reference code & a FlightCode
	 * 
	 * @param bookingReferenceCode
	 * @param flightCode
	 */
	// TO DO (SIDI): CHECK THE UNIQUE FORMAT DIRECTLY IN THE CONSTRUCTOR
	public Ticket(String bookingReferenceCode, FlightCode flightCode) {
		this.bookingReferenceCode = bookingReferenceCode;
		this.flightCode = flightCode;
	}

	/**
	 * Returns the booking reference
	 * 
	 * @return bookingReferenceCode String
	 */
	public String getBookingReferenceCode() {
		return bookingReferenceCode;
	}

	/**
	 * Sets the ticket' booking reference
	 * 
	 * @param bookingReferenceCode
	 */
	public void setBookingReferenceCode(String bookingReferenceCode) {
		this.bookingReferenceCode = bookingReferenceCode;
	}

	/**
	 * Returns the flight code
	 * 
	 * @return flightCode flightCode
	 */
	public FlightCode getFlightCode() {
		return flightCode;
	}

	/**
	 * Sets the flight code
	 * 
	 * @param flightCode
	 */
	public void setFlightCode(FlightCode flightCode) {
		this.flightCode = flightCode;
	}

}
