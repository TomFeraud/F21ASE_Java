package model;

import java.util.Random;

import javax.swing.JOptionPane;

import F21ASE_Stage2.*;

public class Simulation {
	private BookingList bookingList;

	private int nbrDesk;
	// multithreading classes
	private PassengerQueue queue;
	private ConsumerList consumerList;
	private Producer producer;

	private int nbrFlight;
	private FlightList flightList;

	// TEST
	private Flight flight1;

	// set true when times stops
	private boolean finished = false;

	public Simulation() {
		String[] options = new String[] {"3", "2", "1"};
		int response = JOptionPane.showOptionDialog(
				null,
				"Please select a number of check in desks\n", "Desks",
		        JOptionPane.DEFAULT_OPTION,
				JOptionPane.PLAIN_MESSAGE,
		        null,
				options,
				null
		);

		if (response == -1)
		{
			System.exit(0);
		}
		nbrDesk = 3 - response;

		// read booking list
		bookingList = new BookingList();
		bookingList.readFile("booking.txt");
		// read flight list
		flightList = new FlightList();
		flightList.readFile("flight.txt");
		
		this.nbrFlight = flightList.getTotalNumberofFlights();

		//////////// New Multithreading Classes

		this.queue = new PassengerQueue(bookingList, flightList);

		this.producer = new Producer(bookingList, queue);
		producer.start();
		consumerList = new ConsumerList();
		for (int i = 0; i < nbrDesk; i++) {
			Consumer consumer = new Consumer(queue, i+1, 5);
			consumerList.add(consumer);

			consumerList.get(i).start();
		}
	}

	/**
	 * Get the consumer list
	 *
	 * @return consumerList
	 */
	public ConsumerList getConsumerList() {
		return consumerList;
	}

	/**
	 * Get the producer
	 *
	 * @return producer
	 */
	public Producer getProducer() {
		return producer;
	}

	/**
	 * Get passenger queue
	 *
	 * @return passenger queue
	 */
	public PassengerQueue getQueue() {
		return queue;
	}

	/**
	 * Get the number of flights
	 *
	 * @return number of flights
	 */
	public int getNbrFlight() {
		return nbrFlight;
	}

	/**
	 * Get flight List
	 *
	 * @return flight list
	 */
	public FlightList getFlightList() {
		return flightList;
	}
}
