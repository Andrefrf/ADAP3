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
	
	/**
	 * Get the state x coordinate
	 * @return State x coordinate
	 */
	int getX();
	
	/**
	 * Get the state y coordinate
	 * @return State y coordinate
	 */
	int getY();
	
	/**
	 * Get the lantern capacity
	 * @return The lantern capacity
	 */
	int getCapacity();
	
	/**
	 * Adds a vector to the state position returning the resulting point
	 * @param vector The vector to be added
	 * @return The resulting point of adding the state position with the vector 
	 */
	Point addVector(Point vector);

}
