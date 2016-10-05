package String;

import java.util.HashMap;

public class BullsAndCows {
	public String getHint(String secret, String guess) {
		if(secret == null || guess == null  || secret.length() == 0 || guess.length() == 0){
			return "0A0B";
		}
		
		int i = 0;
		int bulls = 0, cows = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		while(i < secret.length()){
			if(secret.charAt(i) == guess.charAt(i)){
				bulls++;
			}
			if(map.containsKey(secret.charAt(i))){
				map.put(secret.charAt(i), map.get(secret.charAt(i)) + 1);
			}else{
				map.put(secret.charAt(i), 1);
			}			
			i++;
		}
		
		
		for(int j = 0; j < guess.length(); j++){
			if(map.containsKey(guess.charAt(j)) && map.get(guess.charAt(j)) > 0){
				map.put(guess.charAt(j), map.get(guess.charAt(j)) - 1);
				cows++;
			}
		}
		
		String res = "";
		return res + bulls + "A" + (cows - bulls) + "B";
	}
}
