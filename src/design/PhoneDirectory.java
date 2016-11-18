package design;
import java.util.*;

public class PhoneDirectory {

	HashSet<Integer> phone;
	/** Initialize your data structure here
    @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
	public PhoneDirectory(int maxNumbers) {
		phone = new HashSet<Integer>();
		for(int i = 0; i < maxNumbers; i++){
		    phone.add(i);
		}
	}

	/** Provide a number which is not assigned to anyone.
    @return - Return an available number. Return -1 if none is available. */
	public int get() {	
		if(phone.size() <= 0){
		    return -1;
		}else{
		    int temp = 0;
		    for(int num : phone){
		        temp = num;
		        break;
		    }
		    phone.remove(temp);
		    return temp;
		}
	}

	/** Check if a number is available or not. */
	public boolean check(int number) {
		return phone.contains(number); 
	}

	/** Recycle or release a number. */
	public void release(int number) {
		phone.add(number);
	}
}
