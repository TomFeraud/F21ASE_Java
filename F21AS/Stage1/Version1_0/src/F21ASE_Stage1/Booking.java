package F21ASE_Stage1;

public class Booking {
	private Passenger passenger;
	private Ticket ticket;
	private boolean checkedIn;

	public Booking(Passenger passenger, Ticket ticket) {
		this.passenger = passenger;
		this.ticket = ticket;
	}

	public Passenger getPassenger() {
		return passenger;
	}

	public void setPassenger(Passenger passenger) {
		this.passenger = passenger;
	}

	public Ticket getTicket() {
		return ticket;
	}

	public void setTicket(Ticket ticket) {
		this.ticket = ticket;
	}

	public boolean hasCheckedIn() {
		return checkedIn;
	}

	public void setCheckedIn(boolean checkedIn) {
		this.checkedIn = checkedIn;
	}

	public String toString() {
		return "\n Booking reference code: '" + ticket.getBookingReferenceCode() + "', Name: '"
				+ passenger.getFullName() + "', Flight Code: '" + ticket.getFlightCode().getFlightCode()
				+ "', cheked in?: " + this.hasCheckedIn() + "\n";
				//+ "baggage: " +passenger.getBaggage().getDimension();
	}

}
