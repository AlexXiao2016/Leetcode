package hashTable;
import java.util.*;

public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
		
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
        	if(!map.containsKey(num)){
        		int left = map.getOrDefault(num - 1, 0);
        		int right = map.getOrDefault(num + 1, 0);
        		
        		int sum = left + right + 1;
        		map.put(num, sum);
        		res = Math.max(res, sum);
        		
        		map.put(num - left, sum);
        		map.put(num + right, sum);
        	}
        }
        return res;
    }
	
	public static void main(String args[]){
		int[] nums = {1,2,3,4,5,6,8};
		LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
		lcs.longestConsecutive(nums);
	}
}
