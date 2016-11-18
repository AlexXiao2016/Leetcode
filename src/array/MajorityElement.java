package array;

public class MajorityElement {
	
	public int majorityElement(int[] nums) {
		int m_index = 0, count = 1;
		for(int i = 1; i < nums.length; i++){
			if(nums[m_index] == nums[i]){
				count++;
			}else{
				count--;
			}
			
			if(count == 0){
				m_index = i;
				count = 1;
			}
		}
		
		return nums[m_index];
	}
}
