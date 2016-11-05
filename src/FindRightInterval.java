import java.util.*;

public class FindRightInterval {
	public int[] findRightInterval(Interval[] intervals) {
		TreeMap<Integer, Integer> map = new TreeMap<>();
		for(int i = 0; i < intervals.length; i++){
			map.put(intervals[i].start, i);
		}
		int result[] = new int[intervals.length];
		for(int i = 0; i < intervals.length; i++){
			Integer key = map.ceilingKey(intervals[i].end);
			result[i] = key != null? map.get(key) : -1;
		}
		return result;
	}
}


class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
