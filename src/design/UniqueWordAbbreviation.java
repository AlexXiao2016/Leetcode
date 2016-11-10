package design;
import java.util.*;

public class UniqueWordAbbreviation {
	
	HashMap<String, String> map;
	
	public UniqueWordAbbreviation(String[] dictionary) {
		map = new HashMap<>();
		for(String str : dictionary){
			String key = getKey(str);
			if(map.containsKey(key) && !map.get(key).equals(str)){
				map.put(key, "");
			}else{
				map.put(key, str);
			}
		}
	}

	public boolean isUnique(String word) {
		return !map.containsKey(getKey(word)) || map.get(getKey(word)).equals(word);
	}
	
	private String getKey(String str){
		if(str.length() <= 2){
			return str;
		}else{
			StringBuilder sb = new StringBuilder();
			return sb.append(str.charAt(0)).append(str.length() - 2).append(str.charAt(str.length() - 1)).toString();  
		}		
	}
	
	public static void main(String args[]){
		String dict[] = {"deer", "door", "cake", "card"};
		
		UniqueWordAbbreviation obj = new UniqueWordAbbreviation(dict);
		System.out.println(obj.isUnique("make"));
	}
}
