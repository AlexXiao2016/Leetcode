package stack;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {
	public int[] nextGreaterElement(int[] findNums, int[] nums) {
		int[] res = new int[findNums.length];
		Stack<Integer> stack = new Stack<>();
		HashMap<Integer, Integer> map = new HashMap<>();

		for (int num : nums) {
			while (!stack.isEmpty() && num > stack.peek()) {
				map.put(stack.pop(), num);
			}
			stack.push(num);
		}

		while (!stack.isEmpty()) {
			map.put(stack.pop(), -1);
		}

		int i = 0;
		for (int num : findNums) {
			res[i++] = map.get(num);
		}

		return res;
	}
}
