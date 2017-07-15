package array;

public class ArrayNesting {
	public static int arrayNesting(int[] nums) {
        int max = 0;
        
        for(int i = 0; i < nums.length; i++){                        
            int size = 0;
            for(int k = i; nums[k] >= 0; size++){
                int num = nums[k];
                nums[k] = -1;
            	k = num;            	
            }
            max = Math.max(max, size);
        }
        return max;
    }
	
	public static void main(String args[]){
		int nums[] = {1, 0, 2};
		System.out.println(arrayNesting(nums));
		
	}	
}
