package F21ASE_Stage1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GUI extends JFrame implements ActionListener {

	private BookingList bookingList;
	// private FlightList flightList;

	final JFrame checkOk = new JFrame();
	final JFrame checkNotOk = new JFrame();
	final JFrame baggageOk = new JFrame();
	final JFrame baggageNotOK = new JFrame();

	JTextField lastNameField, bookingRefCodeField, baggageWeightField;
	JTextField baggageDimXField, baggageDimYField, baggageDimZField;
	JButton searchBookingButton, addBaggageButton;

	// public GUI(BookingList bookingList, FlightList flightList)
	public GUI(BookingList bookingList) {
		this.bookingList = bookingList;

		// set up title of the window
		this.setTitle("Check in kiosk");

		setupNorthPanel();
		setupCenterPanel();

		// setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

		// pack and set visible
		pack();
		setVisible(true);
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
		
		searchBookingButton = new JButton("Check booking");
		bookingPanel.add(searchBookingButton);
		
		// specify action when button is pressed
		searchBookingButton.addActionListener(this);

		// set up the whole north panel containing the 2 previous elements
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(2, 1));
		northPanel.add(bookingPanel);
		this.add(northPanel, BorderLayout.NORTH);

	}

	private void setupCenterPanel() {

		JPanel baggagePanel = new JPanel();
		baggagePanel.setLayout(new GridLayout(7, 1));
		
		baggagePanel.add(new JLabel("Baggage weight (kg):"));
		baggageWeightField = new JTextField(5);
		baggagePanel.add(baggageWeightField);
		
		baggagePanel.add(new JLabel("Baggage dimensions (cm):"));
		baggageDimXField = new JTextField(5);
		baggagePanel.add(baggageDimXField);

		//fix this	
		baggagePanel.add(new JLabel(""));
		baggageDimYField = new JTextField(5);
		baggagePanel.add(baggageDimYField);
		
		//fix this
		baggagePanel.add(new JLabel(""));
		baggageDimZField = new JTextField(5);
		baggagePanel.add(baggageDimZField);
		
		
		
		addBaggageButton = new JButton("Add baggage");
		baggagePanel.add(addBaggageButton);
		// specify action when button is pressed
		addBaggageButton.addActionListener(this);

		// set up the whole center panel containing the 2 previous elements
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 1));
		centerPanel.add(baggagePanel);
		this.add(centerPanel, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String lastName = lastNameField.getText();
		String bookingCode = bookingRefCodeField.getText();
		
		if (e.getSource() == searchBookingButton) {
			if (bookingList.hasPassengerBooked(lastName, bookingCode)) {
				JOptionPane.showMessageDialog(checkOk, "Thank you for checking in, " + lastName + 
						". Please add your baggage information below.");

			} else {
				JOptionPane.showMessageDialog(checkNotOk,
						"Sorry, we could not find you. Please re-enter your details.");
			}
		}
		
		if (e.getSource() == addBaggageButton)
			if (bookingList.hasPassengerBooked(lastName, bookingCode)) {
				Passenger passenger = bookingList.findByBookingReference(bookingCode);
				try{
					Baggage baggage = new Baggage(Double.parseDouble(baggageWeightField.getText()), 
							Double.parseDouble(baggageDimXField.getText()),
							Double.parseDouble(baggageDimYField.getText()), Double.parseDouble(baggageDimZField.getText()));
					passenger.setBaggage(baggage);
					JOptionPane.showMessageDialog(baggageOk, "Thank you.");
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
	}

}
