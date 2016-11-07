package array;

import java.util.*;

class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}

public class NonOverlappingIntervals {
	public static int eraseOverlapIntervals(Interval[] intervals) {
		if(intervals == null || intervals.length == 0){
			return 0;
		}
		
		Arrays.sort(intervals, (a, b) -> a.end == b.end ? b.start - a.start : a.end - b.end);
		
		int end = Integer.MIN_VALUE;
		int count = 0;
		for(int i = 0; i < intervals.length; i++){
			if(intervals[i].start >= end){
				end = intervals[i].end;
			}else{
				count++;
			}			
		}		
		return count;		
	}
	
	public static void main(String args[]){
		Interval a = new Interval(1,2);
		Interval b = new Interval(2,3);
		Interval[] intervals = new Interval[2];
		intervals[0] = a;
		intervals[1] = b;
		eraseOverlapIntervals(intervals);		
	}
}
