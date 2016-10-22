package string;

public class LongestSubstringwithAtLeastKRepeatingCharacters {
	public static int longestSubstring(String s, int k) {
		char c[] = s.toCharArray();
	    return helper(c, 0, s.length(), k);
	}
	private static int helper(char[] str, int start, int end,  int k){
	    if(start >= end || end - start < k) {
	    	return 0;
	    }
	    int count[] = new int[26];
	    for(int i = start; i < end; i++){
	    	count[str[i] - 'a']++;
	    }
	    for(int i = 0; i < 26; i++){
	    	if(count[i] == 0) {
	    		continue;
	    	}
	    	if(count[i] < k){
	    		for(int j = start; j < end; j++){
	    			if(str[j] == i + 'a'){
	    				int left = helper(str, start, j, k);
	    				int right = helper(str, j + 1, end, k);
	    				return Math.max(left, right);
	    			}
	    		}
	    	}
	    }	    
	    return end - start;	    
	}
	
	public static void main(String args[]){
		int k = longestSubstring("abcacbafpooip", 2);
		System.out.println(k);
	}
}
