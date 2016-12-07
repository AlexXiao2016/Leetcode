package stack;
import java.util.*;

public class BasicCalculator {
	public int calculate(String s) {
		Stack<Integer> nums = new Stack<>();
		int result = 0;
		int number = 0; 
		int sign = 1;
		
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				number = number * 10 + (c - '0');				
			}else if(c == '+'){
				result += sign * number;
				sign = 1;
				number = 0;
			}else if(c == '-'){
				result += sign * number;
				sign = -1;
				number = 0;
			}else if(c == '('){
				nums.push(result);
				nums.push(sign);
				result = 0;
				sign = 1;
			}else if(c == ')'){
				result += sign * number;
				number = 0;
				result *= nums.pop();
				result += nums.pop();
			}				
		}
		if(number != 0) result += sign * number;
		return result;
	}
	
	public static void main(String args[]){
		BasicCalculator bc = new BasicCalculator();
		System.out.println(bc.calculate("1 + 1"));
	}
}
