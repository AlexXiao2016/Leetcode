package backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class IncreasingSubsequences {
	public List<List<Integer>> findSubsequences(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		helper(res, new ArrayList<>(), nums, 0);
		return res;
	}

	public void helper(List<List<Integer>> res, List<Integer> list, int nums[], int id) {
		if (list.size() > 1)
			res.add(new ArrayList<>(list));
		Set<Integer> set = new HashSet<>();
		for (int i = id; i < nums.length; i++) {
			if (i > 0 && nums[i] < nums[id - 1])
				continue;
			if (set.contains(nums[i]))
				continue;
			list.add(nums[i]);
			set.add(nums[i]);
			list.remove(list.size() - 1);
		}
	}
}
