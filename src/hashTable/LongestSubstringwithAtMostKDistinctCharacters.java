package hashTable;
import java.util.*;

public class LongestSubstringwithAtMostKDistinctCharacters {
	public int lengthOfLongestSubstringKDistinct(String s, int k) {
		if(s == null || k <= 0) return 0;
		if(s.length() < k) return s.length();
		
		int start = 0, max = 0;
		HashMap<Character, Integer> lastSeen = new HashMap<>();
		for(int i = 0; i < s.length(); i++){
			lastSeen.put(s.charAt(i), i);
			if(lastSeen.size() > k){
				int remove = i;
				for(Character c : lastSeen.keySet()){
					remove = Math.min(remove, lastSeen.get(c));
				}
				lastSeen.remove(s.charAt(remove));
				start = remove + 1;
			}
			max = Math.max(max, i - start + 1);
		}
		return max;
	}
}
