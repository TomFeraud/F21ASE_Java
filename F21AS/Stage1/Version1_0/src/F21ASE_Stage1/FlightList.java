package F21ASE_Stage1;

////////////////////////////
//// /!\ change the comment about cabin/accomodation.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FlightList {
	private ArrayList<Flight> flightList;

	public FlightList() {
		flightList = new ArrayList<Flight>();
	}

	public boolean addFlight(Flight f) {
		FlightCode flightCode = f.getFlightCode();
		Flight inList = this.findByFlightCode(flightCode);
		if (inList == null) {
			flightList.add(f);
			return true;
		}
		return false;
	}

	// populate the cabin by reading a text file
	public void populate() {
		this.readFile("flight.txt");
	}

	private void readFile(String filename) {
		try {
			File f = new File(filename);
			Scanner scanner = new Scanner(f);
			// read the first line of the input file to get the accommodation
			// type
			// String cabin_type = scanner.nextLine();

			while (scanner.hasNextLine()) {
				// read first line and process it
				String inputLine = scanner.nextLine();
				// ignored if blank line
				if (inputLine.length() != 0)
					processLine(inputLine);
			}
			scanner.close();
		}
		// if the file is not found, stop with system exit
		catch (FileNotFoundException fnf) {
			System.out.println(filename + " not found ");
			System.exit(0);
		}
	}

	private void processLine(String line) {
		String parts[] = line.split(",");// split string into items

		try {
			String carrier = parts[0];
			FlightCode flightCode = new FlightCode(parts[1]);
			String departure = parts[2];
			String destination = parts[3];
			int maxNbrPassengers = Integer.parseInt(parts[4]);
			double maxBaggageWeight = Double.parseDouble(parts[5]);
			double maxBaggageVolume = Double.parseDouble(parts[6]);

			if (flightCodeValidation(flightCode)) {
				// create flight object
				Flight f = new Flight(departure, destination, carrier, flightCode, maxNbrPassengers, maxBaggageWeight,
						maxBaggageVolume);
				this.addFlight(f);
			}
		}
		// this catches trying to convert a String to an integer
		catch (NumberFormatException nfe) {
			String error = "Number conversion error in '" + line + "' - " + nfe.getMessage();
			System.out.println(error);
		}
		// this catches missing items if only one or two items
		// other omissions will result in other errors
		catch (ArrayIndexOutOfBoundsException air) {
			String error = "Not enough items in : '" + line + "' index position : " + air.getMessage();
			System.out.println(error);
		}
	}

	public Flight findByFlightCode(FlightCode flightCode) {
		for (Flight f : flightList) {
			// THIS WILL WORK
			// if(f.getFlightCode().getFlightCode().equals(flightCode.getFlightCode()))

			if (f.getFlightCode().equals(flightCode)) // Tom: incorrect use of
														// equals method, you
														// compare a FlightCode
														// with a String (need
														// to implements new
														// methods?) : will
														// return null in all
														// cases here
			{
				return f;
			}
		}
		return null;
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
	public boolean flightCodeValidation(FlightCode flightCode) {
		Pattern p = Pattern.compile("^[A-Z]{2}\\d{3,4}$");
		Matcher m = p.matcher(flightCode.getFlightCode());

		return m.find(); // returns true if flight code matches, otherwise false
	}

	public int getTotalNumberofFlights() {
		return flightList.size();
	}

}
