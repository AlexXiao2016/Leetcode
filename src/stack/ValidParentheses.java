package stack;
import java.util.*;

public class ValidParentheses {
	public static boolean isValid(String s) {
		if(s == null || s.length() % 2 != 0){
			return false;
		}
		
		Stack<Character> st = new Stack<>();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(c == '(' || c == '{' || c == '['){
				st.push(c);
			}else{
				if(st.isEmpty()) return false;
				char top = st.pop();
				if((c == ')' && top != '(') || (c == '}' && top != '{') || (c == ']' && top != '[')){
					return false;
				}
			}				
		}
		
		return st.isEmpty();
	}
	
	public static void main(String args[]){
		System.out.println(isValid("[}"));
	}
}
