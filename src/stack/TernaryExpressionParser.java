package stack;
import java.util.*;

public class TernaryExpressionParser {
	public static String parseTernary(String expression) {
		if(expression == null || expression.length() == 0){
			return "";
		}		
		
		Stack<Character> stack = new Stack<>();
		for(int i = expression.length() - 1; i >= 0; i--){
			char c = expression.charAt(i);
			if(!stack.isEmpty() && stack.peek() == '?'){
				stack.pop();
				char first = stack.pop();
				stack.pop();
				char second = stack.pop();
				if(c == 'F'){
					stack.push(second);
				}else{
					stack.push(first);
				}
			}else{
				stack.push(c);
			}
		}
		return String.valueOf(stack.peek());
	}
	
	public static String parseTernary2(String expression) {
        while (expression.length() != 1) {
            int i = expression.lastIndexOf("?");    // get the last shown '?'
            char tmp;
            if (expression.charAt(i-1) == 'T') { tmp = expression.charAt(i+1); }
            else { tmp = expression.charAt(i+3); }
            expression = expression.substring(0, i-1) + tmp + expression.substring(i+4);
        }
        return expression;
    }
	
	public static void main(String args[]){
		System.out.println(parseTernary2("F?T:F?T?1:2:F?3:4"));
	}
	
	
}
