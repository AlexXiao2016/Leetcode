package design;

import java.util.Iterator;

public class PeekingIterator implements Iterator<Integer> {
	
	Integer next = null;
	Iterator<Integer> iterator;
	
	public PeekingIterator(Iterator<Integer> iterator) {
		this.iterator = iterator;
		if(iterator.hasNext()){
			next = iterator.next();
		}
	}
	public Integer peek() {
		return next;
	}
	
	@Override
	public boolean hasNext() {
		return next != null;
	}

	@Override
	public Integer next() {
		Integer temp = next;
		next = iterator.hasNext() ? iterator.next() : null;
		return temp;
	}
	
}
