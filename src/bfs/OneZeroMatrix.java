package bfs;
import java.util.*;

public class OneZeroMatrix {
	public static int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new LinkedList<>();
        int m = matrix.length, n = matrix[0].length;
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0){
                    queue.offer(new int[]{i, j});
                }else{
                	matrix[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        
        
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            for(int[] dir : dirs){
            	int i = cur[0] + dir[0];
            	int j = cur[1] + dir[1];
            	if(i < 0 || i >= m || j < 0 || j >= n || matrix[i][j] <= matrix[cur[0]][cur[1]] + 1){
            		continue;
            	}
            	queue.offer(new int[]{i, j});
            	matrix[i][j] = matrix[cur[0]][cur[1]] + 1;
            }
        }
        
        return matrix;
    }
	
	public static void main(String args[]){
		int[][] m = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
		updateMatrix(m);
	}
}
