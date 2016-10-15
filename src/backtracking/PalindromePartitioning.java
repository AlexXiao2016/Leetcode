package backtracking;
import java.util.*;

public class PalindromePartitioning {
	
	public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> list = new ArrayList<>();
        backTracking(s, 0, list, result);
        return result;
    }
	
	public static void backTracking(String s, int pos, List<String> list, List<List<String>> result){
		if(pos == s.length()){
			result.add(new ArrayList<>(list));
		}else{
			for(int i = pos; i < s.length(); i++){
				if(isPalindrome(s, pos, i)){
					list.add(s.substring(pos, i + 1));
					backTracking(s, i + 1, list, result);
					list.remove(list.size() - 1);
				}
			}
		}
	}
	
	public static boolean isPalindrome(String s, int start, int end){
		while(start < end){
			if(s.charAt(start++) != s.charAt(end--)){
				return false;
			}
		}
		return true;
	}
	
	public static void main(String args[]){
		String s = "abcacbaefgi";
		List<List<String>> list = partition(s);
		
		for(List<String> l : list){
			for(String str : l){
				System.out.print(str + " ");
			}
			System.out.println();
		}
	}
}
