package design;
import java.util.*;

public class TwoSumIII {
	List<Integer> list = new ArrayList<>();
    // Add the number to an internal data structure.
	public void add(int number) {
	    list.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
	    HashSet<Integer> set = new HashSet<>();
	    for(int i = 0; i < list.size(); i++){
	        if(!set.contains(list.get(i))){
	            set.add(value - list.get(i));
	        }else{
	            return true;
	        }
	    }
	    return false;
	}
}
