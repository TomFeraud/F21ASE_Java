package F21ASE_Stage1;

/**
 * @author Tom Feraud
 * @version 1.0
 */

public class Booking {
	private Passenger passenger;
	private Ticket ticket;
	private boolean checkedIn;

	/**
	 * Constructor of Booking with a Passenger and a Ticket
	 * 
	 * @param passenger
	 * @param ticket
	 */
	public Booking(Passenger passenger, Ticket ticket) {
		this.passenger = passenger;
		this.ticket = ticket;
	}

	/**
	 * Returns the passenger of the booking
	 * 
	 * @return passenger
	 */
	public Passenger getPassenger() {
		return passenger;
	}

	/**
	 * Sets the booking' passenger
	 * 
	 * @param passenger
	 */
	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	/**
	 * Returns the ticket of the booking
	 * 
	 * @return ticket
	 */
	public Ticket getTicket() {
		return ticket;
	}

	/**
	 * Sets the booking' ticket
	 * 
	 * @param ticket
	 */
	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	/**
	 * Checks if a passenger according to his ticket has checked in or not yet
	 * 
	 * @return checkedIn
	 */
	public boolean hasCheckedIn() {
		return checkedIn;
	}

	/**
	 * Sets if a passenger according to his ticket has checked in or not yet
	 * 
	 * @param checkedIn
	 */
	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public String toString() {
		return "\n Booking reference code: '" + ticket.getBookingReferenceCode() + "', Name: '"
				+ passenger.getFullName() + "', Flight Code: '" + ticket.getFlightCode().getFlightCode()
				+ "', checked in?: " + this.hasCheckedIn() + "\n";
		// + "baggage: " +passenger.getBaggage().getDimension();
	}

}
