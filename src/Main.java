import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import maze.Maze;
import maze.MazeClass;

/**
 * Main class for the Jack-o'-Lantern problem. It expects the user to input the
 * width and height of the map following by line representing the intersections
 * of the map where '0' represents a normal intersection, '*' an intersection 
 * with a lamp and a positive number an intersection with a lantern with a
 * Capacity given by the number.
 * 
 * @author Andre Ferreira, 45242
 * @author Andre Wemans, 48432
 *
 */

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] input = reader.readLine().split(" ");
		int width = Integer.parseInt(input[0]);
		int height = Integer.parseInt(input[1]);
		Maze jack = new MazeClass(height, width);
		
		for(int i = 0; i<height;i++) {
			input = reader.readLine().split(" ");
			for(int h = 0;h<width;h++) {
				if(input[h].equals("*")) {
					jack.addLamp(i, h);
				}
				else if (!input[h].equals("0")) {
					jack.darkLantern(i, h, Integer.parseInt(input[h]));
				}
			}
		}
		
		System.out.println(jack.solve());
	}
}
