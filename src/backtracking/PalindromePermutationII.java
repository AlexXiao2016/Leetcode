package backtracking;
import java.util.*;

public class PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
		List<String> res = new ArrayList<>();
		HashMap<Character, Integer> map = new HashMap<>();
		List<Character> list = new ArrayList<>();
		
		for(int i = 0; i < s.length(); i++){
			char key = s.charAt(i);
			map.put(key, map.getOrDefault(key, 0) + 1);
		}
		
		int odd = 0;
		Character extraCh = null;
		for(Character ch : map.keySet()){
			int count = map.get(ch);
			if(count % 2 != 0){
				extraCh = ch;
				odd += (count % 2);
				if(odd > 1) return res;
			}					
			while(count / 2 != 0){
				list.add(ch);
				count -= 2;
			}
		}
		
		boolean[] used = new boolean[list.size()];
		backtrack(s, list, extraCh, used, new StringBuilder(), res);
		return res;
	}
	
	private void backtrack(String s, List<Character> list, Character mid, boolean[] used, StringBuilder sb, List<String> res){
		if(sb.length() == list.size()){
			if(mid == null){
				res.add(sb.toString() + sb.reverse().toString());
			}else{
				res.add(sb.toString() + mid + sb.reverse().toString());
			}
			sb.reverse();
			return;
		}
		
		for(int i = 0; i < list.size(); i++){
			if(i > 0 && list.get(i - 1) == list.get(i) && used[i - 1] == false) continue;
			
			if(!used[i]){
				used[i] = true;
				sb.append(list.get(i));
				backtrack(s, list, mid, used, sb, res);
				used[i] = false;
				sb.deleteCharAt(sb.length() - 1);
			}
		}
	}
	
}
