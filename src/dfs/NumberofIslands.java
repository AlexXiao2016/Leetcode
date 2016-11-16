package dfs;

public class NumberofIslands {
	public static int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                	count++;
                	resetRestIslands(grid, i, j);
                }
            }
        }
        
        return count;
    }
	
	public static void resetRestIslands(char[][] grid, int i, int j){
		if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
		
		grid[i][j] = '0';
		resetRestIslands(grid, i - 1, j);
		resetRestIslands(grid, i, j - 1);
		resetRestIslands(grid, i + 1, j);
		resetRestIslands(grid, i, j + 1);
	}
	
	
	public static void main(String args[]){
		char[][] nums= {{'1', '1', '1'}, {'0', '1', '0'}, {'1', '1', '1'}};
		System.out.println(numIslands(nums));
	}
}
