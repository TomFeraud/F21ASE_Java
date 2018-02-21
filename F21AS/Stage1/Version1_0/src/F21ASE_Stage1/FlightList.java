package F21ASE_Stage1;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;


public class FlightList {
	private ArrayList<Flight> flightList;

	/**
	 * constructor
	 */
	public FlightList() {
		flightList = new ArrayList<Flight>();
	}

	public boolean addFlight(Flight f) {
		String flightCode = f.getFlightCode();
		Flight inList = this.findByFlightCode(flightCode);
		if (inList == null) {
			flightList.add(f);
			return true;
		}
		return false;
	}

    /**
     * read flight information
     * @param filename
     */
	public void readFile(String filename) {
		try {
			File f = new File(filename);
			Scanner scanner = new Scanner(f);

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

	/**
	 * Process flight information
	 * @param line
	 */
	private void processLine(String line) {
		String parts[] = line.split(",");// split string into items

		try {
			String carrier = parts[0];
			String flightCode = parts[1];
			String departure = parts[2];
			String destination = parts[3];
			int maxNbrPassengers = Integer.parseInt(parts[4]);
			double maxBaggageWeight = Double.parseDouble(parts[5]);
			double maxBaggageVolume = Double.parseDouble(parts[6]);

            // create flight object
            Flight f = new Flight(departure, destination, carrier, flightCode, maxNbrPassengers, maxBaggageWeight,
						maxBaggageVolume);
            this.addFlight(f);

		}
		// this catches trying to convert a String to an integer
		catch (NumberFormatException nfe) {
			String error = "Number conversion error in '" + line + "' - " + nfe.getMessage();
			System.err.println(error);
		}
		// this catches missing items if only one or two items
		// other omissions will result in other errors
		catch (ArrayIndexOutOfBoundsException air) {
			String error = "Not enough items in : '" + line + "' index position : " + air.getMessage();
			System.err.println(error);
		}
		catch (InvalidFormatException ife) {
            System.err.println(ife.getMessage());
        }
	}

	/**
	 * find flight by flight code
	 * @param flightCode
	 * @return
	 */
	public Flight findByFlightCode(String flightCode) {
		for (Flight f : flightList) {
			if (f.getFlightCode().equals(flightCode))
			{
				return f;
			}
		}
		return null;
	}

    /**
     * Get the size of the flight array list
     * @return
     */
	public int getTotalNumberofFlights() {
		return flightList.size();
	}

	public void printFlightList() {
        for (Flight f:flightList) {
            System.out.println(f.toString());
        }
    }

	/**
	 * print flight reports
	 * @param filePath
	 */
    public void printReport(String filePath) {
        try {
            //the file path
            File file = new File(filePath);

            //if the file not exist create one
            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
        	bw.write("Check in kiosk report\nFlight #    Number of Passengers    Baggage Weight(kg)    Baggage Volume(m^3)    Excess Fee(£)    Capacity exceeded? \n");
        	System.out.println("Check in kiosk report\nFlight #    Number of Passengers    Baggage Weight(kg)    Baggage Volume(m^3)    Excess Fee(£)    Capacity exceeded? \n");
            for (Flight f: flightList) {
                bw.write(f.printReport());
                System.out.print(f.printReport());
            }
            //close BufferedWriter
            bw.close();
            //close FileWriter
            fw.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
