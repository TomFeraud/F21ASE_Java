package controllers;

import models.Simulation;
import views.TestGUI;

public class TestController {

	private TestGUI view; // GUI to allow user to set the time

	private Simulation sim; // clock model stores the time

	public TestController(TestGUI view, Simulation sim) {
		this.view = view;
		this.sim = sim;
	}

}
