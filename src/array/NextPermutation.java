package array;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if(nums == null || nums.length <= 1){
			return;
		}
		
		int i = nums.length - 1; 
		while(i > 0){
			if(nums[i] > nums[i - 1]){
				break;
			}
			i--;
		}
		
		if(i != 0){
			swap(nums, i - 1);
		}
		
		reverse(nums, i);
	}
	
	public void swap(int[] nums, int index){
		for(int j = nums.length - 1; j > index; j--){
			if(nums[j] > nums[index]){
				int temp = nums[j];
				nums[j] = nums[index];
				nums[index] = temp;
				break;
			}
		}
	}
	
	public void reverse(int[] nums, int a){
		int b = nums.length - 1;
		while(a < b){
			int temp = nums[a];
			nums[a++] = nums[b];
			nums[b--] = temp;
		}
	}
}
