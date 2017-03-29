package stack;

/*
public class MiniParser {
	public NestedInteger deserialize(String s) {
		if(!s.startsWith("[")){
			return new NestedInteger(Integer.valueOf(s));
		}
		Stack<NestedInteger> stack = new Stack<>();
		NestedInteger res = new NestedInteger();
		stack.push(res);

		int start = 1;
		for(int i = 1; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == '['){
				NestedInteger temp = new NestedInteger();
				stack.peek().add(temp);
				stack.push(temp);
				start = i + 1;
			}
			if(c == ',' || c == ']'){
				if(i > start){
					Integer value = Integer.valueOf(s.substring(start, i));
					stack.peek().add(new NestedInteger(value));
				}
				start = i + 1;
				if(c == ']'){
					stack.pop();
				}
			}
		}

		return res;
	}
}

interface NestedInteger {
	// Constructor initializes an empty nested list.
	public NestedInteger();

	// Constructor initializes a single integer.
	public NestedInteger(int value);

	// @return true if this NestedInteger holds a single integer, rather than a nested list.
	public boolean isInteger();

	// @return the single integer that this NestedInteger holds, if it holds a single integer
	// Return null if this NestedInteger holds a nested list
	public Integer getInteger();

	// Set this NestedInteger to hold a single integer.
	public void setInteger(int value);

	// Set this NestedInteger to hold a nested list and adds a nested integer to it.
	public void add(NestedInteger ni);

	// @return the nested list that this NestedInteger holds, if it holds a nested list
	// Return null if this NestedInteger holds a single integer
	public List<NestedInteger> getList();
}
*/
