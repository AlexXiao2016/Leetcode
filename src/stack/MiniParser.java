package stack;
import java.util.*;
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

