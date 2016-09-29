package Array;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthSmallestElementinaSortedMatrix {
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
}
