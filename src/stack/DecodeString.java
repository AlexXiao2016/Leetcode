package stack;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {

		if(s == null || s.length() == 0){
			return null;
		}

		Stack<String> st = new Stack<>(); 
		Stack<Integer> count = new Stack<>();
		int num = 0;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < s.length(); i++){
			char c = s.charAt(i);
			if(Character.isDigit(c)){
				num = num * 10 + (s.charAt(i) - '0');
			}else if(c == '['){
				
				count.push(num);		
				num = 0;
				st.push(sb.toString());
				sb = new StringBuilder();
				
			}else if(c == ']'){
				
				StringBuilder temp = new StringBuilder (st.pop());
				int repeat = count.pop();
				for(int j = 0; j < repeat; j++){
					temp.append(sb);
				}
				sb = temp;
			}else{	
				
				sb.append(c);
			}
		}

		return sb.toString();
	}
}
