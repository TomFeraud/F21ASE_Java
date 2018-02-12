package F21ASE_Stage1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//quand baggage validé -> checkin à true dans booking.txt
//					   -> les champs se re-vident


public class GUI extends JFrame implements ActionListener {

	private BookingList bookingList;
	// private FlightList flightList;

	final JFrame checkOk = new JFrame();
	final JFrame checkNotOk = new JFrame();
	final JFrame baggageOk = new JFrame();
	final JFrame baggageNotOK = new JFrame();
	
	//will be added in some of the Jlabels for aesthetic purposes 
	public static final String Space = "              ";

	JTextField lastNameField, bookingRefCodeField, baggageWeightField;
	
	JTextField baggageDimXField, baggageDimYField, baggageDimZField;
	JButton validateCheckInButton, closeKioskButton;
	
	

	// public GUI(BookingList bookingList, FlightList flightList)
	public GUI(BookingList bookingList) {
		this.bookingList = bookingList;

		// set up title of the window
		this.setTitle("Check in kiosk");
	
		setupNorthPanel();
		setupCenterPanel();
		setupSouthPanel();

		// setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

		// pack and set visible
		pack();
		setVisible(true);
		setResizable(false);
	}

	private void setupNorthPanel() {

		JPanel bookingPanel = new JPanel();
		bookingPanel.setLayout(new GridLayout(3, 1));
		
		bookingPanel.add(new JLabel("Last name:"));
		lastNameField = new JTextField(10);
		bookingPanel.add(lastNameField);
		
		bookingPanel.add(new JLabel("Booking Reference:"));
		bookingRefCodeField = new JTextField(7);
		bookingPanel.add(bookingRefCodeField);
		
		

		// set up the whole north panel containing the 2 previous elements
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 1));
		northPanel.add(bookingPanel);
		this.add(northPanel, BorderLayout.NORTH);

	}

	private void setupCenterPanel() {

		JPanel baggagePanel = new JPanel();
		baggagePanel.setLayout(new GridLayout(7, 1));
		
		baggagePanel.add(new JLabel("Please enter any baggage information"));
		baggagePanel.add(new JLabel(" below:"));
		
		baggagePanel.add(new JLabel("Baggage weight (kg):"));
		baggageWeightField = new JTextField(5);
		baggagePanel.add(baggageWeightField);
		
		baggagePanel.add(new JLabel("Baggage height (cm):"));
		baggageDimXField = new JTextField(5);
		baggagePanel.add(baggageDimXField);

			
		baggagePanel.add(new JLabel(Space +"width:"));
		baggageDimYField = new JTextField(5);
		baggagePanel.add(baggageDimYField);
		
		
		baggagePanel.add(new JLabel(Space +"length:"));
		baggageDimZField = new JTextField(5);
		baggagePanel.add(baggageDimZField);
		
		// set up the whole center panel containing the 2 previous elements
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 1));
		centerPanel.add(baggagePanel);
		this.add(centerPanel, BorderLayout.CENTER);

	}
	
	private void setupSouthPanel() {

		JPanel checkInOrClosePanel = new JPanel();
		checkInOrClosePanel.setLayout(new GridLayout(3, 1));
		
		validateCheckInButton = new JButton("Validate Check In");
		checkInOrClosePanel.add(validateCheckInButton);
		// specify action when button is pressed
		validateCheckInButton.addActionListener(this);
		
		//add a break between the two buttons to avoid clicking the wrong one
		checkInOrClosePanel.add(new JLabel(""));
		
		closeKioskButton = new JButton("Close Kiosk");
		checkInOrClosePanel.add(closeKioskButton);
		// specify action when button is pressed
		closeKioskButton.addActionListener(this);

		// set up the whole center panel containing the 2 previous elements
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 1));
		southPanel.add(checkInOrClosePanel);
		this.add(southPanel, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String lastName = lastNameField.getText().toUpperCase();
		String bookingCode = bookingRefCodeField.getText().toUpperCase();

		if (e.getSource() == validateCheckInButton)
			
			if (bookingList.hasPassengerBooked(lastName, bookingCode)) {
				Passenger passenger = bookingList.findByBookingReference(bookingCode);
				try{
					Baggage baggage = new Baggage(Double.parseDouble(baggageWeightField.getText()), 
							Double.parseDouble(baggageDimXField.getText()),
							Double.parseDouble(baggageDimYField.getText()), Double.parseDouble(baggageDimZField.getText()));
					passenger.setBaggage(baggage);
					
					if (Double.parseDouble(baggageWeightField.getText())>20){
						JOptionPane.showMessageDialog(baggageOk, "Thank you for checking in." +"\nFor a baggage of this weight, you will have to pay an excess fee of £" 
					+Baggage.calculateBagFee(Double.parseDouble(baggageWeightField.getText())) );
					}
					else{
						JOptionPane.showMessageDialog(baggageOk, "Thank you for checking in.");
					};
					System.out.println(passenger.getBaggage());	
				}
				catch(Exception baggage){
					JOptionPane.showMessageDialog(baggageNotOK,
							"Please enter correct information for your baggage's weight and dimension");
				}
				
			} 
			
			else {
				JOptionPane.showMessageDialog(checkNotOk,
						"Sorry, we could not find you. Please re-enter your details.");
			}
		
		if (e.getSource() == closeKioskButton) {
			System.exit(0);
		}
	}

}