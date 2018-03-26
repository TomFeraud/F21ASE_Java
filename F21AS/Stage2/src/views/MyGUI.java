package views;

import model.Simulation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyGUI extends JFrame {

	private JTextField text = new JTextField();
	private Simulation sim;

	/**
	 * Constructor
	 *
	 * @param sim Simulation
	 */
	public MyGUI(Simulation sim) {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBackground(Color.white);
	
		setupNorthPanel(sim);
		setupCenterPanel(sim);
		setupSouthPanel(sim);

		setSize(1200, 600);
		setVisible(true);
		setLocationRelativeTo(null);
	}

	/**
	 * Setup North Panel
	 *
	 * @param sim Simulation
	 */
	private void setupNorthPanel(Simulation sim) {
		// set up a new panel
		JPanel queueInfo = new JPanel();
		queueInfo.setLayout(new GridLayout(1, 3));
		
		queueInfo.add(new QueueDisplay(sim.getQueue(), sim.getProducer(), sim.getConsumerList()));

		// set up the whole north panel containing the previous elements
		JPanel northPanel = new JPanel();
		northPanel.setLayout(new GridLayout(1, 1));
		northPanel.add(queueInfo);
		this.add(northPanel, BorderLayout.NORTH);

	}

	/**
	 * Setup Central Panel
	 *
	 * @param sim Simulation
	 */
	private void setupCenterPanel(Simulation sim) {
	

		JPanel deskInfo = new JPanel();
		deskInfo.setLayout(new FlowLayout());

		//for (int i = 0; i < sim.getConsumerList().getSize(); i++) {			
		for (int i = 0; i < sim.getNbrDesk(); i++) {
				deskInfo.add(new DeskDisplay(sim.getConsumerList().get(i)));
		}
		
		
		// set up the whole center panel containing the previous elements
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new GridLayout(1, 1));
		centerPanel.add(deskInfo);
		this.add(centerPanel, BorderLayout.CENTER);
		}

	/**
	 * Setup South Panel
	 *
	 * @param sim Simulation
	 */
	private void setupSouthPanel(Simulation sim) {
		this.sim = sim;
		JPanel flightInfo = new JPanel();
		flightInfo.setLayout(new GridLayout(2, 3));
		
		for (int i = 0; i < sim.getNbrFlight(); i++) {
//			if (i == 0) {
//				flightInfo.add(new FlightDisplay(sim.getFlightList().findByFlightCode("FR1286"), sim.getConsumerList()));
//			}
//			if (i == 1) {
//				flightInfo.add(new FlightDisplay(sim.getFlightList().findByFlightCode("FR1286"), sim.getConsumerList()));
//			}
//			if (i == 2) {
//				flightInfo.add(new FlightDisplay(sim.getFlightList().findByFlightCode("FR1286"), sim.getConsumerList()));
//			}
//			if (i == 3){
//				flightInfo.add(new FlightDisplay(sim.getFlightList().findByFlightCode("FR1286"), sim.getConsumerList()));
//			}
//			if (i == 4){
//				flightInfo.add(new FlightDisplay(sim.getFlightList().findByFlightCode("FR1286"), sim.getConsumerList()));
//			}
//			if (i == 5){
//				flightInfo.add(new FlightDisplay(sim.getFlightList().findByFlightCode("FR1286"), sim.getConsumerList()));
//			}
			flightInfo.add(new FlightDisplay(sim.getFlightList().getFlightByIndex(i), sim.getConsumerList()));

		}

		// set up the whole north panel containing the previous elements
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new GridLayout(1, 1));
		southPanel.add(flightInfo);
		this.add(southPanel, BorderLayout.SOUTH);

	}

	public String getText() {
		return text.getText();
	}
	
}







