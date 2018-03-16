package F21ASE_Stage2;

import java.util.ArrayList;

public class DeskList {
	private ArrayList<Desk> desks;
	
	
	public DeskList() {
		this.desks = new ArrayList<Desk> ();
	}
	
	public void add(Desk l) {
		desks.add(l);
	}
	
	public Desk find(int id) {
		for (Desk d : desks) {
			if (d.getDeskNumber()== id){
				return d;
			}
		}
		return null;
	}
	
	public Desk get(int i) {
		return desks.get(i);
	}
	
	
	public int getSize() {
		return desks.size();
	}

}
