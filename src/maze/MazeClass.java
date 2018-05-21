/**
 * 
 */
package maze;

/**
 * @author Andre Ferreira, 45242
 * @author Andre Wemans, 48432
 *
 */
public class MazeClass implements Maze {
	
	//INSTANCE VARIABLES
	private int[][] map;

	public MazeClass(int height, int width) {
		map = new int[height][width];
	}

	/*
	 * (non-Javadoc)
	 * @see maze.Maze#addLamp(int, int)
	 */
	@Override
	public void addLamp(int i, int h) {
		map[i][h] = -1;
	}

	/*
	 * (non-Javadoc)
	 * @see maze.Maze#darkLantern(int, int, int)
	 */
	@Override
	public void darkLantern(int i, int h, int capacity) {
		map[i][h] = capacity;
		
	}

	/*
	 * (non-Javadoc)
	 * @see maze.Maze#solve()
	 */
	@Override
	public int solve() {
		// TODO Auto-generated method stub
		return 0;
	}

}
