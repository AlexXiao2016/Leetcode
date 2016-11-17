package string;

import java.util.*;

public class SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<>();
		if(nums == null || nums.length == 0){
			return res;
		}
		
		int start = nums[0], end = nums[0];
		
		for(int i = 1; i < nums.length; i++){
			if(nums[i - 1] + 1 == nums[i]){
				end++;
			}else if(nums[i - 1] + 1 < nums[i]){
				if(end > start){
					res.add(start + "->" + end);
				}else if(start == end){
					res.add(start + "");
				}
				start = nums[i];
				end = nums[i];
				
			}
		}
		if(start < end){
			res.add(start + "->" + end);
		}else if(start == end){
			res.add(end + "");
		}
		
		return res;
	}
	
	public static void main(String args[]) {
		int[] nums = {1,2,3,6,8,9,10, 15};
		for(String str : summaryRanges(nums)){
			System.out.println(str);
		}
	}
}
