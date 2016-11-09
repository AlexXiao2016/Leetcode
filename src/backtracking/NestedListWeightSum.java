package backtracking;
import java.util.*;

public class NestedListWeightSum {
	public int depthSum(List<NestedInteger> nestedList) {
		return depthSum(nestedList, 1);
	}

	public int depthSum(List<NestedInteger> list, int depth){
		if(list == null || list.size() == 0){
			return 0;
		}
		
		int sum = 0;
		for(NestedInteger curr : list){
			if(curr.isInteger()){
				sum += curr.getInteger() * depth;
			}else{
				sum += depthSum(curr.getList(), depth + 1);
			}
		}
		return sum;
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
