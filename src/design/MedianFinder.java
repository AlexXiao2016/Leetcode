package design;
import java.util.*;

public class MedianFinder {
	
	private PriorityQueue<Integer> max = new PriorityQueue<>();
	private PriorityQueue<Integer> min = new PriorityQueue<>();
	
    public void addNum(int num) {
    	max.offer(num);
    	min.offer(max.poll());
    	if(max.size() < min.size()){
    		max.offer(min.poll());
    	}
        
    }

    // Returns the median of current data stream
    public double findMedian() {
        double result = 0d;
        if(max.size() == min.size()) {
        	result = (max.peek() + min.peek()) / 2;
        } else{
        	result = max.peek();
        }
        return result;
    }
}
