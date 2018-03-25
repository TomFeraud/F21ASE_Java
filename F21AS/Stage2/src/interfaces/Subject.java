package interfaces;

/**
 * The Subject part of the Observer pattern.
 * All classes implementing this interface MUST have these methods.
 */
public interface Subject {
	
	/**
	 * Register an observer with this subject
	 */
	void registerObserver(Observer obs);

	/**
	 * De-register an observer with this subject
	 */
	void removeObserver(Observer obs);

	/**
	 * Inform all registered observers that there's been an update
	 */
	void notifyObservers();

	/**
	 * Inform all registered observers that there's been an update
	 * @param info
	 */
	void notifyObservers(String[] info);
}
