package graph;


public class ConnectedComponents {
	public int countComponents(int n, int[][] edges) {
		int[] roots = new int[n];
		for(int i = 0; i < n; i++) roots[i] = i;
		
		for(int[] edge : edges){
			int root1 = find(roots, edge[0]);
			int root2 = find(roots, edge[1]);
			if(root1 != root2){
				roots[root1] = root2;
				n--;
			}
		}
		return n;
    }
	
	public int find(int[] roots, int id) {
	    while(roots[id] != id){
	    	roots[id] = roots[roots[id]];
	    	id = roots[id];
	    }
	    return id;
	}
	
	public static void main(String args[]){
		ConnectedComponents c = new ConnectedComponents();
		int[][] edges = {{0, 1}, {1, 2}, {3, 4}};
		
		c.countComponents(5, edges);
	}
}
