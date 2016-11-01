import java.util.ArrayList;
import java.util.List;

public class LexicographicalNumbers {
	public static List<Integer> lexicalOrder(int n) {
		List<Integer> result = new ArrayList<Integer>();
		
		int curr = 1;
		for(int i = 1; i <= n; i++){
			result.add(curr);
			if(curr * 10 <= n){
				curr *= 10;
			}else if((curr % 10 != 9)&&(curr+ 1 <= n)){
				curr++;
			}
			else{
				while((curr / 10) % 10 == 9){
					curr /= 10;
				}
				curr = curr / 10 + 1;
			}
		}
		
		return result;
	}
	
	public static List<Integer> lexicalOrder1(int n){
		List<Integer> result = new ArrayList<>();
		
		for(int i = 1; i <= 9; i++){
			dfs(i, n, result);
		}
		return result;
	}
	
	public static void dfs(int cur, int n, List<Integer> list){
		if(cur > n){
			return;
		}else{
			list.add(cur);
			for(int i = 0; i <= 9; i++){
				if(10 * cur + i > n){
					return;
				}
				dfs(10 * cur + i, n, list);
			}
		}
	}
	
	public static void main(String args[]){
		List<Integer> list = lexicalOrder(21);
		for(int i : list){
			System.out.print(i + " ");
		}
	}
}
