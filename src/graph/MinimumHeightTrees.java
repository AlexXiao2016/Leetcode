package graph;
import java.util.*;

public class MinimumHeightTrees {
	public List<Integer> findMinHeightTrees(int n, int[][] edges) {
		List<Integer> result = new ArrayList<>();
		if(n == 1) {
			result.add(0);
            return result;
        }
		
		List<Set<Integer>> adj = new ArrayList<>();
		for(int i = 0; i < n; i++){
			Set<Integer> temp = new HashSet<>();
			adj.add(temp);
		}
		
		for(int[] edge : edges){
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
		
		for(int i = 0; i < n; i++){
			if(adj.get(i).size() == 1){
				result.add(i);
			}
		}
		
		
		while(n > 2){
			n -= result.size();
			List<Integer> newLeaves = new ArrayList<>();
			for(int i : result){
				int j = adj.get(i).iterator().next();
				adj.get(j).remove(i);
				if(adj.get(j).size() == 1) newLeaves.add(j);
			}
			result = newLeaves;
		}
		return result;
	}
	
	
	public static void main(String args[]){
		int edges[][] = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		MinimumHeightTrees mht = new MinimumHeightTrees();
		mht.findMinHeightTrees(6, edges);
	}
}
