package F21ASE_Stage2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author Ombeline Gabriel
 * @version 1.0
 */

@SuppressWarnings("serial")
public class GUI extends JFrame implements ActionListener {
//	private BookingList bookingList;
//	private FlightList flightList;
//	private Queue queue;	
	public GUI() {
		
		// set up title of the window
		this.setTitle("Check in desks");

		// the user can't close the GUI using the x button
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		// set up the three panels
		setupNorthPanel();
		setupCenterPanel();
		setupSouthPanel();


		// pack and set visible
		pack();
		setVisible(true);
		setResizable(false);
	}

	private JLabel chooseSpeed = new JLabel("Choose the simulation speed: ");
	private JLabel queueL = new JLabel("Number of people in the queue: ");
	private JTextField speed = new JTextField();
	private JTextField queueLength = new JTextField();
	private JButton startButton = new JButton("Start simulation");
	private JButton closeButton = new JButton("Close");
	
	private void setupNorthPanel() {

		// set up a new panel
		JPanel controls = new JPanel();
		controls.setLayout(new GridLayout(2, 2));
		
		controls.add(chooseSpeed);
		controls.add(speed);
		controls.add(new JSeparator());
		controls.add(new JSeparator());


		// set up the whole north panel containing the previous elements
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 1));
		northPanel.add(controls);
		this.add(northPanel, BorderLayout.NORTH);

	}
	
	private void setupCenterPanel() {

		JPanel queueInfo = new JPanel();
		queueInfo.setLayout(new GridLayout(1, 2));

		queueInfo.add(queueL);
		queueInfo.add(queueLength);
		queueLength.setEditable(false);

		
		// set up the whole center panel containing the previous elements
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 1));
		centerPanel.add(queueInfo);
		this.add(centerPanel, BorderLayout.CENTER);

	}

	
	private void setupSouthPanel() {

		// set up a new panel
		JPanel startAndClose = new JPanel();
		startAndClose.setLayout(new GridLayout(3, 1));
		
		startAndClose.add(new JSeparator());
		startAndClose.add(startButton);
		startButton.addActionListener(this);
		startAndClose.add(closeButton);
		closeButton.addActionListener(this);

		// set up the whole north panel containing the previous elements
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 1));
		southPanel.add(startAndClose);
		this.add(southPanel, BorderLayout.SOUTH);

	}

	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource() == startButton) {
			//start the simulation

		}
		
		if (e.getSource() == closeButton) {
			//flightList.printReport("report.txt");
			//JOptionPane.showMessageDialog(null, "Report is printed!");
			System.exit(0);
		}
	}

}
	

	
	
	
/*
	public GUI(BookingList bookingList, FlightList flightList) {
		this.bookingList = bookingList;
		this.flightList = flightList;

		queue.registerObserver(Queue queue);
		
		// set up title of the window
		this.setTitle("Check in kiosk");

		// the user can't close the GUI using the x button
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);

		// set up the three panels
		setupNorthPanel();
		setupCenterPanel();
		setupSouthPanel();

		// pack and set visible
		pack();
		setVisible(true);
		setResizable(false);
	}

	private void setupNorthPanel() {

		// set up a new panel
		JPanel bookingPanel = new JPanel();
		bookingPanel.setLayout(new GridLayout(3, 1));

		// set up the whole north panel containing the previous elements
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 1));
		northPanel.add(bookingPanel);
		this.add(northPanel, BorderLayout.NORTH);

	}

	private void setupCenterPanel() {

		JPanel baggagePanel = new JPanel();
		baggagePanel.setLayout(new GridLayout(7, 1));


		// set up the whole center panel containing the previous elements
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 1));
		centerPanel.add(baggagePanel);
		this.add(centerPanel, BorderLayout.CENTER);

	}


	private void setupSouthPanel() {

		JPanel checkInOrClosePanel = new JPanel();
		checkInOrClosePanel.setLayout(new GridLayout(3, 1));

		// add 'close kiosk' button
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

*/
