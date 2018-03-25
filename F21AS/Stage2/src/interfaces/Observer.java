package interfaces;

public interface Observer {
	
	/**
	 * Tell Observer to update itself
	 */
	public void update();

	public void update(String[] info);
}
