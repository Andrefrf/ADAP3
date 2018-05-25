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
	
	//CONSTANTS
	Point[] neighborers = {new PointClass(-1, 0), new PointClass(1, 0), new PointClass(0, -1),
			new PointClass(0, 1)};
	
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
			
			//If it wasn't visited before add to visited and get vertical and horizontal neighbors
			if (visited.putIfAbsent(state.getID(), state) == null){
				goalState = computeNeighborers(state, search);
				if(goalState != null)
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
		boolean lampAtPosition, isLighted;
		State newState;
		int capacity, newCapacity;
		int length;
		Point newPositon;
		int newX, newY;
		
		capacity = state.getCapacity();
		length = state.getLength();
		lampAtPosition = map[state.getY()][state.getX()] == -1;
		
		//Finds next possible states and adds them to the queue
		for (Point vector : neighborers) {
			newPositon = state.addVector(vector);
			newX = newPositon.getX();
			newY = newPositon.getY();
			if (newPositon.isInSide(width, height)) {
				//Check if there is a lamp to cross to next point
				isLighted = lampAtPosition || (map[newY][newX] == -1);
				//If there is a lamp or jack has a lantern
				if(isLighted || capacity > 0) {
					//It the crossing was using a lantern reduces the capacity
					newCapacity = (!isLighted) ? (capacity - 1) : capacity;
					//Creates the new state at the newPosition
					newState = new StateClass(newX, newY, Math.max(newCapacity, map[newY][newX]), length + 1);
					//If the new state is at the goal position returns the state
					if (isGoal(newState))
						return newState;
					//If it isn't adds it to the queue
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
