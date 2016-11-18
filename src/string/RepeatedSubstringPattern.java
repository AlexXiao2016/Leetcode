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
}
