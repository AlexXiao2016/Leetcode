import java.util.*;

public class DifferentWaystoAddParentheses {
	public static List<Integer> diffWaysToCompute(String input) {
		List<Integer> nums = new ArrayList<>();
		List<Character> ops = new ArrayList<>();
		
		int value = -1;
		for(int i = 0; i < input.length(); i++){
			char c = input.charAt(i);
			if(c == '+' || c == '-' || c == '*'){
				if(value >= 0){
					nums.add(value);
					value = -1;
				}
				ops.add(c);
			}else{
				if(value < 0){
					value = c - '0';
				}else{
					value = value * 10 + c - '0';
				}
			}
		}
		if(value >= 0){
			nums.add(value);
		}
		
		return diffWaysToCompute(nums, ops, 0, nums.size() - 1);
	}
	
	public static List<Integer> diffWaysToCompute(List<Integer> nums, List<Character> ops, int start, int end){
		
		List<Integer> result = new ArrayList<>();
		if(ops.isEmpty()){
			result.add(nums.get(0)) ;
		}
		if(start == end){
			result.add(nums.get(start));
		}else if(start + 1 == end){
			result.add(getValue(nums.get(start), nums.get(end), ops.get(start)));
		}else{
			for(int i = start; i < end; i++){
				List<Integer> left = diffWaysToCompute(nums, ops, start, i);
				List<Integer> right = diffWaysToCompute(nums, ops, i + 1, end);
				for(int v1 : left){
					for(int v2 : right){
						result.add(getValue(v1, v2, ops.get(i)));
					}
				}
			}
		}
		
		return result;
	}
	
	public static int getValue(int a, int b, char c){
		if(c == '+'){
			return a + b;
		}else if(c == '-'){
			return a - b;
		}else{
			return a * b;
		}
	}
	
	public static void main(String args[]){
		String str = "2-1-1";
		List<Integer> res = diffWaysToCompute(str);
		for(int i : res){
			System.out.print(i + " ");
		}
	}
	
}
