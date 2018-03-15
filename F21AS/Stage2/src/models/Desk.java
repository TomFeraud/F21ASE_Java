package models;



import java.util.LinkedList;
import java.util.List;

import F21ASE_Stage2.Baggage;
import F21ASE_Stage2.BookingList;
import F21ASE_Stage2.Passenger;
import F21ASE_Stage2.RandomHelper;
import interfaces.Observer;

//06/03: Tom> Works nicely, still not perfect: it can happens that passengers are not proceeded correctly: one pass before someone before him(in the queue) (to solve)
// => problem of synchronization?
public class Desk extends Thread {
	private Queue passengerQueue;
	private BookingList bookingList;
	private int number;
	private int endTime;

	public Desk(Queue passengerQueue, BookingList bookingList, int number, int endTime) {
		this.passengerQueue = passengerQueue;
		this.bookingList = bookingList;
		this.number = number;
		this.endTime = endTime;
	}

	public void run() {
		long startTime = System.currentTimeMillis();
		int i = 0;
		// while (i<bookingList.size()) {
		// To change the "i method": tmp
		// 24,12,8
		// for 1,2,3 desk(s)
		while (i < 8) {
			if ((System.currentTimeMillis()-startTime) < endTime*1000) {
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
			} else {
				System.out.println("Desk NO."+number+" is closed\n");
				return;
			}
		}

	}



	// Process the current passengers
	// Is synchronized necessary?
	public synchronized void processPassenger() {
		Passenger tmp = passengerQueue.takePassenger();
		String name = tmp.getFullName();

		Baggage baggage = tmp.getBaggage();
		
/*
		double weightBag = RandomHelper.getRandomWeight();
		int[] dim = RandomHelper.getRandomDimensions();
		int lengthBag = dim[0];
		int widthBag = dim[1];
		int heightBag = dim[2];
		Baggage bagTmp = new Baggage(weightBag, lengthBag, widthBag, heightBag);

		String infoPassenger = bookingList.getPassengerInfo(name);
		System.out.println("Actual passenger at desk n°" + number + ":\n" + name + "\n" + infoPassenger
				+ "\nWeight tot baggage: " + weightBag + "; Dim tot baggage: " + bagTmp.getDimensionX() + "x"
				+ bagTmp.getDimensionY() + "x" + bagTmp.getDimensionZ() + "\nFees?: " + bagTmp.calculateBagFee());
*/
		String infoPassenger = bookingList.getPassengerInfo(name);
		System.out.println("Actual passenger at desk n°" + number + ":\n" + name + "\n" + infoPassenger + " "
		+ "\nBaggage info " + baggage.getWeight() + "kg  "+ baggage.getDimensionX() +" x " + baggage.getDimensionY() + " x " 
				+ baggage.getDimensionZ() + " Extra fee: £" + baggage.calculateBagFee());
		
		System.out.println();

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


	
}
