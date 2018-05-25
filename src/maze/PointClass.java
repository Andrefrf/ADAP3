/**
 * 
 */
package maze;

/**
 * Class for defining points in the map. Implements the Point interface.
 * 
 * The constructor receives the X and Y coordinates.
 * 
 * @author Andre Ferreira, 45242
 * @author Andre Wemans, 48432
 *
 */
public class PointClass implements Point {
	
	private int x;
	private int y;
	
	public PointClass(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/* (non-Javadoc)
	 * @see maze.Point#getX()
	 */
	@Override
	public int getX() {
		
		return x;
	}

	/* (non-Javadoc)
	 * @see maze.Point#getY()
	 */
	@Override
	public int getY() {
		
		return y;
	}

	/*
	 * (non-Javadoc)
	 * @see maze.Point#addVector(maze.Point)
	 */
	@Override
	public Point addVector(Point vector) {
		
		return new PointClass(this.x + vector.getX(), this.y + vector.getY());
	}

	/*
	 * (non-Javadoc)
	 * @see maze.Point#isInSide(int, int)
	 */
	@Override
	public boolean isInSide(int width, int height) {
		
		return (this.x >= 0 && this.x < width && this.y >= 0 && this.y < height);
	}

}
