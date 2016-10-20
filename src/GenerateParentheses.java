import java.util.*;

public class GenerateParentheses {
	public List<String> generateParenthesis(int n) {
		List<String> result = new ArrayList<>();
		if(n == 0){
			return result;
		}
		dfs(n, n, "", result);
		return result;
	}
	
	public void dfs(int left, int right, String str, List<String> result){
		if(right == 0){
			result.add(str);
		}
		if(left > 0){
			dfs(left - 1, right, str + "(", result);
		}
		if(right > left){
			dfs(left, right - 1, str + ")", result);
		}		
	}
}
