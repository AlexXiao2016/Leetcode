package queue;
import java.util.*;

public class WallsandGates {
	public void wallsAndGates(int[][] rooms) {
		if(rooms == null || rooms.length == 0){
			return;
		}
		
		int n = rooms.length;
		int m = rooms[0].length;
		Queue<int[]> queue = new LinkedList<>();
		for(int i = 0; i < n; i++){
			for(int j = 0; j < m; j++){
				if(rooms[i][j] == 0){
					queue.add(new int[]{i, j});
				}
			}
		}
		
		while(!queue.isEmpty()){
			int[] curr = queue.poll();
			int row = curr[0];
			int col = curr[1];
			
			if(row > 0 && rooms[row - 1][col] == Integer.MAX_VALUE){
				rooms[row - 1][col] = rooms[row][col] + 1;
				queue.add(new int[]{row - 1, col});
			}
			
			if(row < n - 1 && rooms[row + 1][col] == Integer.MAX_VALUE){
				rooms[row + 1][col] = rooms[row][col] + 1;
				queue.add(new int[]{row + 1, col});
			}
			
			if(col > 0 && rooms[row][col - 1] == Integer.MAX_VALUE){
				rooms[row][col - 1] = rooms[row][col] + 1;
				queue.add(new int[]{row, col - 1});
			}
			
			if(col < m + 1 && rooms[row][col + 1] == Integer.MAX_VALUE){
				rooms[row][col + 1] = rooms[row][col] + 1;
				queue.add(new int[]{row, col + 1});
			} 
		}
	}
}
