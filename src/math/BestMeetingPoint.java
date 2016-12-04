package math;
import java.util.*;

public class BestMeetingPoint {
	public int minTotalDistance(int[][] grid) {
		if(grid == null || grid.length == 0 || grid[0].length == 0){
			return 0;
		}
		
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();
		
		for(int i = 0; i < grid.length; i++){
			for(int j = 0; j < grid[0].length; j++){
				if(grid[i][j] == 1){
					rows.add(i);
					cols.add(j);
				}
			}
		}
		return getMin(rows) + getMin(cols);
	}
	
	public int getMin(List<Integer> list){
		int res = 0;
		Collections.sort(list);
		
		int i = 0, j = list.size() - 1;
		while(i < j){
			res += list.get(j--) - list.get(i++);
		}
		return res;
	}
}
