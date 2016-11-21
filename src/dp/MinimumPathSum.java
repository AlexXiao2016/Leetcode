package dp;

public class MinimumPathSum {
	public int minPathSum(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        int[][] minGrid = new int[m][n];
        minGrid[0][0] = grid[0][0];
        int sum = grid[0][0];
        for(int i = 1; i < m; i++){
        	sum += grid[i][0];
            minGrid[i][0] = sum;
        }
        
        sum = grid[0][0];
        for(int i = 1; i < n; i++){
        	sum += grid[0][i];
            minGrid[0][i] = sum;
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                minGrid[i][j] = Math.min(minGrid[i - 1][j], minGrid[i][j - 1]) + grid[i][j];
            }
        }
        
        return minGrid[m - 1][n - 1];
	}
	
	
	public static void main(String args[]){
		MinimumPathSum mps = new MinimumPathSum();
		int grid[][] = {{1,2,1},{3,1,1}};
		int res = mps.minPathSum(grid);
		System.out.println(res);
	}
}
