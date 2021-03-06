package string;

import java.util.HashMap;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		HashMap<Character, Character> mapS = new HashMap<>();
		HashMap<Character, Character> mapT = new HashMap<>();
		
		for(int i = 0; i < s.length(); i++){
			mapS.put(s.charAt(i), t.charAt(i));
			mapT.put(t.charAt(i), s.charAt(i));
		}
		
		for(int i = 0; i < s.length(); i++){
			if(mapS.get(s.charAt(i)) != t.charAt(i)){
				return false;
			}
			if(mapT.get(t.charAt(i)) != s.charAt(i)){
				return false;
			}
		}
				
		return true;
	}
}
