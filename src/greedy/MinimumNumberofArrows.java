package greedy;

import java.util.*;

public class MinimumNumberofArrows {
	public static int findMinArrowShots(int[][] points) {
		Arrays.sort(points, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b){
				return a[0] != b[0] ? a[0] - b[0] : a[1] - b[1];
			}
		});
		int count = 1;
		int end = points[0][1];		
		int i = 1;
		while(i < points.length){
			if(end < points[i][0]){
				count++;
				end = points[i][1];
			}else{
				end = Math.min(points[i][1], end);
			}
			i++;
		}
		return count;
	}

	public static void main(String args[]){
		int[][] points = {{9,12}, {1, 10}, {4,11}, {8, 12}, {3, 9}, {6, 9}, {6, 7}};
		System.out.println(findMinArrowShots(points));
	}
}
