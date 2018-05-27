/**
 * 
 */
package maze;

/**
 * Class for the search states implements the State interface.
 * The constructor receives the state position coordinates, the
 * lantern capacity and the length taken to reach the current state.
 * The id is computing to ensure the all states with the same coordinates
 * and lantern capacity have the same id and different if otherwise.
 * 
 * @author Andre Ferreira, 45242
 * @author Andre Wemans, 48432
 *
 */
public class StateClass implements State {
	
	//INSTANCE VARIABLES
	private int id;
	//private int xx;
	//private int yy;
	private int capacity;
	private int length;
	private Point position;

	public StateClass(int x, int y, int capacity, int length) {
		id = capacity * 10000 + x * 100 + y;
		position = new PointClass(x, y);
		//xx = x;
		//yy = y;
		this.capacity = capacity;
		this.length = length;
	}

	/*
	 * (non-Javadoc)
	 * @see maze.State#getID()
	 */
	@Override
	public int getID() {
		
		return id;
	}

	@Override
	public int getLength() {
		
		return length;
	}

	/*
	 * (non-Javadoc)
	 * @see maze.State#getX()
	 */
	@Override
	public int getX() {
		
		return position.getX();
	}

	/*
	 * (non-Javadoc)
	 * @see maze.State#getY()
	 */
	@Override
	public int getY() {
		
		return position.getY();
	}

	/*
	 * (non-Javadoc)
	 * @see maze.State#getCapacity()
	 */
	@Override
	public int getCapacity() {
		
		return capacity;
	}

	/*
	 * (non-Javadoc)
	 * @see maze.State#addVector(maze.Point)
	 */
	@Override
	public Point addVector(Point vector) {
		
		return position.addVector(vector);
	}

}
