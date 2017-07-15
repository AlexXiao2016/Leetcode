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


	public String decodeString2(String s) {
		Stack<Integer> countStack = new Stack<>();
		Stack<String> resStack = new Stack<>();
		StringBuilder res = new StringBuilder();
		int i = 0;

		while(i < s.length()){
			if(Character.isDigit(s.charAt(i))) {
				int count = 0;
				while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					count = count * 10 + s.charAt(i) - '0';
					i++;
				}
				countStack.push(count);
			}else if(s.charAt(i) == '['){
				resStack.push(res.toString());
				res = new StringBuilder();
			}else if(s.charAt(i) == ']'){
				int counter = countStack.pop();
				StringBuilder temp = new StringBuilder(resStack.pop());
				for(int j = 0; j < counter; j++){
					temp.append(res);
				}
				res = temp;
				// res = new StringBuilder();
			}else{
				res.append(s.charAt(i));
			}
			i++;
		}

		return res.toString();
	}

	public static void main(String args[]){
		DecodeString ds = new DecodeString();
		ds.decodeString2("3[a2[c]]");
	}
}
