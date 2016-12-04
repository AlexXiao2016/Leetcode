package bitmanipulation;
import java.util.*;

public class MaximumXOR {
	public int findMaximumXOR(int[] nums) {
		int max = 0, mask = 0;
		for(int i = 31; i >= 0; i--){
			mask = mask | (1 << i);
			Set<Integer> set = new HashSet<>();
			for(int num : nums){
				set.add(num & mask);
			}
			int tmp = max | (1 << i);
			for(int prefix : set){
				if(set.contains(tmp ^ prefix)){
					max = tmp;
					break;
				}
			}
		}
		return max;
	}
	
	public static void main(String args[]){
		MaximumXOR max = new MaximumXOR();
		int nums[] = {2, 5, 7, 8};
		max.findMaximumXOR(nums);
	}
}	
