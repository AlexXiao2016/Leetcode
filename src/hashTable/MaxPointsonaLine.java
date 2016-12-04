package hashTable;
import java.util.*;

public class MaxPointsonaLine {
	public int maxPoints(Point[] points) {
		if(points == null) return 0;
		if(points.length <= 2) return points.length;
	
		int result = 0;
		for(int i = 0; i < points.length; i++){
			HashMap<Double, Integer> map = new HashMap<>();
			int samex = 1;
			int samep = 0;
			for(int j = 0; j < points.length; j++){
				if(i != j){
					if(points[i].x == points[j].x && points[i].y == points[j].y){
						samep++;
					}
					if(points[i].x == points[j].x){
						samex++;
						continue;
					}
					double k = (double) (points[j].y - points[i].y) / (points[j].x - points[i].x);
					if(map.containsKey(k)){
						map.put(k, map.get(k) + 1);
					}else{
						map.put(k, 2);
					}
					result = Math.max(map.get(k) + samep, result);
				}
			}
			result = Math.max(samex, result);
		}
		
		return result;
	}


	public static void main(String args[]){
		Point p1 = new Point(0, 0);
		Point p2 = new Point(-1, -1);
		Point p3 = new Point(2, 2);
		Point[] points = {p1, p2, p3};
		
		MaxPointsonaLine mpl = new MaxPointsonaLine();
		mpl.maxPoints(points);
	}
}

class Point{
	int x;
	int y;
	Point() { x = 0; y = 0; }
	Point(int a, int b) { x = a; y = b; }
}
