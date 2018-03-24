package F21ASE_Stage2;

import controllers.TestController;
import model.Simulation;
import views.TestGUI;

public class Main {

	public static void main(String[] args) {

		//Manager manager = new Manager();
		//manager.run();
		
		Simulation sim = new Simulation(); 
		//TestGUI view = new TestGUI(sim.getQueue(), sim.getDeskTest1());
		TestGUI view = new TestGUI(sim);

		TestController controller = new TestController(view,sim);
	}

}
