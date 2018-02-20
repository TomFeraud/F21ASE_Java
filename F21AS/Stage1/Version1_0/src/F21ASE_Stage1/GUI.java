package F21ASE_Stage1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//quand baggage validé -> checkin à true dans booking.txt

public class GUI extends JFrame implements ActionListener {
    private BookingList bookingList;
    private FlightList flightList;

	//set up the different kinds of pop up windows the user will get
    final JFrame checkNotOk = new JFrame();
    final JFrame baggageOk = new JFrame();
    final JFrame baggageNotOK = new JFrame();
    final JFrame alreadyCheckedIn = new JFrame();

    //will be added in some of the Jlabels for aesthetic purposes
    public static final String Space = "              ";

	//set up the text fields and buttons
    JTextField lastNameField, bookingRefCodeField, baggageWeightField;
    JTextField baggageDimXField, baggageDimYField, baggageDimZField;
    JButton validateCheckInButton, closeKioskButton;


    // public GUI(BookingList bookingList, FlightList flightList)
    public GUI(BookingList bookingList, FlightList flightList)
    {
        this.bookingList = bookingList;
        this.flightList = flightList;

        // set up title of the window
        this.setTitle("Check in kiosk");

		//set up the three panels
        setupNorthPanel();
        setupCenterPanel();
        setupSouthPanel();

        // pack and set visible
        pack();
        setVisible(true);
        setResizable(false);
    }

    private void setupNorthPanel()
    {

    	//set up a new panel
		JPanel bookingPanel = new JPanel();
		bookingPanel.setLayout(new GridLayout(3, 1));
		
		//set up the last name label and field
		bookingPanel.add(new JLabel("Last name:"));
		lastNameField = new JTextField(10);
		bookingPanel.add(lastNameField);
		
		//set up the booking ref label and field
		bookingPanel.add(new JLabel("Booking Reference:"));
		bookingRefCodeField = new JTextField(7);
		bookingPanel.add(bookingRefCodeField);

		// set up the whole north panel containing the previous elements
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 1));
		northPanel.add(bookingPanel);
		this.add(northPanel, BorderLayout.NORTH);

    }

    private void setupCenterPanel()
    {

		JPanel baggagePanel = new JPanel();
		baggagePanel.setLayout(new GridLayout(7, 1));
		
		//add the labels and fields for all the baggage information
		baggagePanel.add(new JLabel("Please enter any baggage information"));
		baggagePanel.add(new JLabel(" below:"));
		
		baggagePanel.add(new JLabel("Baggage weight (KG):"));
		baggageWeightField = new JTextField(5);
		baggagePanel.add(baggageWeightField);
		
		baggagePanel.add(new JLabel("Baggage height (M):"));
		baggageDimXField = new JTextField(5);
		baggagePanel.add(baggageDimXField);

			
		baggagePanel.add(new JLabel(Space +"width:")); //adds previously defined space
		baggageDimYField = new JTextField(5);
		baggagePanel.add(baggageDimYField);
		
		
		baggagePanel.add(new JLabel(Space +"length:"));
		baggageDimZField = new JTextField(5);
		baggagePanel.add(baggageDimZField);
		
		// set up the whole center panel containing the previous elements
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 1));
		centerPanel.add(baggagePanel);
		this.add(centerPanel, BorderLayout.CENTER);

    }

    private void setupSouthPanel()
    {

		JPanel checkInOrClosePanel = new JPanel();
		checkInOrClosePanel.setLayout(new GridLayout(3, 1));
		
		//add 'validate check' in button
		validateCheckInButton = new JButton("Validate Check In");
		checkInOrClosePanel.add(validateCheckInButton);
		// specify action when button is pressed
		validateCheckInButton.addActionListener(this);
		
		//add a break between the two buttons to avoid clicking the wrong one
		checkInOrClosePanel.add(new JLabel(""));
		
		//add 'close kiosk' button
		closeKioskButton = new JButton("Close Kiosk");
		checkInOrClosePanel.add(closeKioskButton);
		// specify action when button is pressed
		closeKioskButton.addActionListener(this);

		// set up the whole south panel containing the previous elements
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 1));
		southPanel.add(checkInOrClosePanel);
		this.add(southPanel, BorderLayout.SOUTH);


    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
		//changes input to uppercase, so that there is no case sensitivity problem when comparing to the passenger list
        String lastName = lastNameField.getText().toUpperCase();
        String bookingCode = bookingRefCodeField.getText().toUpperCase();

		//if the user clicks on the 'validate check in' button
        if (e.getSource() == validateCheckInButton) {
			//if the passenger is on the list of passengers who booked a flight
            if (bookingList.hasPassengerBooked(lastName, bookingCode)) {
            	
                Booking booking = bookingList.findByBookingReference(bookingCode);
                Passenger passenger = booking.getPassenger();
                Flight flight = flightList.findByFlightCode(booking.getFlightCode());
                
                //if the user has already checked in
                if (booking.hasCheckedIn()==true){
                	JOptionPane.showMessageDialog(alreadyCheckedIn,
							"You've already checked in");
                	
                    //re-initialize all the fields to check in next customer
                    baggageDimXField.setText("");
                    baggageDimYField.setText("");
                    baggageDimZField.setText("");
                    lastNameField.setText("");
                    bookingRefCodeField.setText("");
                    baggageWeightField.setText("");
                	}
                
                //if user hasn't already checked in
                else{
                	// try/catch in case the user doesn't enter a number in a field where the input is supposed to be a number 
                    try {
                        // create a new baggage
                        Baggage baggage = new Baggage(Double.parseDouble(baggageWeightField.getText()),
                                Double.parseDouble(baggageDimXField.getText()),
                                Double.parseDouble(baggageDimYField.getText()),
                                Double.parseDouble(baggageDimZField.getText()));
                        double extraFee = baggage.calculateBagFee();
    					//if the baggage is over the weight limit/there's a fee, shows this message
                        if (extraFee > 0) {
                            JOptionPane.showMessageDialog(baggageOk, "Thank you for checking in." + "\n" +
                                    "For a baggage of this weight, you will have to pay an excess fee of £"
                                    + extraFee);
                        } 
                        //if there's no problem with the baggage, shows this message
                        else {
                            JOptionPane.showMessageDialog(baggageOk, "Thank you for checking in.");
                        }
                        
                        // add baggage to passenger
                        passenger.setBaggage(baggage);
                        System.out.println(passenger.getBaggage());
                        // add passenger to corresponding flight
                        flight.addPassenger(passenger);
                        //shows the passenger as "checked in"
                        booking.setCheckedIn(true);
                  
                        //re-initialize all the fields to check in next customer
                        baggageDimXField.setText("");
                        baggageDimYField.setText("");
                        baggageDimZField.setText("");
                        lastNameField.setText("");
                        bookingRefCodeField.setText("");
                        baggageWeightField.setText("");
                    } 
    				//if there's a problem with the information entered by the user (empty field, not a double)
                    catch (Exception ex) {
                      //  ex.printStackTrace();
                     //   JOptionPane.showMessageDialog(baggageNotOK, ex.getMessage());
    					JOptionPane.showMessageDialog(baggageNotOK,
    							"Please enter correct information for your baggage's weight and dimension");
                    }

                } 
                }
                
				
			//if the passenger isn't found in the list of passengers
            else {
                JOptionPane.showMessageDialog(checkNotOk,
                        "Sorry, we could not find you. Please re-enter your details.");
            }
        }
		//if the user clicks the 'close kiosk' button, the report is generated and the GUI closes 
        if (e.getSource() == closeKioskButton) {
            flightList.printReport("report.txt");
            JOptionPane.showMessageDialog(null, "Report is printed!");
            System.exit(0);
        }
    }

}