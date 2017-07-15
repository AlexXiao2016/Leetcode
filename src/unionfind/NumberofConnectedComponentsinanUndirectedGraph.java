package unionfind;

import java.util.*;

public class NumberofConnectedComponentsinanUndirectedGraph {
	public int countComponents(int n, int[][] edges) {
		int[] roots = new int[n];
		for (int i = 0; i < n; i++)
			roots[i] = i;

		for (int[] edge : edges) {
			int root1 = find(roots, edge[0]);
			int root2 = find(roots, edge[1]);

			if (root1 != root2) {
				roots[root1] = root2;
				n--;
			}
		}

		return n;
	}

	private int find(int[] roots, int id) {
		while (roots[id] != id) {
			roots[id] = roots[roots[id]];
			id = roots[id];
		}
		return id;
	}

	public int countComponents2(int n, int[][] edges) {
		if (n <= 1)
			return n;

		Map<Integer, List<Integer>> map = new HashMap<>();

		for (int i = 0; i < n; i++) {
			map.put(i, new ArrayList<>());
		}

		for (int edge[] : edges) {
			map.get(edge[0]).add(edge[1]);
			map.get(edge[1]).add(edge[0]);
		}

		Set<Integer> set = new HashSet<>();
		int res = 0;
		for (int i = 0; i < n; i++) {
			if (set.add(i)) {
				dfs(i, map, set);
				res++;
			}
		}

		return res;
	}

	private void dfs(int i, Map<Integer, List<Integer>> map, Set<Integer> set) {
		for (int j : map.get(i)) {
			if (set.add(j)) {
				dfs(j, map, set);
			}
		}
	}

	public static void main(String args[]) {
//		NumberofConnectedComponentsinanUndirectedGraph num = new NumberofConnectedComponentsinanUndirectedGraph();
//		int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		

		String s = "---+--+-+-";
		System.out.println(s.indexOf("++"));
	}

}
