package array;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KthSmallestElementinaSortedMatrix {
	int id;
	float rating;

	public int kthSmallest(int[][] matrix, int k) {
		Queue<Integer> pq = new PriorityQueue<Integer>((a, b) -> b - a);

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (pq.size() < k) {
					pq.offer(matrix[i][j]);
				} else {
					int biggest = pq.peek();
					if (biggest > matrix[i][j]) {
						pq.poll();
						pq.offer(matrix[i][j]);
					}
				}
			}
		}

		return pq.poll();
	}

	public static int kthSmallest2(int[][] matrix, int k){
	    int n = matrix.length;

	    PriorityQueue<Tuple> pq = new PriorityQueue<>();
	    for(int j = 0; j < n; j++){
	        pq.offer(new Tuple(0, j, matrix[0][j]));
        }
        for(int i = 0; i < k - 1; i++){
	        Tuple temp = pq.poll();
	        if(temp.x == n - 1) continue;
	        pq.offer(new Tuple(temp.x + 1, temp.y, matrix[temp.x + 1][temp.y]));
        }

        return pq.poll().val;
    }

    static class Tuple implements Comparable<Tuple>{
	    int x, y, val;
	    public Tuple(int x, int y, int val){
	        this.x = x;
	        this.y = y;
	        this.val = val;
        }

        @Override
        public int compareTo(Tuple o) {
            return this.val - o.val;
        }
    }

	public KthSmallestElementinaSortedMatrix(int id, float rating) {
		this.id = id;
		this.rating = rating;
	}

	public float getRating() {
		return rating;
	}

	public int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null
				|| obstacleGrid[0].length == 0) {
			return 0;
		}

		int rows = obstacleGrid.length;
		int columns = obstacleGrid[0].length;
		int paths[] = new int[columns];
		paths[0] = 1;
		int i = 0, j = 0;

		for (i = 0; i < rows; i++) {
			for (j = 0; j < columns; j++) {
				if (obstacleGrid[i][j] == 0) {
					paths[j] = 0;
				} else if (j > 0) {
					paths[j] += paths[j - 1];
				}
			}
		}

		return paths[columns - 1];
	}

	public static void main(String args[]) throws Exception {
		/*
		 * Enter your code here. Read input from STDIN. Print output to STDOUT
		 */
        int[][] matrix = {{1, 5, 9}, {10, 11, 13}, {12, 13, 15}};

        System.out.println(kthSmallest2(matrix, 8));

    }
}

class Movie {
	int id;
	float rating;

	Movie(int id, float rating) {
		this.id = id;
		this.rating = rating;
	}

	public float getRating() {
		return rating;
	}
}
