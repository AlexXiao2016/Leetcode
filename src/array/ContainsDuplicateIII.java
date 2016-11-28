package array;
import java.util.*;

public class ContainsDuplicateIII {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
		if(nums == null || nums.length < 2 || k <= 0){
			return false;
		}
		
		TreeSet<Long> set = new TreeSet<>();
		for(int i = 0; i < nums.length; i++){
			Long floor = set.floor((long)nums[i]);
			Long ceiling = set.ceiling((long) nums[i]);
			
			if((floor != null && nums[i] - floor <= t) ||(ceiling != null && ceiling - nums[i] <= t)){
				return true;
			}
			
			set.add((long)nums[i]);
			if(i >= k){
				set.remove((long)nums[i - k]);
			}
		}
		
		return false;				
	}
	
	public static void main(String args[]){
		ContainsDuplicateIII cd = new ContainsDuplicateIII();
		int nums[] = {1,3,1};		
		System.out.print(cd.containsNearbyAlmostDuplicate(nums, 1, 1));
	}
}
