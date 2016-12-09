package string;

import java.util.*;

public class LetterCombinationsofaPhoneNumber {
	public static List<String> letterCombinations(String digits) {
		LinkedList<String> result = new LinkedList<>();
		if(digits == null || digits.length() == 0){
			return result;
		}
		String[] map = {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		result.add("");
		for(int i = 0; i < digits.length(); i++){
			int index = digits.charAt(i) - '0';
			while(result.peek().length() == i){
				String temp = result.remove();
				for(char c : map[index].toCharArray()){
					result.add(temp + c);
				}
			}			
		}		
		return result;
	}
	
	public static List<String> letterCombinationsDFS(String digits) {
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        String mapping[] = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(digits, 0, new StringBuilder(), res, mapping);
        return res;
    }
    
    public static void dfs(String digits, int index, StringBuilder sb, List<String> res, String[] mapping){
        if(index >= digits.length()){
            res.add(sb.toString());
            return;
        }
        
        String num = mapping[digits.charAt(index) - '0'];
        for(int i = 0; i < num.length(); i++){
            dfs(digits, index + 1, sb.append(num.charAt(i)), res, mapping);
            sb.deleteCharAt(sb.length() - 1);  //backtracking
        }
    }
	
	public static void main(String args[]){
		letterCombinationsDFS("2");
	}
}	
