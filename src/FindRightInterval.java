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
	
	
	private int[] findRightInterval2(Interval[] intervals) {
        if(intervals == null || intervals.length == 0) return new int[0];
        
        int[] res = new int[intervals.length];
        IntervalWithIndex[] list = new IntervalWithIndex[intervals.length];
        for(int i = 0; i < intervals.length; i++){
            list[i] = new IntervalWithIndex(intervals[i], i);
        }
        Arrays.sort(list, new Comparator<IntervalWithIndex>(){
            public int compare(IntervalWithIndex a, IntervalWithIndex b){
                return a.interval.start - b.interval.start;
            }
        });
        
        for(int i = 0; i < list.length; i++){
            int end = list[i].interval.end;
            int idx = binarySearch(list, end);
            if(list[idx].interval.start < end){
                res[i] = -1;
            }else{
                res[i] = idx;
            }
        }
        
        return res;
    }
    
    private int binarySearch(IntervalWithIndex list[], int val){
        int left = 0, right = list.length - 1;
        while(left < right){
            int mid = left + (right - left) / 2;
            if(list[mid].interval.start < val){
                left = mid + 1;
            }else{
                right = mid;
            }
        }
        
        return list[left].index;
    }
    
    class IntervalWithIndex{
        Interval interval;
        int index;
        
        public IntervalWithIndex(Interval interval, int index){
            this.interval = interval;
            this.index = index;
        }
    }
    
    public static void main(String args[]){
    	Interval[] it = new Interval[3];
    	it[0] = new Interval(3,4);
    	it[1] = new Interval(2,3);    	
    	it[2] = new Interval(1,2);
    	
    	FindRightInterval fri = new FindRightInterval();
    	fri.findRightInterval2(it);
    }
}


class Interval {
	int start;
	int end;
	Interval() { start = 0; end = 0; }
	Interval(int s, int e) { start = s; end = e; }
}
