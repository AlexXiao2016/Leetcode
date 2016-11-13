package backtracking;
import java.util.*;

public class StrobogrammaticNumberII {
	public List<String> findStrobogrammatic(int n) {
		return findStrobogrammatic(n, n);
	}
	
	public List<String> findStrobogrammatic(int n, int m){
		if(n == 0) return new ArrayList<String>(Arrays.asList(""));
		if(n == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
		
		List<String> list = findStrobogrammatic(n - 2, m);
		List<String> result = new ArrayList<>();
		
		for(int i = 0; i < list.size(); i++){
			String s = list.get(i);
			
			if(n < m) {
				result.add("0" + s + "0");
			}
			
			result.add("1" + s + "1");
			result.add("6" + s + "9");
			result.add("8" + s + "8");
			result.add("9" + s + "6");
		}
		
		return result;
	}
	
	public List<String> findStrobogrammatic2(int n) {
        List<String> cur, ans;
        ans = new ArrayList<String>((n & 1) == 0 ? Arrays.asList("") : Arrays.asList("0", "1", "8"));
        if (n < 2) return ans;
        
        for (;n > 1; n -= 2) {
            cur = ans;
            ans = new ArrayList<String>();
            for (String i : cur) {
                if (n > 3) ans.add('0' + i + '0');
                ans.add('1' + i + '1');
                ans.add('8' + i + '8');
                ans.add('6' + i + '9');
                ans.add('9' + i + '6');
            }
        }
        
        return ans;
    }
	
	public static void main(String args[]){
		StrobogrammaticNumberII eg = new StrobogrammaticNumberII();
		for(String str : eg.findStrobogrammatic2(4)){
			System.out.print(str + " ");
		}
	}
}
