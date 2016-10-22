package array;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class KthSmallestElementinaSortedMatrix {
	int id; 
	float rating;
	public int kthSmallest(int[][] matrix, int k) {
        Queue<Integer> pq = new PriorityQueue<Integer>((a,b) -> b - a);
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(pq.size() < k){
                	pq.offer(matrix[i][j]);
                }else{
                	int biggest = pq.peek();
                	if(biggest > matrix[i][j]){
                		pq.poll();
                		pq.offer(matrix[i][j]);
                	}
                }
            }
        }
              
        return pq.poll();
    }
	
	public KthSmallestElementinaSortedMatrix(int id, float rating){
		this.id = id;
		this.rating = rating;
	}
	
	public float getRating(){
		return rating;
	}
		
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0] == null || obstacleGrid[0].length == 0){
            return 0;
        }
        
        int rows = obstacleGrid.length;
        int columns = obstacleGrid[0].length;
        int paths[] = new int[columns];
        paths[0] = 1;
        int i = 0, j = 0;
        
        for(i = 0; i < rows; i++){
            for(j = 0; j < columns; j++){
                if(obstacleGrid[i][j] == 0){
                    paths[j] = 0;
                }else if(j > 0){
                    paths[j] += paths[j - 1];
                }
            }
        }
        
        return paths[columns - 1];
    }
	
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        
        Scanner in = new Scanner(System.in);
        
        int n = 0;
        int m = 0;
        n = in.nextInt();
        m = in.nextInt();
        
        int matrix[][] = new int[m][3];
        for(int j = 0; j < m; j++){
            matrix[j][0] = in.nextInt();
            matrix[j][1] = in.nextInt();
            matrix[j][2] = in.nextInt();            
        }
        
        int max = 0;
        int list[]  = new int[n];
        for(int i = 0; i < m; i++){
            for(int j = matrix[i][0] - 1; j <= matrix[i][1] - 1; j++){
                list[j] += matrix[i][2];
            }
        }
        
        for(int i = 0; i < n; i++){
            if(max > list[i]){
                max = list[i];
            }
        }
        
        System.out.println(max);
    }
}

class Movie{
	int id;
	float rating;
	
	Movie(int id, float rating)
	{
		this.id = id;
		this.rating = rating;
	}
	
	public float getRating(){
		return rating;
	}
}
