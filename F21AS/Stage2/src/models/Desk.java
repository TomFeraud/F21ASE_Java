package models;



import F21ASE_Stage2.Baggage;
import F21ASE_Stage2.BookingList;
import F21ASE_Stage2.Passenger;
import F21ASE_Stage2.RandomHelper;

//06/03: Tom> Works nicely, still not perfect: it can happens that passengers are not proceeded correctly: one pass before someone before him(in the queue) (to solve)
// => problem of synchronization?
public class Desk extends Thread {
	private Queue passengerQueue;
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
		while (i < 24) {
			try {
				sleep(200); // time big enough to test (so the queue is complete before proceeding
								// passengers)
				processPassenger();
				i++;

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
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

	
}
