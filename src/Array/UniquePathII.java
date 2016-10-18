package Array;

public class UniquePathII {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {

		if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0){
			return 1;
		}

		int rows = obstacleGrid.length;
		int columns = obstacleGrid[0].length;
		int paths[] = new int[columns];
		paths[0] = 1;
		int i = 0, j = 0;

		for(i = 0; i < rows; i++){
			for(j = 0; j < columns; j++){
				if(obstacleGrid[i][j] == 1){
					paths[j] = 0;
				}else if(j > 0){
					paths[j] += paths[j - 1];
				}
			}
		}

		return paths[columns - 1];
	}
	
	public static void main(String args[]){
		int obstacleGrid[][] = {{0}};
		System.out.println(uniquePathsWithObstacles(obstacleGrid));
	}
}
