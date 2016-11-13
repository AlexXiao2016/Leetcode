package dp;

public class BombEnemy {
	public int maxKilledEnemies(char[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0) return 0;
		
		int max = 0;
		int row = 0;
		int col[] = new int[grid[0].length];
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == 'W') continue;
				if(j == 0 || grid[i][j - 1] == 'W'){
					row = killEnemiesRow(grid, i, j);
				}
				if(i == 0 || grid[i - 1][j] == 'W'){
					col[j] = killEnemiesCol(grid, i, j);
				}
				if(grid[i][j] == '0'){
					max = Math.max(max, row + col[j]);
				}				
			}
		}		
		return max;
	}
	
	public int killEnemiesRow(char[][] grid, int i, int j){
		int sum = 0;
		while (j < grid[0].length && grid[i][j] != 'W'){
			if(grid[i][j] == 'E') sum++;
			j++;
		}
		return sum;
	}
	
	public int killEnemiesCol(char[][] grid, int i, int j){
		int sum = 0;
		while (i < grid.length && grid[i][j] != 'W'){
			if(grid[i][j] == 'E') sum++;
			i++;
		}
		return sum;
	}
	
	public static void main(String args[]){
		char[][] grid = {{'0', 'E', '0', 'W', 'E'}, {'E', 'E', 'W', '0', '0'}, {'E', '0', 'E', '0', 'E'},
				{'0', 'W', '0', 'E', '0'}, {'E', 'E', '0', 'W', 'E'}};
		BombEnemy be = new BombEnemy();
		be.maxKilledEnemies(grid);
	}
}
