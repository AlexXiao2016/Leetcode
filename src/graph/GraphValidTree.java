package graph;

import java.util.Arrays;

public class GraphValidTree {
	public boolean validTree(int n, int[][] edges) {
		
		int[] nums = new int[n];
		Arrays.fill(nums, -1);
		
		for(int[] edge : edges){
			int x = unionFind(nums, edge[0]);
			int y = unionFind(nums, edge[1]);
			
			if(x == y) return false;
			
			nums[x] = y;
		}
		return edges.length == n - 1;
	}
	
	private int unionFind(int[] nums, int i){
		if(nums[i] == -1) return i;
		return unionFind(nums, nums[i]);
	}
	
	public static void main(String args[]){
		int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}};
		
		GraphValidTree gvt = new GraphValidTree();
		gvt.validTree(5, edges);
	}
}
