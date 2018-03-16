package views;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

import F21ASE_Stage2.Desk;
import F21ASE_Stage2.Queue;
import models.Simulation;

public class TestGUI extends JFrame {

	private JTextField text = new JTextField();

	public TestGUI(Simulation sim) {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		// QUEUE
		add(new QueueDisplay(sim.getQueue()), BorderLayout.NORTH);
		// DESK(s)
		for (int i = 0; i < sim.getDeskList().getSize(); i++) {
			if (i == 0) {
				//DeskDisplay deskD1 = new DeskDisplay(sim.getDeskList().get(i));
				add(new DeskDisplay(sim.getDeskList().get(i)), BorderLayout.WEST);
			}
			if (i == 1) {
				add(new DeskDisplay(sim.getDeskList().get(i)), BorderLayout.CENTER);
			}
			if (i == 2) {
				add(new DeskDisplay(sim.getDeskList().get(i)), BorderLayout.EAST);

			}
		}
		// PLANES
		System.out.println(sim.getFlight1());
		// add(new FlightDisplay(sim.getFlight1(), sim.getDeskList().get(0)),
		// BorderLayout.SOUTH);
		add(new FlightDisplay(sim.getFlight1()), BorderLayout.SOUTH);

		setSize(700, 700);
		setVisible(true);
	}

	public String getText() {
		return text.getText();
	}

}
