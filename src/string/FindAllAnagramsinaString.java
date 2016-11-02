package string;

import java.util.*;

public class FindAllAnagramsinaString {
	public static List<Integer> findAnagrams(String s, String p){
		List<Integer> res = new ArrayList<>();
		if(s == null || p == null || s.length() == 0 || p.length() == 0 || s.length() < p.length()){
			return res;
		}

		int map[] = new int[26];
		for(int i = 0; i < p.length(); i++){
			map[p.charAt(i) - 'a']++;
		}

		int start = 0, end = 0, count = p.length();
		while(end < s.length()){
			if(map[s.charAt(end++) - 'a']-- >= 1){
				count--;
			}

			if(count == 0){
				res.add(start);
			}

			if(end - start == p.length() && map[s.charAt(start++) - 'a']++ >= 0){
				count++;
			}
		}

		return res;		
	}

	public static void main(String args[]){
		String s1 = "cbcebabacd";
		String s2 = "abc";
		findAnagrams(s1, s2);		
	}
}
