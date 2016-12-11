package string;

public class RepeatedSubstringPattern {
	public boolean repeatedSubstringPattern(String str) {
        if(str == null || str.length() == 0){
            return false;
        }
        
        int len = str.length();
        for(int i = len / 2; i >= 1; i--){
        	if(len % i == 0){
        		int count = len / i;
        		int start = 0;
        		int j = 1;
        		String sub = str.substring(start, i);
        		for(; j < count; j++){
        			if(!sub.equals(str.substring(i * j, i + j * i))){
        				break;
        			}
        		}
        		if(j == count){
        			return true;
        		}
        	}
        }
                      
        return false;
    }
	
	public static boolean repeatedSubstringPattern2(String str) {
        if(str == null || str.length() == 0) return true;
        
        int n = str.length();
        for(int len = n / 2; len >= 1; len--){
            if(n % len != 0) continue;
            String base = str.substring(0, len);
            int start = len;
            while(start + len <= n ){
                if(!str.substring(start, start + len).equals(base)) break;
                start += len;
            }
            if(start == n){
            	return true;
            }
        }
        
        return true;
    }
	
	public static void main(String args[]){
		String s= "abab";
		repeatedSubstringPattern2(s);
	}
}
