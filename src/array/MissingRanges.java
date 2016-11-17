package array;
import java.util.*;

public class MissingRanges {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
		List<String> res = new ArrayList<>();
		if(nums == null || nums.length == 0){
			if(lower == upper){
				res.add(lower + "");
			}else if(lower < upper){
				res.add(lower + "->" + upper);
			}
			return res;
		}
		for(int i = 0; i< nums.length; i++){
		    if(nums[i] == Integer.MIN_VALUE) {
		        lower = nums[i] + 1;
		        continue;
		    }
			int justbelow = nums[i] - 1;
			if(lower == justbelow){
				res.add(String.valueOf(lower));
			}else if(lower < justbelow){
				res.add(lower + "->" + justbelow);
			}
			if(nums[i] == Integer.MAX_VALUE) return res;
			lower = nums[i] + 1;			
		}
		if(lower == upper) res.add(lower + "");
		else if(lower < upper) res.add(lower + "->" + upper);
		return res;
	}
}
