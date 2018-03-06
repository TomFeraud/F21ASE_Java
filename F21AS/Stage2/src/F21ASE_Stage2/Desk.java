package F21ASE_Stage2;

import java.util.Random;

//06/03: Tom> Works nicely, still not perfect: it can happens that passengers are not proceeded correctly: one pass before someone before him(in the queue) (to solve)
// => problem of synchronization?
public class Desk extends Thread {
	private Queue passengerQueue;
	// test
	private BookingList bookingList;
	private int number;

	public Desk(Queue passengerQueue, BookingList bookingList, int number) {
		this.passengerQueue = passengerQueue;
		this.bookingList = bookingList;
		this.number = number;
	}

	public void run() {
		int i = 0;
		// while (i<bookingList.size()) {
		// To change the "i method": tmp
		// 24,12,8
		// for 1,2,3 desk(s)
		while (i < 8) {
			try {
				sleep(2000); // time big enough to test (so the queue is complete before proceeding
								// passengers)
				// System.out.println(nextPassenger());
				processPassenger();
				i++;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	// Return the next passenger (the first in the line)
	public Passenger nextPassenger() {
		return passengerQueue.frontPassenger();
	}

	// Process the current passengers
	// Is synchronized necessary?
	public synchronized void processPassenger() {
		Passenger tmp = passengerQueue.takePassenger();
		String name = tmp.getFullName();

		// double dimBag = tmp.getBaggage().getDimensionT();
		Random random = new Random();
		double weightBag = random.nextInt(50);
		double dimBag = random.nextInt(200);
		Baggage bagTmp = new Baggage(weightBag, dimBag);

		String infoPassenger = bookingList.getPassengerInfo(name);
		System.out.println(
				"Actual passenger at desk n°" + number + ":\n" + name + "\n" + infoPassenger + "\nWeight tot baggage: "
						+ weightBag + "; Dim tot baggage: " + dimBag + "\nFees?: " + bagTmp.calculateBagFee());

		System.out.println();

	}
}
