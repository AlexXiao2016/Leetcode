package dp;
import java.util.*;

public class WordBreak {
	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean dp[] = new boolean[s.length() + 1];
		dp[0] = true;
		
		for(int i = 1; i <= s.length(); i++){
			for(int j = 0; j < i; j++){
				if(dp[j] && wordDict.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}
			}
		}
		
		return dp[s.length()];
	}
	
	public boolean wordBreak2(String s, Set<String> wordDict) {
		boolean res[] = new boolean[s.length() + 1];
		res[0] = true;
		
		for(int i = 1; i <= s.length(); i++){
			for(String word: wordDict){
				if(word.length() <= i){
					if(res[i - word.length()]){
						if(s.substring(i - word.length(), i).equals(word)){
							res[i] = true;
							break;
						}
					}
				}
			}
		}
		return res[s.length()];
	}
	
	public static void main(String args[]){
		WordBreak wb = new WordBreak();
		Set<String> dict = new HashSet<>();
		dict.add("Leet");
		dict.add("code");
		wb.wordBreak("Leetcode", dict);
	}
}
