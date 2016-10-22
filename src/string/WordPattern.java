package string;

import java.util.HashMap;

public class WordPattern {
	 public boolean wordPattern(String pattern, String str) {
		 HashMap<Character, String> patternMap = new HashMap<>();
		 HashMap<String, Character> strMap = new HashMap<>();
		 
		 String[] strArray = str.split(" ");
		 if(strArray.length != pattern.length()){
			 return false;
		 }
		 
		 int i = 0;
		 while(i < strArray.length){
			 patternMap.put(pattern.charAt(i), strArray[i]);
			 strMap.put(strArray[i], pattern.charAt(i));
			 i++;
		 }
		 
		 for(int j = 0; j < strArray.length; j++){
			 if(!patternMap.get(pattern.charAt(j)).equals(strArray[j])){
				 return false;
			 }
			 if(strMap.get(strArray[j]) != pattern.charAt(j)){
				 return false;
			 }
		 }
		 
		 return true;
	 }
}
