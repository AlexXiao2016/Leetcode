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
	
	public static void main(String args[]){
		letterCombinations("1023123");
	}
}	
