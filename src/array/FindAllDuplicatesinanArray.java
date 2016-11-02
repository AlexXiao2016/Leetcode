package array;
import java.util.*;

public class FindAllDuplicatesinanArray {
	public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        
        if(nums == null || nums.length <= 1){
            return list;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(nums[Math.abs(nums[i]) - 1] > 0){
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }else{
                list.add(Math.abs(nums[i]));
            }
        }
        return list;
    }
}
