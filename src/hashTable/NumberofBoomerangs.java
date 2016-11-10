package hashTable;
import java.util.*;

public class NumberofBoomerangs {
	public int numberOfBoomerangs(int[][] points) {
		if(points == null || points.length == 0 || points[0].length == 0) return 0;
		HashMap<Integer, Integer> map = new HashMap<>();
		int res = 0;
		
		for(int i = 0; i < points.length; i++){
			for(int j = 0; j < points.length; j++){
				if(i != j){
					int distence = getDistence(points[i], points[j]);
					map.put(distence, map.getOrDefault(distence, 0) + 1);
				}
			}
			
			for(int val : map.values()){
				res += val * (val - 1);
			}
			map.clear();
		}
		
		return res;
	}
	
	public int getDistence(int a[], int b[]){
		int x = a[0] - b[0];
		int y = a[1] - b[1];
		
		return x * x + y * y;
	}
}
