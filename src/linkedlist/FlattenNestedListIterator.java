package linkedlist;

import java.util.*;

public class FlattenNestedListIterator implements Iterator<Integer> {

	List<NestedInteger> list;

	public FlattenNestedListIterator(List<NestedInteger> nestedList) {
		list = new ArrayList<>();
		for(NestedInteger a : nestedList){
			flatList(a);
		}
	}

	private void flatList(NestedInteger ni){
		if(ni.isInteger()){
			list.add(ni);
		}else{
			for(NestedInteger value : ni.getList()){
				flatList(value);
			}
		}
	}

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return list.size() != 0;
	}

	@Override
	public Integer next() {
		// TODO Auto-generated method stub
		int result = list.get(0).getInteger();
        list.remove(0);
        return result;
	}

}


interface NestedInteger {

	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
