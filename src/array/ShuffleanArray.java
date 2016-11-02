package array;
import java.util.*;

public class ShuffleanArray {
	
    int[] nums;
    int[] bkNums;
	
	public ShuffleanArray(int[] nums) {
		this.nums = nums;
		this.bkNums = nums.clone();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
    	Random r = new Random();
        for(int i = 0; i < bkNums.length; i++){
            int rnd = r.nextInt(bkNums.length);
            int temp = bkNums[i];
            bkNums[i] = bkNums[rnd];
            bkNums[rnd] = temp;
        }
        return bkNums;
    }
}
