package queue;
import java.util.*;

public class SlidingWindowMaximum {

	public static int[] maxSlidingWindow(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k <=0){
			return null;
		}

		int n = nums.length;
		int res[] = new int[n - k + 1];
		Deque<Integer> dq = new LinkedList<>();
		int j = 0;
		for(int i = 0; i < n; i++){
			while(!dq.isEmpty() && dq.peek() < i - k + 1){
				dq.poll();
			}

			while(!dq.isEmpty() && nums[dq.peekLast()] < nums[i]){
				dq.pollLast();
			}

			dq.offer(i);
			if(i >= k - 1){
				res[j++] = nums[dq.peek()];
			}
		}

		return res;
	}

	public static void main(String args[]){
		int[] nums = {1,3,-1,-3,5,3,6,7};
		maxSlidingWindow(nums, 3);
	}
}
