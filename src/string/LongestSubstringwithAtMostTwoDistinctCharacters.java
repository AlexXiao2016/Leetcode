package string;
import java.util.*;

public class LongestSubstringwithAtMostTwoDistinctCharacters {
	public static int lengthOfLongestSubstringTwoDistinct(String s) {
		if(s == null) return 0;
		if(s.length() <= 2) return s.length();
		
		HashMap<Character, Integer> map = new HashMap<>();
		int start = 0, end = 0;
		int res = 0;
		while(end < s.length()){
			if(map.containsKey(s.charAt(end)) || map.size() < 2){
				if(!map.containsKey(s.charAt(end))) map.put(s.charAt(end), end);
				res = Math.max(end - start + 1, res);
			}else{
			    res = Math.max(end - start, res);
				map.remove(s.charAt(start));
				start = map.values().iterator().next();	
				end = start;
			}
			
			end++;
		}
		return res;
	}
	
	public static void main(String args[]){
		int l = lengthOfLongestSubstringTwoDistinct("eceba");
		System.out.println(l);
	}
}
