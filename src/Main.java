import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import maze.Maze;
import maze.MazeClass;

public class Main {

	public static void main(String[] args) throws IOException {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		String[] input = reader.readLine().split(" ");
		int width = Integer.parseInt(input[0]);
		int height = Integer.parseInt(input[1]);
		Maze jack = new MazeClass();
		
		for(int i = 0; i<height;i++) {
			input = reader.readLine().split(" ");
			for(int h = 0;h<width;h++) {
				if(input[h].equals("*")) {
					jack.addLamp();
				}
				else if(input[h].equals("0")) {
					jack.addEmpty();
				}
				else {
					jack.darkLantern();
				}
			}
		}
	}
}
