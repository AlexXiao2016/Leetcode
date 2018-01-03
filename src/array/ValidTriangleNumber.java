package array;

import java.util.*;

/**
 * Created by xiaoping on 7/26/17.
 */
public class ValidTriangleNumber {

    public int triangleNumber(int[] nums) {
        if(nums == null || nums.length == 3)    return 0;

        Arrays.sort(nums);
        int res = 0;
        for(int i = 0; i < nums.length - 2; i++){
            int left = i + 1, right = nums.length - 1;
            while(left < right){
                if(nums[i] + nums[left] > nums[right]){
                    res += right - left;
                    left++;
                }else{
                    right--;
                }
            }
        }

        return res;
    }

    public static void main(String[] args){
        ValidTriangleNumber vtn = new ValidTriangleNumber();
        int[] nums = {2,2,3,4};
        System.out.print(vtn.triangleNumber(nums));
    }
}
