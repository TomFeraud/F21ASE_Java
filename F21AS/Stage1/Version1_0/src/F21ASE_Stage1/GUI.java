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

	JTextField lastNameField, bookingRefCodeField, baggageWeightField;
	JButton searchBookingButton, addBaggageButton;

	// public GUI(BookingList bookingList, FlightList flightList)
	public GUI(BookingList bookingList) {
		this.bookingList = bookingList;

		// set up title of the window
		this.setTitle("Check in window");

		// call the setup functions for the three panels
		setupNorthPanel();
		setupCenterPanel();
		// setupSouthPanel();

		// setDefaultCloseOperation(this.DO_NOTHING_ON_CLOSE);

		// pack and set visible
		pack();
		setVisible(true);
	}

	private void setupNorthPanel() {

		JPanel bookingPanel = new JPanel();
		bookingPanel.setLayout(new GridLayout(1, 4));
		bookingPanel.add(new JLabel("Enter your last name"));
		lastNameField = new JTextField(10);
		bookingPanel.add(lastNameField);
		bookingRefCodeField = new JTextField(7);
		bookingPanel.add(bookingRefCodeField);
		searchBookingButton = new JButton("Check booking");
		bookingPanel.add(searchBookingButton);
		// specify action when button is pressed
		searchBookingButton.addActionListener(this);

		// set up the whole north panel containing the 2 previous elements
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 1));
		centerPanel.add(bookingPanel);
		this.add(centerPanel, BorderLayout.NORTH);

	}

	private void setupCenterPanel() {

		JPanel baggagePanel = new JPanel();
		baggagePanel.setLayout(new GridLayout(1, 3));
		baggagePanel.add(new JLabel("Enter the baggage' weight"));
		baggageWeightField = new JTextField(5);
		baggagePanel.add(baggageWeightField);
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
				JOptionPane.showMessageDialog(checkOk, "Welcome " + lastName + ". Add your baggage below please");

			} else {
				JOptionPane.showMessageDialog(checkNotOk,
						"Sorry, we could not find you. Please re-enter your details.");
			}
		}
		if (e.getSource() == addBaggageButton)
			if (bookingList.hasPassengerBooked(lastName, bookingCode)) {
				Passenger passenger = bookingList.findByBookingReference(bookingCode);
				Baggage baggage = new Baggage(Integer.parseInt(baggageWeightField.getText()), 0.0);
				passenger.setBaggage(baggage);
				JOptionPane.showMessageDialog(baggageOk, "Thank you.");
				System.out.println(passenger.getBaggage());

			} else {
				JOptionPane.showMessageDialog(checkNotOk,
						"Sorry, we could not find you. Please re-enter your details.");
			}

	}

}
