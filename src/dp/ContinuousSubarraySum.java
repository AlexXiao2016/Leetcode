package dp;
import java.util.*;

public class ContinuousSubarraySum {
	public static boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        
        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            if(k != 0) sum %= k;
            Integer prev = map.get(sum);
            if(prev != null){
            	if(i - prev > 1){            
            		return true;
                }
            }else{
            	map.put(sum, i);
            }
        }
        return false;
    }
	
	public static void main(String args[]){
		int nums[] = {0, 0, 0};
		System.out.print(checkSubarraySum(nums, 6));
	}
}
