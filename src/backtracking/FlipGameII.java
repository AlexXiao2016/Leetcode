package backtracking;

import java.util.*;

public class FlipGameII {
	public boolean canWin(String s) {
		if(s == null || s.length() < 2){
			return false;
		}
		
		HashMap<String, Boolean>  map = new HashMap<>();
		return canWin(s, map);
	}
	
	public boolean canWin(String s, HashMap<String, Boolean> map){
		if(map.containsKey(s)){
			return map.get(s);
		}
		
		for(int i = 0; i < s.length() - 1; i++){
			if(s.startsWith("++", i)){
				String tmp = s.substring(0, i) + "--" + s.substring(i + 2);
				if(!canWin(tmp, map)){
					map.put(s, true);
					return true;
				}
			}
		}
		map.put(s, false);
		return false;
	}
	
	public static void main(String args[]){
		String s = "+++++";
		FlipGameII fg = new FlipGameII();
		System.out.println(fg.canWin(s));
	}
	
}
