package F21ASE_Stage2;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import interfaces.Observer;

public class Desk extends Thread {
	private Queue passengerQueue;
	private BookingList bookingList;
	private int number;
	private int endTime;
	private boolean closed = false;

	// TEST
	private HashSet<Passenger> passengersCheckedIn;
	private FlightList flightList;
	private Flight flight;

	public Desk(Queue passengerQueue, BookingList bookingList, int number, int endTime) {
		this.passengerQueue = passengerQueue;
		this.bookingList = bookingList;
		this.number = number;
		this.endTime = endTime;

		// TEST
		passengersCheckedIn = new HashSet<Passenger>();
		flightList = new FlightList();
		flightList.readFile("flight.txt");
		flight = flightList.findByFlightCode(bookingList.getPassengerFlightCode("Tom FERAUD"));
		//flight.start();
	}

	public void run() {
		long startTime = System.currentTimeMillis();
		while (true) {
			//notifyObservers();
			if ((System.currentTimeMillis() - startTime) < endTime * 1000) {
				try {
					sleep(2000); // time big enough to test (so the queue is complete before proceeding
					// passengers)

					notifyObservers();
					//System.out.println(this.getRegisteredObservers());

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				System.out.println("Desk NO." + number + " is closed\n");
				closed = true;
				notifyObservers();
				return;
			}
		}

	}

	public int getDeskNumber() {
		return this.number;
	}

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
		for (Observer obs : registeredObservers)
			obs.update();
	}

	public synchronized String getDeskInfo() {
		String info = "";

		if (this.isClosed()) {
			info += "Desk NO." + number + " is closed\n";
		} else if (passengerQueue.size() >= 1) {

			Passenger tmp = passengerQueue.takePassenger();
			String name = tmp.getFullName();
			Baggage baggage = tmp.getBaggage();
			String bookingCode = bookingList.getPassengerBookingRef(name);
			Booking booking = bookingList.findByBookingReference(bookingCode);

			//flight = flightList.findByFlightCode(bookingList.getPassengerFlightCode(tmp.getFullName()));

			String infoPassenger = bookingList.getPassengerInfo(name);
			info += "Actual passenger at desk n°" + number + ":\n" + name + "\n" + infoPassenger + " "
					+ "\nBaggage info " + baggage.getWeight() + "kg  " + baggage.getDimensionX() + " x "
					+ baggage.getDimensionY() + " x " + baggage.getDimensionZ() + " Extra fee: £"
					+ baggage.calculateBagFee();
			booking.setCheckedIn(true);
			System.out.println("VOL : " + flight);

			System.out.println("Taille avant: " + flight.getNbrOfPassengerCheckedIn());
			if (booking.hasCheckedIn()) {
				//notifyObservers();
				//flight.notify();
				flight.notifyObservers();
				flight.addFlightPassenger();
				flight.notifyObservers();
				//updateFlightInfo(flight); // add a passenger
			}
			System.out.println("Taille apres: " + flight.getNbrOfPassengerCheckedIn());

			/*
			 * try { sleep(1000); booking.setCheckedIn(true); // set the check in value to
			 * TRUE info = ""; info += "Desk NO." + number + " is free\n"; } catch
			 * (InterruptedException e) { // TODO Auto-generated catch block
			 * e.printStackTrace(); }
			 */

		} else {
			info += "Desk NO." + number + " is free\n";
		}
		//System.out.println("TEEEEEST: " + bookingList.getPassengerInfo("Tom FERAUD")); // working
		return info;
	}
	
	/*public void updateFlightInfo(Flight flight) {
		flight.addFlightPassenger();
	}
	
	public String getFlightInfo( {
		String info = "";
		
		return info;
	} */

	public Queue getPassengerQueue() {
		return passengerQueue;
	}

	public void setPassengerQueue(Queue passengerQueue) {
		this.passengerQueue = passengerQueue;
	}

	public BookingList getBookingList() {
		return bookingList;
	}

	public void setBookingList(BookingList bookingList) {
		this.bookingList = bookingList;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getEndTime() {
		return endTime;
	}

	public void setEndTime(int endTime) {
		this.endTime = endTime;
	}

	public boolean isClosed() {
		return closed;
	}

	public void setClosed(boolean closed) {
		this.closed = closed;
	}

	public List<Observer> getRegisteredObservers() {
		return registeredObservers;
	}

	public void setRegisteredObservers(List<Observer> registeredObservers) {
		this.registeredObservers = registeredObservers;
	}

	public HashSet<Passenger> getPassengersCheckedIn() {
		return passengersCheckedIn;
	}

	public void setPassengersCheckedIn(HashSet<Passenger> passengersCheckedIn) {
		this.passengersCheckedIn = passengersCheckedIn;
	}

	
	
}
