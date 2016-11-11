package design;
import java.util.*;

public class ZigzagIterator {
	Iterator<Integer> it1;
	Iterator<Integer> it2;
	boolean flag;
    

    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        it1 = v1.iterator();
        it2 = v2.iterator();
        flag = true;
    }

    public int next() {
        if(flag){
        	if(it2.hasNext()){
        		flag = false;
        	}
        	return it1.next();
        }else{
        	if(it1.hasNext()){
        		flag = true;
        	}
        	return it2.next();
        }
    }

    public boolean hasNext() {
        if(it1.hasNext() || it2.hasNext()){
        	return true;
        }
        return false;
    }
}
