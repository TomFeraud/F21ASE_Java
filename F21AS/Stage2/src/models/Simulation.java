package models;

import java.util.Random;

import javax.swing.JOptionPane;

import F21ASE_Stage2.BookingList;
import F21ASE_Stage2.Desk;
import F21ASE_Stage2.DeskList;
import F21ASE_Stage2.Flight;
import F21ASE_Stage2.FlightList;
import F21ASE_Stage2.Queue;

public class Simulation {
	private BookingList bookingList;

	private int nbrDesk;
	// list of desks
	private DeskList deskList;
	private Queue queue;

	private int nbrFlight;
	private FlightList flightList;

	// TEST
	private Flight flight1;

	// set true when times stops
	private boolean finished = false;

	public Simulation() {
		bookingList = new BookingList();
		bookingList.readFile("booking.txt");
		
		int nbrDesk=0;
		bookingList = new BookingList();
		bookingList.readFile("booking.txt");	
		String[] options = new String[] {"3", "2", "1"};
		int response = JOptionPane.showOptionDialog(null, "Select a number of desks\n"
				+ "Exiting this window will mean a random number of desks will be used.", "Desks",
		        JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
		        null, options, null);
		if (response == -1)
		{
			Random generator = new Random(); 
			nbrDesk = generator.nextInt(3) + 1;
		}
		if (response == 2)
		{
			nbrDesk=1;
		}
		if (response == 1)
		{
			nbrDesk=2;	
		}
		if (response == 0)
		{
			nbrDesk=3;
		}
		
		flightList = new FlightList();
		flightList.readFile("flight.txt");

		this.queue = new Queue(bookingList);
		queue.start();

		deskList = new DeskList();
		this.nbrDesk = nbrDesk;
		for (int i = 0; i < nbrDesk; i++) {
			Desk desk = new Desk(queue, bookingList, flightList, i + 1, 10);
			deskList.add(desk);
			deskList.get(i).start();
		}

		
		this.nbrFlight = flightList.getTotalNumberofFlights();
		
		// TEEEEEST
		//System.out.println(flightList.getTotalNumberofFlights());

		// TEEEEEEST OK
		//flight1 = flightList.findByFlightCode("FR1286");
		//System.out.println(flight1);
	}

	public Flight getFlight1() {
		return flight1;
	}

	public void setFlight1(Flight flight1) {
		this.flight1 = flight1;
	}

	
	
	public DeskList getDeskList() {
		return deskList;
	}

	public void setDeskList(DeskList deskList) {
		this.deskList = deskList;
	}

	public Queue getQueue() {
		return queue;
	}

	public void setQueue(Queue queue) {
		this.queue = queue;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public BookingList getBookingList() {
		return bookingList;
	}

	public void setBookingList(BookingList bookingList) {
		this.bookingList = bookingList;
	}

	public int getNbrDesk() {
		return nbrDesk;
	}

	public void setNbrDesk(int nbrDesk) {
		this.nbrDesk = nbrDesk;
	}

	public int getNbrFlight() {
		return nbrFlight;
	}

	public void setNbrFlight(int nbrFlight) {
		this.nbrFlight = nbrFlight;
	}

	public FlightList getFlightList() {
		return flightList;
	}

	public void setFlightList(FlightList flightList) {
		this.flightList = flightList;
	}
	
	
	
	

}
