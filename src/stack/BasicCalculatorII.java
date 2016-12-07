package stack;
import java.util.*;

public class BasicCalculatorII {
	public static int calculate(String s) {		
		Stack<Integer> nums = new Stack<>();
		int number = 0;
		for(int i = 0, sign = '+'; i < s.length(); i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				number = number * 10 + (c - '0');
			}
			if("+-*/".indexOf(c) >= 0 || i == s.length() - 1){
				if(sign == '+'){
					nums.push(number);
				}else if(sign == '-'){
					nums.push(-number);
				}else if(sign == '*'){
					nums.push(nums.pop() * number);
				}else if(sign == '/'){
					nums.push(nums.pop() / number);
				}
				sign = s.charAt(i);
				number = 0;
			}
		}

		int res = 0;
		for(int num : nums) res += num;
		return res;
	}


	public static void main(String args[]){
		int res = calculate("-3/2");
		System.out.println(res);
	}
}
