package string;

public class IsSubsequence {

	public boolean isSubsequence(String s, String t) {
		if(s == null || t == null){
			return false;
		}
		
		int sLen = s.length();
		int tLen = t.length();
		if(sLen > tLen){
			return false;
		}
		
		int i = 0, j = 0;
		while(i < sLen && j < tLen){
			if(s.charAt(i) == t.charAt(j++)){
				i++;
			}
		}
		
		if(sLen == i){
			return true;
		}
		return false;
	}
}
