package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.Simulation;
import views.DeskDisplay;
import views.MyGUI;

public class TestController {

	private MyGUI view; // GUI to allow user to set the time

	private Simulation sim; // clock model stores the time

	public TestController(MyGUI view, Simulation sim) {
		this.view = view;
		this.sim = sim;
	}
}
