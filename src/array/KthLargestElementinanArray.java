package array;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
	public int findKthLargest(int[] nums, int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i = 0; i < nums.length; i++){
			pq.add(nums[i]);
		}

		while(pq.size() > k){
			pq.poll();
		}

		return pq.poll();
	}

	public int findKthLargest2(int[] nums, int k) {


		PriorityQueue<Integer> pq = new PriorityQueue<>();

		for(int i = 0; i < nums.length; i++){
			if(pq.size() < k){
				pq.offer(nums[i]);
			}else{
				int temp = pq.peek();
				if(temp < nums[i]){
					pq.poll();
					pq.offer(nums[i]);
				}
			}		
		}

		return pq.poll();
	}
	
	
	public int findKthLargest3(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(k, (a, b) -> a - b);
        
        for(int i = 0; i < nums.length; i++){
            if(queue.size() >= k){
                if(nums[i] <= queue.peek()) continue;
                queue.poll();
            }
            queue.offer(nums[i]);
        }
        
        return queue.peek();
    }
	
	public static void main(String args[]){
		int[] nums = {1,2,2,4};
		KthLargestElementinanArray obj = new KthLargestElementinanArray();
		obj.findKthLargest3(nums, 1);
	}
}
