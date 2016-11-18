package backtracking;
import java.util.*;

public class PermutationSequence {
	public static String getPermutation(int n, int k) {
		int[] factorial = new int[n + 1];
		ArrayList<Integer> number = new ArrayList<>();
		
		factorial[0] = 1;
		int sum = 1;
		for(int i = 1; i < n + 1; i++){
			sum *= i;
			factorial[i] = sum;
		}
		
		for(int i = 1; i <= n; i++){
			number.add(i);
		}
		
		k--;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++){
			int index = k / factorial[n - i];
			sb.append(number.get(index));
			number.remove(index);
			k -= index * factorial[n - i];
		}
		
		return sb.toString();
	}
	
	public static void main(String args[]){
		System.out.print(getPermutation(9, 22));
	}
}
