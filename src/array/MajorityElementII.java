package array;
import java.util.*;

public class MajorityElementII {
	public List<Integer> majorityElement(int[] nums) {
		if(nums == null || nums.length == 0) return new ArrayList<Integer>();
		
		List<Integer> result = new ArrayList<>();
		int mNo1 = 0, mNo2 = 0, count1 = 0, count2 = 0, length = nums.length;
		for(int i = 0; i < length; i++){
			if(nums[i] == mNo1){
				count1++;
			}else if(nums[i] == mNo2){
				count2++;
			}else if(count1 == 0){
				mNo1 = nums[i];
				count1 = 1;
			}else if(count2 == 0){
				mNo2 = nums[i];
				count2 = 1;
			}else{
				count1--;
				count2--;
			}
		}
		count1 = 0;
		count2 = 0;
		for(int i = 0; i < length; i++){
			if(nums[i] == mNo1)	count1++;
			else if(nums[i] == mNo2) count2++;			
		}
		if(count1 > length / 3) result.add(mNo1);
		if(count2 > length / 3) result.add(mNo2);
		return result;
	}
	
	public static void main(String args[]){
		MajorityElementII m = new MajorityElementII();
		int nums[] = {0,1,2,0};
		m.majorityElement(nums);
	}
}
