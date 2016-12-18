package design;
import java.util.*;

public class RandomizedCollection {
	
	ArrayList<Integer> result;
	HashMap<Integer, LinkedHashSet<Integer>> map;
	
	/** Initialize your data structure here. */
    public RandomizedCollection() {
        result = new ArrayList<>();
        map = new HashMap<>();
    }
    
    /** Inserts a value to the collection. Returns true if the collection did not already contain the specified element. */
    public boolean insert(int val) {
        boolean exists = map.containsKey(val);
        if(!exists){
        	map.put(val, new LinkedHashSet<Integer>());
        }
        map.get(val).add(result.size());
        result.add(val);
        return !exists;
    }
    
    /** Removes a value from the collection. Returns true if the collection contained the specified element. */
    public boolean remove(int val) {
        if(!map.containsKey(val)){
        	return false;
        }
        
        LinkedHashSet<Integer> valueSet = map.get(val);
        int indexToReplace = valueSet.iterator().next();
        
        int numAtLastPlace = result.get(result.size() - 1);
        LinkedHashSet<Integer> replaceWith = map.get(numAtLastPlace);
        
        result.set(indexToReplace, numAtLastPlace);
        valueSet.remove(indexToReplace);
        
        if(indexToReplace != result.size() - 1){
        	replaceWith.remove(result.size() - 1);
        	replaceWith.add(indexToReplace);
        }
        
        result.remove(result.size() - 1);
        
        if(valueSet.isEmpty()) map.remove(val);
        return true;
    }
    
    /** Get a random element from the collection. */
    public int getRandom() {
        Random rand = new Random();
        return result.get(rand.nextInt(result.size()));
    }
}
