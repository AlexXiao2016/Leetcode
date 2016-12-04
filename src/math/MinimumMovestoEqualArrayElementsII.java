package math;

public class MinimumMovestoEqualArrayElementsII {
	public int minMoves2(int[] nums) {
		if(nums == null || nums.length < 2){
			return 0;
		}
		
		int median = getKth(nums, 0, nums.length - 1, nums.length / 2 + 1);
		int sum = 0;
		for(int i = 0; i < nums.length; i++){
			sum += Math.abs(nums[i] - median);
		}
		return sum;
	}
	
	public int getKth(int[] nums, int start, int end, int k){
		int pivot = nums[end];
		int left = start;
		int right = end;
		
		while(true){
			while(nums[left] < pivot && left < right) left++;
			while(nums[right] >= pivot && left < right) right--;
			if(left == right) break;
			swap(nums, left, right);
		}
		
		swap(nums, left, end);
		if(k == left + 1) return pivot;
		else if(k < left + 1) return getKth(nums, start, left - 1, k);
		else return getKth(nums, left + 1, end, k);
	}
	
	public void swap(int[] nums, int left, int right){
		if(left != right){
			nums[left] = nums[left] ^ nums[right];
			nums[right] = nums[right] ^ nums[left];
			nums[left] = nums[left] ^ nums[right];
		}
	}
	
	public static void main(String args[]){
		int[] nums = {1, 2, 3};
		MinimumMovestoEqualArrayElementsII moves = new MinimumMovestoEqualArrayElementsII();
		moves.minMoves2(nums);
//		moves.swap(nums, 0, 2);
	}
}
