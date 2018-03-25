package interfaces;

public interface Observer {
	
	/**
	 * Tell Observer to update itself
	 */
	void update();
	/**
	 * Tell Observer to update itself
	 * @param info
	 */
	void update(String[] info);
}
