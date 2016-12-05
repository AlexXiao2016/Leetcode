package string;

public class NumberofSegmentsinaString {
	public int countSegments(String s) {
        if(s == null || s.length() == 0) return 0;
        
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if((i > 0 && s.charAt(i - 1) != ' ') || s.charAt(i) == ' '){
                continue;
            }else{
                count++;
            }
        }
        return count;
    }
}
