package greedy;

import java.util.Arrays;

public class AssignCookies {
	public int findContentChildren(int[] g, int[] s) {
		if(g == null || s == null || g.length == 0 || s.length == 0){
			return 0;
		}
		
		Arrays.sort(g);
		Arrays.sort(s);
		int m = g.length;
		int n = s.length;
		int i = 0, j = 0;
		while(j < n && i < m){
			if(g[i] <= s[j]){
				i++;
			}
			j++;
		}		
		
		return i;
	}
	
	public static void main(String args[]){
		AssignCookies ac = new AssignCookies();
		int[] g = {7, 8, 9, 10};
		int[] s = {5, 6, 7, 8};
		
		ac.findContentChildren(g, s);
	}
}
