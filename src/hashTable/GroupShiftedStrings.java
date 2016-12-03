package hashTable;
import java.util.*;

public class GroupShiftedStrings {
	public List<List<String>> groupStrings(String[] strings) {
		List<List<String>> res = new ArrayList<>();
		if(strings == null || strings.length == 0) return res;
		
		HashMap<String, List<String>> map = new HashMap<>();
		for(String str : strings){
			String key = reSetKey(str);
			if(!map.containsKey(key)){
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(str);			
		}
		
		for(List<String> value : map.values()){
			Collections.sort(value);
			res.add(value);
		}
		return res;
	}
	
	private String reSetKey(String s){
		int diff = s.charAt(0) - 'a';
		StringBuilder sb = new StringBuilder();
		for(char c : s.toCharArray()){
			sb.append((c + 26 - diff) % 26);
		}
		return sb.toString();
	}
	
	
	
	public static void main(String args[]){
		String[] strs = {"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
		GroupShiftedStrings gss = new GroupShiftedStrings();
		gss.groupStrings(strs);
	}
}
