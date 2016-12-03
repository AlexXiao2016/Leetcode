package bfs;
import java.util.*;

public class PacificAtlanticWaterFlow {
		
	public List<int[]> pacificAtlantic(int[][] matrix) {
		List<int[]> res = new ArrayList<>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0) return res;
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		Queue<int[]> pQueue = new LinkedList<>();
		Queue<int[]> aQueue = new LinkedList<>();
		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];
		
		for(int i = 0; i < m; i++){
			pQueue.offer(new int[]{i, 0});
			aQueue.offer(new int[]{i, n - 1});
			pacific[i][0] = true;
			atlantic[i][n - 1] = true;
		}
		
		for(int i = 0; i < n; i++){
			pQueue.offer(new int[]{0, i});
			aQueue.offer(new int[]{m - 1, i});
			pacific[0][i] = true;
			atlantic[m - 1][i] = true;
		}
		
		bfs(matrix, pQueue, pacific);
		bfs(matrix, aQueue, atlantic);
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(pacific[i][j] && atlantic[i][j] ){
					res.add(new int[]{i, j});
				}
			}
		}
		
		return res;
	}
	
	
	private void bfs(int[][] matrix, Queue<int[]> queue, boolean[][] visited){
		int m = matrix.length, n = matrix[0].length;
		int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
		while(!queue.isEmpty()){
			int[] cur = queue.poll();
			for(int[] dir : dirs){
				int x = cur[0] + dir[0];
				int y = cur[1] + dir[1];
				if(x < 0 || y < 0 || x >= m || y >= n || visited[x][y] || matrix[x][y] < matrix[cur[0]][cur[1]]){
					continue;
				}
				visited[x][y] = true;
				queue.offer(new int[]{x, y});
			}
		}
	}
	 
	public List<int[]> pacificAtlanticDFS(int[][] matrix){
		List<int[]> res = new ArrayList<>();
		if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
			return res;
		}
		
		int m = matrix.length, n = matrix[0].length;
		boolean[][] pacific = new boolean[m][n];
		boolean[][] atlantic = new boolean[m][n];
		
		for(int i = 0; i < m; i++){
			dfs(matrix, pacific, Integer.MIN_VALUE, i, 0);
			dfs(matrix, atlantic, Integer.MIN_VALUE, i, n - 1);
		}
		
		for(int i = 0; i < n; i++){
			dfs(matrix, pacific, Integer.MIN_VALUE, 0, i);
			dfs(matrix, atlantic, Integer.MIN_VALUE, m - 1, i);
		}
		
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(pacific[i][j] && atlantic[i][j]){
					res.add(new int[]{i, j});
				}
			}
		}
		return res;
	}
	
	int[][] dirs = {{1, 0}, {-1 , 0}, {0, 1}, {0, -1}};
	
	public void dfs(int[][] matrix, boolean[][] visited, int height, int i, int j){
		int m = matrix.length, n = matrix[0].length;
		if(i < 0 || j < 0 || i >= m || j >= n || visited[i][j] || matrix[i][j] < height){
			return;
		}
		visited[i][j] = true;
		
		for(int dir[] : dirs){
			dfs(matrix, visited, matrix[i][j], i + dir[0], j + dir[1]);
		}
	}
	

	
	public static void main(String args[]){
		int [][] matrix = {{1,2,2,3,5}, {3,2,3,4,4}, {2,4,5,3,1}, {6,7,1,4,5}, {5,1,1,2,4}};
		PacificAtlanticWaterFlow pawf = new PacificAtlanticWaterFlow();
		pawf.pacificAtlanticDFS(matrix);
	}
}
