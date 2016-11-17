package string;

public class RemoveKDigits {
	public String removeKdigits(String num, int k) {
        if(num == null || num.length() == 0 || num.length() <= k){
            return "0";
        }
        
        int n = num.length();
        int len = n - k;
        char[] res = new char[len];
        
        for(int i = 0, j = 0; i < n; i++){
        	while(n - i + j > len && j > 0 && res[j - 1] > num.charAt(i)) j--;
        	if(j < len){
        		res[j++] = num.charAt(i);
        	}
        }
        
        int offset = 0;
        while(offset < len && res[offset] == '0'){
        	offset++;
        }
        
        return len-offset == 0 ? "0" : new String(res, offset, len-offset);
    }
           
    public static void main(String args[]){
    	RemoveKDigits rkd = new RemoveKDigits();
    	System.out.println(rkd.removeKdigits("10", 1));
    }
}
