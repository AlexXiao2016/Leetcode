package array;

public class SortTransformedArray {
	public int[] sortTransformedArray(int[] nums, int a, int b, int c) {
        if(nums == null || nums.length == 0){
        	return null;
        }
        
        int[] result = new int[nums.length];
        int start = 0;
        int end = nums.length - 1;
        int j = a >= 0 ? nums.length - 1 : 0;
        while(start <= end){
        	int startValue = getValue(nums[start], a, b, c);
        	int endValue = getValue(nums[end], a, b, c);
        	if(a >= 0){
        		if(startValue >= endValue){
        			result[j--] = startValue;
        			start++;
        		}else{
        			result[j--] = endValue;
        			end--;
        		}
        	}else{
        		if(startValue >= endValue){
        			result[j++] = endValue;
        			end--;
        		}else{
        			result[j++] = startValue;
        			start++;
        		}
        	}        	
        }        
        return result;
    }
	
	private int getValue(int x, int a, int b, int c){
		return a * x * x + b * x + c;
	}
}
