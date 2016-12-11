package backtracking;
import java.util.*;

public class Subsets {
	public List<List<Integer>> subsets(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length == 0) return res;
		
		backtrack(nums, 0, new ArrayList<>(), res);
		return res;		
	}
	
	public void backtrack(int[] nums, int index, List<Integer> list, List<List<Integer>> res){
		res.add(new ArrayList<Integer>(list));
		
		for(int i = 0; i < nums.length; i++){
			list.add(nums[i]);
			backtrack(nums, index + 1, list, res);
			list.remove(list.size() - 1);
		}
	}
	
	public List<List<Integer>> subsetsIterative(int[] nums){
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<Integer>());
		
		Arrays.sort(nums);
		for(int num : nums){
			List<List<Integer>> temp = new ArrayList<>();
			for(List<Integer> sub : res){
				List<Integer> list  = new ArrayList<>(sub);
				list.add(num);
				temp.add(list);
			}
			res.addAll(temp);
		}
		return res;
	}
}
