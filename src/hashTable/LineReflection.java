package hashTable;
import java.util.*;

public class LineReflection {
	public boolean isReflected(int[][] points) {
		if(points == null || points.length == 0) return true;
		
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		for(int[] point : points){
			int key = point[0];
			if(key > max){
				max = point[0];
			}
			if(key < min){
				min = point[0];
			}
			if(!map.containsKey(key)){
				map.put(key, new HashSet<Integer>());				
			}
			map.get(key).add(point[1]);
		}
		
		int x = min + max;
		for(int[] point : points){
			int reflect = x - point[0];
			if(!map.containsKey(reflect) || !map.get(reflect).contains(point[1])){
				return false;
			}
		}
		
		return true;
	}
}
