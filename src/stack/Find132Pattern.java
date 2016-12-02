package stack;
import java.util.*;

public class Find132Pattern {
	class Pair{
		int min, max;
		public Pair(int min, int max){
			this.min = min;
			this.max = max;
		}
	}
	
	public boolean find132pattern(int[] nums) {
		Stack<Pair> stack = new Stack<>();
		for(int num : nums){
			if(stack.isEmpty() || num < stack.peek().min) stack.push(new Pair(num, num));
			else if(num > stack.peek().min){
				Pair last = stack.pop();
				if(num > last.max) return true;
				else{
					last.max = num;
					while(!stack.isEmpty() && num >= stack.peek().max) stack.pop();
					if(!stack.isEmpty() && stack.peek().min < num) return true;
					stack.push(last);
				}
			}
		}
		return false;
	}
	
	public static void main(String args[]){
		Find132Pattern fp = new Find132Pattern();
		int nums[] = {1,2,3,4};
		System.out.println(fp.find132pattern(nums));
	}
}
