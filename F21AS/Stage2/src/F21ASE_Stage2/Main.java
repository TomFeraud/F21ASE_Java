package F21ASE_Stage2;

import controller.TestController;
import model.Simulation;
import views.MyGUI;

public class Main {

	public static void main(String[] args) {

		
		Simulation sim = new Simulation(); 
		MyGUI view = new MyGUI(sim);

		TestController controller = new TestController(view,sim);
	}

}
