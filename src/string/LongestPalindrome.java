package string;

public class LongestPalindrome {
	public static int longestPalindrome(String s){
		int count[] = new int[60];
        char arr[] = s.toCharArray();
        
        for(int i = 0; i < arr.length; i++){
            count[arr[i] - 'A']++;
        }
        
        int length = 0;
        int odd = 0;
        for(int i = 0; i < 60; i++){
            if(count[i] != 0 && count[i] % 2 == 0){
                length += count[i];
            }
            if(count[i] != 0 && count[i] % 2 != 0){
                odd = 1;
                length += count[i] - 1;
            }
        }
        
        if(odd != 0){
            length += 1;
        }
        
        return length;
	}
}
