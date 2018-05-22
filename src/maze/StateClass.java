/**
 * 
 */
package maze;

/**
 * @author Andre Ferreira, 45242
 * @author Andre Wemans, 48432
 *
 */
public class StateClass implements State {
	
	//INSTANCE VARIABLES
	private int id;
	private int xx;
	private int yy;
	private int capacity;
	private int length;

	public StateClass(int x, int y, int capacity, int length) {
		id = capacity * 10000 + x * 100 + y;
		xx = x;
		yy = y;
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
		
		return xx;
	}

	/*
	 * (non-Javadoc)
	 * @see maze.State#getY()
	 */
	@Override
	public int getY() {
		
		return yy;
	}

	/*
	 * (non-Javadoc)
	 * @see maze.State#getCapacity()
	 */
	@Override
	public int getCapacity() {
		
		return capacity;
	}

}
