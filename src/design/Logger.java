package design;
import java.util.*;

public class Logger {
	
	private HashMap<String, Integer> map;
    /** Initialize your data structure here. */
    public Logger() {
    	map = new HashMap<>(10);
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
    	Integer lastTimestamp = map.get(message);
        if(lastTimestamp == null || timestamp - lastTimestamp >= 10){
        	map.put(message, timestamp);
        	return true;
        }
        return false;
    }
    
    public static void main(String args[]){
    	Logger log = new Logger();
    	log.shouldPrintMessage(1, "foo");
    	log.shouldPrintMessage(2, "bar");
    	log.shouldPrintMessage(3, "foo");
    	log.shouldPrintMessage(8, "bar");
    	log.shouldPrintMessage(10, "foo");
    	log.shouldPrintMessage(11, "foo");
    }
}
