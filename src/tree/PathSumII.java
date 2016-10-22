package tree;

import java.util.*;

public class PathSumII {
	public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        helper(root, sum, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void helper(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result){
        if(root == null) return;
        
        list.add(root.val);
        
        if(root.left == null && root.right == null && sum == root.val){
            result.add(new ArrayList<Integer>(list));
        }else{
            helper(root.left, sum - root.val, list, result);
            helper(root.right, sum - root.val, list, result);
        }
        
        list.remove(list.size() - 1);
    }
    
    
}
