package array;

public class WiggleSort {
	public static void wiggleSort(int[] nums) {
		for(int i = 1; i < nums.length; i++){
			if((i % 2 == 0 && nums[i - 1] < nums[i]) || (i % 2 == 1 && nums[i - 1] > nums[i])){
				int temp = nums[i];
				nums[i] = nums[i - 1];
				nums[i - 1] = temp;
			}
		}
	}
	
	
	public static void main(String args[]){
		int nums[] = {3,5,2,1,4,6};
		wiggleSort(nums);
	}

}
