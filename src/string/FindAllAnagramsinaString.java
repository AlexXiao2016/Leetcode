package string;
import java.util.*;

public class FindAllAnagramsinaString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		if(s == null || p == null || s.length() < p.length()) return result;
		
		char pc[] = p.toCharArray();
		int map[] = new int[256];
		for(int i = 0; i < pc.length; i++){
			map[pc[i]]++; 
		}
		
		int start = 0, end = 0, count = p.length();
		while(end < s.length()){
			if(map[s.charAt(end++)]-- >= 1) count--;
			if(count == 0) result.add(start);
			if(end - start == p.length() && map[s.charAt(start++)]++ >= 0) count++;
		}
		return result;
	}
}
