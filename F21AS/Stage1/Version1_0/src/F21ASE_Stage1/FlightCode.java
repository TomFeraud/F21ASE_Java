package F21ASE_Stage1;

public class FlightCode {
	private String flightCode;
	
	//Create an unique format style FR8606
	//As for the booking reference code.
	public FlightCode(String flightCode){
		this.flightCode = flightCode;
	}

	public String getFlightCode() {
		return flightCode;
	}

	public void setFlightCode(String flightCode) {
		this.flightCode = flightCode;
	}
	

}
