package design;
import java.util.*;

public class HitCounter {

	HashMap<Integer, Integer> map = new HashMap<>();
	/** Initialize your data structure here. */
	public HitCounter() {
	}

	/** Record a hit.
	        @param timestamp - The current timestamp (in seconds granularity). */
	public void hit(int timestamp) {
		map.put(timestamp, map.getOrDefault(timestamp, 0) + 1);
		
	}

	/** Return the number of hits in the past 5 minutes.
	        @param timestamp - The current timestamp (in seconds granularity). */
	public int getHits(int timestamp) {
		int sum = 0;
		for(Integer time : map.keySet()){	
			if(timestamp - time < 300)
				sum += map.get(time);
		}
		return sum;
	}	
	
	public static void main(String args[]){
		HitCounter hc = new HitCounter();
		hc.hit(1);
		hc.hit(1);
		hc.hit(1);
		hc.hit(300);
		System.out.println(hc.getHits(300));		
		hc.hit(300);
		System.out.println(hc.getHits(300));
	}
}
