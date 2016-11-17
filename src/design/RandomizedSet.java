package design;
import java.util.*;

public class RandomizedSet {
	
	private HashMap<Integer, Integer> map;
	private ArrayList<Integer> list;
	 /** Initialize your data structure here. */
    public RandomizedSet() {
    	map = new HashMap<>();
    	list = new ArrayList<>();
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if(!map.containsKey(val)){
        	map.put(val, list.size());
        	list.add(val);
        	return true;
        }
        return false;
        
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
        	return false;
        }
        int value = map.get(val);
        if(value < list.size() - 1){
        	int lastValue = list.get(list.size() - 1);
        	map.put(lastValue, value);
        	list.set(value, lastValue);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        return list.get(rand.nextInt(list.size()));
    }
    
    public static void main(String args[]){
    	RandomizedSet rs = new RandomizedSet();
    	rs.insert(3);
    	rs.remove(3);
    	rs.remove(0);
    	rs.insert(3);
    	rs.getRandom();
    	rs.remove(0);
    }
}
