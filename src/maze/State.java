/**
 * 
 */
package maze;

/**
 * @author Andre Ferreira, 45242
 * @author Andre Wemans, 48432
 *
 */
public interface State {
	
	/**
	 * Gets the State ID
	 * @return State ID
	 */
	int getID();
	
	/**
	 * Get the path length taken to reach the current state
	 * @return The path length taken to reach the current state
	 */
	int getLength();

}
