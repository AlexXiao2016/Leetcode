package bfs;

import java.util.*;

public class TheMazeII {
	public static int shortestDistance(int[][] maze, int[] start, int[] destination) {
		int m = maze.length, n = maze[0].length;

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { start[0], start[1] });
		int[][] dir = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
		int[][] dists = new int[m][n];
		for (int i = 0; i < m; i++)
			Arrays.fill(dists[i], Integer.MAX_VALUE);
		dists[start[0]][start[1]] = 0;

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();

			for (int i = 0; i < dir.length; i++) {
				int x = cur[0];
				int y = cur[1];				
				int step = dists[x][y];;

				while (x >= 0 && x < m && y >= 0 && y < n && maze[x][y] == 0) {
					step++;
					x += dir[i][0];
					y += dir[i][1];
				}

				step--;
				x -= dir[i][0];
				y -= dir[i][1];

				if (step > dists[destination[0]][destination[1]])
					continue;

				if (step < dists[x][y]) {
					dists[x][y] = step;
					queue.offer(new int[] { x, y });
				}
			}
					
		}

		return dists[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : dists[destination[0]][destination[1]];
	}

	public static void main(String[] args) {
		int maze[][] = { { 0, 0, 1, 0, 0 }, { 0, 0, 0, 0, 0 }, { 0, 0, 0, 1, 0 }, { 1, 1, 0, 1, 1 },
				{ 0, 0, 0, 0, 0 } };
		int start[] = { 0, 4 };
		int des[] = { 4, 4 };
		System.out.println(shortestDistance(maze, start, des));
		String s = "a+b-c";
		System.out.println(s.split("(?=[+, -])")[1]);
	}
}
