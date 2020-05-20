package arrays;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FloodFill {
	public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
		if (image != null && image.length > 0) {
			Queue<int[]> queue = new LinkedList<>();
			int oldColor = image[sr][sc];
			int[] start = { sr, sc };
			queue.add(start);
			image[sr][sc] = -1;
			List<int[]> floodSpace = new ArrayList<>();
			while (!queue.isEmpty()) {
				int[] current = queue.remove();
				floodSpace.add(current);
				image[current[0]][current[1]] = -1;
				if (current[0] > 0 && image[current[0] - 1][current[1]] == oldColor)
					queue.add(new int[] { current[0] - 1, current[1] });
				if (current[0] < image.length - 1 && image[current[0] + 1][current[1]] == oldColor)
					queue.add(new int[] { current[0] + 1, current[1] });
				if (current[1] > 0 && image[current[0]][current[1] - 1] == oldColor)
					queue.add(new int[] { current[0], current[1] - 1 });
				if (current[1] < image[0].length - 1 && image[current[0]][current[1] + 1] == oldColor)
					queue.add(new int[] { current[0], current[1] + 1 });
			}

			for (int[] coordinates : floodSpace)
				image[coordinates[0]][coordinates[1]] = newColor;

		}
		return image;
	}

	public static void main(String[] args) {
		floodFill(new int[][] { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } }, 1, 1, 2);
	}
}
