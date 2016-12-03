package array;

public class IslandPerimeter {
	public int islandPerimeter(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0){
			return 0;
		}
		
		int m = grid.length, n = grid[0].length;
		int perimeter = 0;
		for(int i = 0; i < m; i++){
			for(int j = 0; j < n; j++){
				if(grid[i][j] == 1){
					perimeter += 4;
					if(i + 1 < m && grid[i + 1][j] == 1) perimeter -= 2;
					if(j + 1 < n && grid[i][j + 1] == 1) perimeter -= 2;
				}				
			}
		}
		return perimeter;
	}
}
