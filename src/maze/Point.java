/**
 * 
 */
package maze;

/**
 * @author Andre Ferreira, 45242
 * @author Andre Wemans, 48432
 *
 */
public interface Point {
	
	/**
	 * Get the point's x coordinate
	 * @return The point's x coordinate
	 */
	int getX();
	
	/**
	 * Get the point's y coordinate
	 * @return The point's y coordinate
	 */
	int getY();
	
	/**
	 * Adds a vector to the point giving the resulting point
	 * @param vector The vector to add
	 * @return The point resulting by adding the vector to the point
	 */
	Point addVector(Point vector);
	
	/**
	 * Tests if point is inside a boundary defined by the rectangle between (0,0) and
	 * (width - 1, height - 1)
	 * @param width The limit width of defining area
	 * @param height The limit height of defining area
	 * @return
	 */
	boolean isInSide(int width, int height);

}
