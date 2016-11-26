package array;
import java.util.*;

public class WiggleSortII {
	public void wiggleSort(int[] nums) {
        int length = nums.length;
        int median = findKthLargest(nums, (length + 1) / 2);
        int odd = 1;
        int even = length % 2 == 0? length - 2 : length - 1;
        int temp[] = new int[length];
        
        for(int i = 0; i < length; i++){
            if(nums[i] > median){
                temp[odd] = nums[i];
                odd += 2;
                continue;
            }
            if(nums[i] < median){
                temp[even] = nums[i];
                even -= 2;
                continue;
            }
        }
        
        while(odd < length){
            temp[odd] = median;
            odd += 2;
        }
        
        while(even >= 0){
            temp[even] = median;
            even -= 2;
        }
        
        for(int i = 0; i < length; i++){
            nums[i] = temp[i];
        }
    }
    
    public int findKthLargest(int[] nums, int k) {
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
    	WiggleSortII ws = new WiggleSortII();
    	int[] nums = {1,3,2,2,3,1};
    	ws.wiggleSort(nums);
    }
}
