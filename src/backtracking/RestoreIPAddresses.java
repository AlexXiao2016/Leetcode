package backtracking;
import java.util.*;

public class RestoreIPAddresses {
	public List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();
		if(s.length() < 4 || s.length() > 12){
			return res;
		}
		
		int len = s.length();
		for(int i = 0; i < 4 && i < len - 2; i++){
			for(int j = i + 1; j < i + 4 && j < len - 1; j++){
				for(int k = j + 1; k < j + 4 && k < len; k++){
					String s1 = s.substring(0, i);
					String s2 = s.substring(i, j);
					String s3 = s.substring(j, k);
					String s4 = s.substring(k);
					if(isValid(s1) && isValid(s2) && isValid(s3) && isValid(s4)){
						res.add(s1 + "." + s2 + "." + s3 + "." + s4);
					}
				}
			}
		}
		return res;
	}	
	
	public boolean isValid(String s){
		if(s.length() > 3 || s.length() == 0 || (s.charAt(0) == '0' && s.length() > 1) || Integer.valueOf(s) > 255){
			return false;
		}
		return true;
	}
	
	
	public List<String> restoreIpAddressesDFS(String s) {
		List<String> res = new ArrayList<>();
		
		backtrack(res, s, "", 4);
		return res;
	}
	
	public void backtrack(List<String> res, String s, String ip, int k){
		if(s.length() > 3 * k || s.length() < k){
			return ;
		}
		
		if(k == 0){
			res.add(ip.substring(0, ip.length() - 1));
			return;
		}
		
		int maxLen = s.charAt(0) == '0' ? 1 : Math.min(s.length(), 3);
		
		for(int len = 1; len <= maxLen; len++){
			if(Integer.valueOf(s.substring(0, len)) > 255){
				continue;
			}
			backtrack(res, s.substring(len), ip + s.substring(0, len) + ".", k - 1);
		}
	}
	
	public static void main(String args[]){
		String s = "0000";
		RestoreIPAddresses ip = new RestoreIPAddresses();
		ip.restoreIpAddressesDFS(s);
	}
}
