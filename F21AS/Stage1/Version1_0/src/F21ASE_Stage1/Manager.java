package F21ASE_Stage1;

public class Manager {
	private BookingList bookingList;

	public Manager() {
		bookingList = new BookingList();
	}

	
	public void run(){
		bookingList.readFile("booking.txt");
		bookingList.printSize();
		bookingList.printBookingList();
		if(bookingList.hasPassengerBooked("Degrandi","AD2404")){
			//System.out.println(bookingList.findByBookingReference("AD2404"));
			//Baggage baggage1 = new Baggage(10.0,0);
			//bookingList.findByBookingReference("AD2404").setBaggage(baggage1);
			//System.out.println(bookingList.findByBookingReference("AD2404").getBaggage());
			
			GUI gui = new GUI(bookingList);
	        gui.setVisible(true);
		}
	}
}
