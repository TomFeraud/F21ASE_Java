package controllers;

import model.Simulation;
import views.MyGUI;

public class TestController {

	private MyGUI view; // GUI to allow user to set the time

	private Simulation sim; // clock model stores the time

	public TestController(MyGUI view, Simulation sim) {
		this.view = view;
		this.sim = sim;
	}

}
