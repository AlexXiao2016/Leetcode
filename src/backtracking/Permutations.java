package backtracking;
import java.util.*;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		backtracking(nums, new ArrayList<Integer>(), res);
		return res;
	}
	
	public void backtracking(int[] nums, List<Integer> list, List<List<Integer>> res){
		if(list.size() == nums.length){
			res.add(new ArrayList<>(list));
		}else{
			for(int i = 0; i < nums.length; i++){
				if(list.contains(nums[i])){
					continue;
				}else{
					list.add(nums[i]);
					backtracking(nums, list, res);
					list.remove(list.size() - 1);
				}
			}
		}
	}
}
