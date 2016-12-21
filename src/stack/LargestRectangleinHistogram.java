package stack;
import java.util.*;

public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		if(heights == null || heights.length == 0) return 0;
		
		Stack<Integer> stack = new Stack<>();
		int max = 0;
		for(int i = 0; i < heights.length; i++){
			int height = (i == heights.length ? 0 : heights[i]);
			if(stack.isEmpty() || height >= heights[stack.peek()]){
				stack.push(i);				
			}else{
				int top = stack.pop();
				max = Math.max(max, heights[top] * (stack.isEmpty() ? i : i - 1 - stack.peek()));
				i--;
			}
		}
		return max;
	}
}
