package hashTable;

public class PalindromePermutation {
	public boolean canPermutePalindrome(String s) {
        if(s == null || s.length() == 0){
            return false;
        }
        
        int[] map = new int[256];
        char[] str = s.toCharArray();
        for(int i = 0; i < str.length; i++){
            map[str[i]]++;
        }
        
        int numOfOdds = 0;
        for(int i = 0; i < map.length; i++){
            if(map[i] % 2 != 0){
                numOfOdds++;
            }
            if(numOfOdds == 2) return false;
        }
        return true;
    }
}
