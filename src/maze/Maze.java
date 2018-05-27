/**
 * 
 */
package maze;

/**
 * Interface for the classes which receive the problem data from the main 
 * and computes the result to send to user.
 * 
 * @author Andre Ferreira, 45242
 * @author Andre Wemans, 48432
 *
 */
public interface Maze {

	/**
	 * Add a lamp in the city map with the coordinates i,h
	 * @param yCoordinate The y coordinate
	 * @param xCoordinate The x coordinate
	 */
	void addLamp(int yCoordinate, int xCoordinate);

	/**
	 * Adds a latern in the city map with the coordinate i,h and given capacity
	 * @param i The y coordinate
	 * @param h The x coordinate
	 * @param capacity How many streets the lamp can be used
	 */
	void darkLantern(int i, int h, int capacity);

	/**
	 * Gets the shortest path from Jack's work to Jack's home
	 * @return The shortest path from Jack's work to Jack's home, or -1 if it can't find a path
	 */
	int solve();

}
