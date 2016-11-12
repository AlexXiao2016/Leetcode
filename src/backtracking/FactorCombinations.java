package backtracking;
import java.util.*;


public class FactorCombinations {
	public static List<List<Integer>> getFactors(int n) {
		List<List<Integer>> result = new ArrayList<>();
		backtrack(n, 2, new ArrayList<Integer>(), result);
		return result;
	}

	public static void backtrack(int n, int factor, List<Integer> list, List<List<Integer>> result){
		if(n < 4){
			return;
		}
		for(int i = factor; i <= Math.sqrt(n); i++){
			if(n % i == 0){
				list.add(i);
				list.add(n / i);
				result.add(new ArrayList<>(list));
				list.remove(list.size() - 1);
				backtrack(n / i, i, list, result);
				list.remove(list.size() - 1);
			}	
		}
	}

	public static void main(String args[]){
		System.out.println(getFactors(12).size());
	}
}
