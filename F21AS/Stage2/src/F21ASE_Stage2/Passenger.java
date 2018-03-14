package F21ASE_Stage2;

/**
 * @author Tom Feraud
 * @version 1.0
 */

public class Passenger {
	private String firstName;
	private String middleName;
	private String lastName;
	private Baggage baggage;

	/**
	 * Constructor of Passenger with a first name & a last name
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public Passenger(String firstName, String lastName) {
		this.firstName = firstName.toUpperCase();
		this.middleName = "";
		this.lastName = lastName.toUpperCase();
	}

	/**
	 * Constructor of Passenger with a first name, a middle name & a last name
	 * 
	 * @param fName
	 * @param mName
	 * @param lName
	 */
	public Passenger(String fName, String mName, String lName) {
		firstName = fName.toUpperCase();
		middleName = mName.toUpperCase();
		lastName = lName.toUpperCase();
	}

	/**
	 * Constructor to create name from full name in the format first name then
	 * space then last name or first name then space then middle name then space
	 * then last name
	 */
	public Passenger(String fullName) {
		int spacePos1 = fullName.indexOf(' ');
		firstName = fullName.substring(0, spacePos1);
		int spacePos2 = fullName.lastIndexOf(' ');
		if (spacePos1 == spacePos2)
			middleName = "";
		else
			middleName = fullName.substring(spacePos1 + 1, spacePos2);
		lastName = fullName.substring(spacePos2 + 1);
	}

	/**
	 * Returns the first name
	 * 
	 * @return firstName String
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Changes the first name to the value provided in the parameter
	 * 
	 * @param firstName
	 *            String
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName.toUpperCase();
	}

	/**
	 * Returns the last name
	 * 
	 * @return lastName String
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Changes the last name to the value provided in the parameter
	 * 
	 * @param lastName
	 *            String
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName.toUpperCase();
	}

	/**
	 * Returns the first name
	 * 
	 * @return String containing the first and the last name
	 */
	public String getFirstAndLastName() {
		return firstName + " " + lastName;
	}

	/**
	 * Returns the last name
	 * 
	 * @return String containing the last name, a coma, and then the first name
	 */
	public String getLastCommaFirst() {
		return lastName + ", " + firstName;
	}

	/**
	 * Returns the full name either first name then space then last name or
	 * first name then space then middle name then space and then last name
	 * 
	 * @return String containing the full name
	 */
	public String getFullName() {
		String result = firstName + " ";
		if (!middleName.equals("")) {
			result += middleName + " ";
		}
		result += lastName;
		return result;
	}

	/**
	 * Returns the Baggage
	 * 
	 * @return baggage
	 */
	public Baggage getBaggage() {
		return baggage;
	}

	/**
	 * Sets the passenger' baggage
	 * 
	 * @param baggage
	 */
	public void setBaggage(Baggage baggage) {
		this.baggage = baggage;
	}

	/**
	 * Returns the initials of the Passenger
	 * 
	 * @return String containing the initials of the Passenger
	 */
	public String getInitials() {
		char firstInitial = this.firstName.charAt(0);
		if (!(this.middleName.equalsIgnoreCase(""))) { 				//if there is a middle name
			char middleInitial = this.middleName.charAt(0);
			char lastInitial = this.lastName.charAt(0);
			return firstInitial + "." + middleInitial + "." + lastInitial;
		} else {													//if there is no middle name
			char lastInitial = this.lastName.charAt(0);
			return firstInitial + "." + lastInitial;
		}

	}
	

	
	
	/////STAGE 2
	
	public String toString() {
		return this.getFullName();
	}
	
}