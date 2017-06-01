package string;
import java.util.*;

public class LongestUncommonSubsequenceII {
	public static int findLUSlength(String[] strs) {
        Arrays.sort(strs, (a, b) -> b.length() - a.length());
        
        int len = strs.length;
        for(int i = 0; i < len; i++){
            int diff = len - 1;
            for(int j = 0; j < len; j++){
                if(i != j && !isSubsequence(strs[i], strs[j])) diff--;
            }
            if(diff == 0) return strs[i].length();
        }
        return -1;
    }
    
    public static boolean isSubsequence(String s1, String s2){
        int i = 0;
        for(int j = 0; j < s2.length(); j++){
            if(i < s1.length() && s1.charAt(i) == s2.charAt(j)){
                i++;
            }
        }
        return i == s1.length();
    }
    
    public static void main(String[] args){
    	String[] strs = {"abcd", "abcd", "adc", "e"};
    	System.out.println(findLUSlength(strs));
    }
    
    
}
