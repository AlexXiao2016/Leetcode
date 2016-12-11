package string;

import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {
	public int lengthOfLongestSubstring(String s) {
		if(s == null || s.length() == 0){
            return 0;
        }
        int max = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i = 0, j = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                j = Math.max(j, map.get(c) + 1);
            }
            map.put(c, i);
            max = Math.max(max, i - j + 1);
        }
        
        return max;
	}
	
	public static int getLengthSlidingWindow(String s){
		int hash[] = new int[26];
        int begin = 0, end = 0;
        int max = 0;
        while(end < s.length()){
            if(hash[s.charAt(end) - 'a'] == 0){
                hash[s.charAt(end) - 'a']++;
                end++;
            }else{
                if(hash[s.charAt(begin) - 'a'] != 0){
                    hash[s.charAt(begin) - 'a']--;
                    begin++;
                }
            }
            
            max = Math.max(max, end - begin);
        }
        
        return max;
	}
	
	public static void main(String args[]){
		getLengthSlidingWindow("abcabcbb");
	}
}
