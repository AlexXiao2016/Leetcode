package tree;

import java.util.Stack;

public class VerifyPreorderSerializationofaBinaryTree {
	public static boolean isValidSerialization(String preorder) {
		
		if(preorder == null || preorder.length() == 0){
			return false;
		}
		
		Stack<String> s = new Stack<>();
		String str[] = preorder.split(",");
		for(int i = 0; i < str.length; i++){
			String curr = str[i];
			while(curr.equals("#") && !s.isEmpty() && s.peek().equals(curr)){
				s.pop();
				if(s.isEmpty()){
					return false;
				}
				s.pop();
			}
			s.push(curr);
		}
		return s.size() == 1 && s.peek().equals("#");
	}
	
	public static void main(String args[]){
		System.out.println(isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
	}
}
