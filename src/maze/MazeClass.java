/**
 * 
 */
package maze;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @author Andre Ferreira, 45242
 * @author Andre Wemans, 48432
 *
 */
public class MazeClass implements Maze {
	
	//INSTANCE VARIABLES
	private int[][] map;
	private int height;
	private int width;

	public MazeClass(int height, int width) {
		map = new int[height][width];
		this.height = height;
		this.width = width;
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
		State initial = new StateClass(0, 0, 0, 0);
		Queue<State> search = new LinkedList<State>();
		search.add(initial);
		Map<Integer, State> visited = new HashMap(height * width);
		
		return 0;
	}

}
