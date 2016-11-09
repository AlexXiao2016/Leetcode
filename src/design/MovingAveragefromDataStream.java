package design;
import java.util.*;

public class MovingAveragefromDataStream {
   
    int size;
    double sum;
    Queue<Integer> queue;
    
    /** Initialize your data structure here. */
    public MovingAveragefromDataStream(int size) {
        this.size = size;
        sum = 0d;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        if(queue.size() >= size){
        	sum -= queue.poll();        	
        }
        queue.add(val);
        sum += val;
        return sum / queue.size();
    }
    
    public static void main(String args[]){
    	MovingAveragefromDataStream mAvg = new MovingAveragefromDataStream(3);
    	System.out.println(mAvg.next(1));
    	System.out.println(mAvg.next(10));
    	System.out.println(mAvg.next(3));
    	System.out.println(mAvg.next(5));
    }
}
