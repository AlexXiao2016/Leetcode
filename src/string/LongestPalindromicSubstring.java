package string;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
        if(s == null || s.length() == 0){
        	return null;
        }
        
        if(s.length() == 1){
        	return s;
        }
        
        String longest = "";
        for(int i = 0; i < s.length(); i++){
        	String temp = findLongest(s, i, i);
        	if(temp.length() > longest.length()){
        		longest = temp;
        	}
        	
        	temp = findLongest(s, i, i + 1);
        	if(temp.length() > longest.length()){
        		longest = temp;
        	}
        }
        return longest;
    }
	
	public String findLongest(String s, int start, int end){
		while(start > 0 && end < s.length() - 1 && s.charAt(start) == s.charAt(end)){
			start--;
			end++;
		}
		return s.substring(start + 1, end);
	}
}
