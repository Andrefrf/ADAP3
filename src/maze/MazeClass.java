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
		int lantern = Math.max(map[0][0], 0);
		State state = new StateClass(0, 0, lantern, 0);
		Queue<State> search = new LinkedList<State>();
		Map<Integer, State> visited = new HashMap<Integer, State>(height * width);
		boolean found = false;
		State goalState;
		
		if (isGoal(state))
			found = true;
		
		//Adds initial state to queue
		search.add(state);
		
		while (!search.isEmpty() && !found) {
			//Takes next element in queue
			state = search.poll();
			visited.put(state.getID(), state);
			
			//If it wasn't visited before
			if (!visited.containsKey(state.getID())) {
				goalState = computeNeighborers(state, search);
				if (goalState != null)
					return goalState.getLength();
			}
			
		}
		
		
		
		return -1;
	}

	/**
	 * Computes the reachable neighborers states given the current state. It adds the new states
	 * to the queue. If one of the new states is the goal state it returns it.
	 * @param state The current state to which look for the neighborers states
	 * @param search The queue of states to search
	 * @return The goal state in case it is produced, null otherwise
	 */
	private State computeNeighborers(State state, Queue<State> search) {
		boolean lamp;
		int x;
		int y;
		State newState;
		int capacity;
		int length;
		x = state.getX();
		y = state.getY();
		lamp = map[y][x] == -1;
		capacity = state.getCapacity();
		length = state.getLength();
		//Finds next possible states and adds them to the queue
		//Horizontal neighbors 
		for (int i = -1; i <= 1; i = i + 2) {
			//If the neighbors are inside the map
			if ((x + i) >=0 && (x + i) < width) {
				lamp = lamp || (map[y][x + i] == -1);
				//If there is light to travel to neighbor
				if (lamp || capacity > 0) {
					//If it was using the lantern
					if (!lamp) {
						capacity--;
					}
					newState = new StateClass(x + i, y, Math.max(capacity, map[y][x + i]), length++);
					if (isGoal(newState))
						return newState;
					search.add(newState);
				}
			}
		}
		//Horizontal neighbors 
		for (int i = -1; i <= 1; i = i + 2) {
			//If the neighbors are inside the map
			if ((y + i) >=0 && (y + i) < height) {
				lamp = lamp || (map[y + i][x] == -1);
				//If there is light to travel to neighbor
				if (lamp || capacity > 0) {
					//If it was using the lantern
					if (!lamp) {
						capacity--;
					}
					newState = new StateClass(x, y + i, Math.max(capacity, map[y + i][x]), length++);
					if (isGoal(newState))
						return newState;
					search.add(newState);
				}
			}
		}
		
		return null;
	}

	/**
	 * Checks if a given state is the goal state
	 * @param state The state to be checked
	 * @return True if state is the goal state, false otherwise
	 */
	private boolean isGoal(State state) {
		return state.getX() == width - 1 && state.getY() == height - 1;
	}

}
