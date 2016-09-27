package stack;

import java.util.Stack;

public class DecodeString {
	public String decodeString(String s) {

		/*
		String res = "";
		Stack<Integer> countStack = new Stack<>();
		Stack<String> resStack = new Stack<>();
		int idx = 0;
		while (idx < s.length()) {
			if (Character.isDigit(s.charAt(idx))) {
				int count = 0;
				while (Character.isDigit(s.charAt(idx))) {
					count = 10 * count + (s.charAt(idx) - '0');
					idx++;
				}
				countStack.push(count);
			}
			else if (s.charAt(idx) == '[') {
				resStack.push(res);
				res = "";
				idx++;
			}
			else if (s.charAt(idx) == ']') {
				StringBuilder temp = new StringBuilder (resStack.pop());
				int repeatTimes = countStack.pop();
				for (int i = 0; i < repeatTimes; i++) {
					temp.append(res);
				}
				res = temp.toString();
				idx++;
			}
			else {
				res += s.charAt(idx++);
			}
		}
		return res;*/
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
			}else if(s.charAt(i) == '['){
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
