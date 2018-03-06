package F21ASE_Stage2;

import java.util.HashSet;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Queue extends Thread {

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
			passengerTmp = bookingList.randomPasenger();

			// We check against our list if a passenger was not already in the queue (to
			// ensure that he hasn't passed the check-in and we put him against in the
			// queue)
			if (!passengersArrived.contains(passengerTmp)) {
				passengersArrived.add(passengerTmp);
				// System.out.println("Passenger arrived:\n"+passengersArrived); //To print the list (test)
				queue.offer(passengerTmp);
				cpt++;
			}
			try {
				sleep(5);
				System.out.println("Queue: " + queue.toString());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		// System.out.println(queue.toString());
		/*
		 * for (Passenger p : queue) { System.out.println(p.toString()); } //To print the queue (test)
		 */
		System.out.println("cpt = " + cpt);
	}

	public synchronized int size() {
		return queue.size();
	}

	public Passenger frontPassenger() {
		return queue.poll();
	}
	
	public Passenger takePassenger() {
		return queue.poll();
	}


}
