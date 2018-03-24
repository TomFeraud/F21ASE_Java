package F21ASE_Stage2;

import java.util.*;
import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;

import interfaces.Observer;
import interfaces.Subject;

public class Queue extends Thread implements Subject {

	private ConcurrentLinkedQueue<Passenger> queue;
	private BookingList bookingList;
	private HashSet<Passenger> passengersArrived;

	public Queue(BookingList bookingList) {
		queue = new ConcurrentLinkedQueue<Passenger>();
		this.bookingList = bookingList;
		passengersArrived = new HashSet<Passenger>();
	}

	public void run() {
		int cpt = 0;
		Passenger passengerTmp = null;

		while (cpt < bookingList.size()) {
			passengerTmp = bookingList.randomPassenger();
			double weightBag = RandomHelper.getRandomWeight();
			int[] dim = RandomHelper.getRandomDimensions();
			int lengthBag = dim[0];
			int widthBag = dim[1];
			int heightBag = dim[2];
			Baggage bagTmp = new Baggage(weightBag, lengthBag, widthBag, heightBag);
			passengerTmp.setBaggage(bagTmp);

			// We check against our list if a passenger was not already in the queue (to
			// ensure that he hasn't passed the check-in and we put him against in the
			// queue)
			if (!passengersArrived.contains(passengerTmp)) {
				passengersArrived.add(passengerTmp);
				// System.out.println("Passenger arrived:\n"+passengersArrived); //To print the
				// list (test)
				queue.offer(passengerTmp);
				notifyObservers();
				Log log = Log.getInstance();
		        log.write(passengerTmp.getFullName() +" joined the queue");
				cpt++;
			}
			try {
				sleep(100);
				System.out.println("Queue: " + queue.toString());

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// System.out.println(queue.toString());

		// for (Passenger p : queue) { System.out.println(p.toString()); } //To print
		// the queue (test)

		System.out.println("cpt = " + cpt);
	}

	public int size() {
		return queue.size();

	}

	public Passenger takePassenger() {

		if (queue.size() == 0) {
			return null;
		} else {
			Passenger tmp = queue.element();
			queue.poll();
			notifyObservers();
			return tmp;
		}

	}

	// OBSERVER PATTERN
	// SUBJECT must be able to register, remove and notify observers
	// list to hold any observers
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

	// to test the observer
	public String getNameNextPassenger() {
		if (queue.size() == 0) {
			return "";
		}
		return queue.element().getFullName();
	}

	public String getQueuePassengers() {
		String queueText = "";
		for (Passenger p : queue) {
			queueText += bookingList.getPassengerBookingRef(p.getFullName()) + "        " + p.toString()
					+ p.getBaggage() + "\n\n";
		}

		return queueText;
	}

}
