package tree;
import java.util.*;

public class BinaryTreeRightSideView {
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        
        Queue<NewNode> queue = new LinkedList<>();
        queue.offer(new NewNode(1, root));
        int preLevel = 0;
        while(!queue.isEmpty()){
            NewNode cur = queue.poll();
            int level = cur.level;
            if(level == preLevel + 1){
                res.add(cur.node.val);
            }
            preLevel = level;
            if(cur.node.right != null){
                queue.offer(new NewNode(level + 1, cur.node.right));
            }
            if(cur.node.left != null){
                queue.offer(new NewNode(level + 1, cur.node.left));
            }
        }
        return res;
    }
    
    class NewNode{
        int level;
        TreeNode node;
        NewNode(int level, TreeNode node){
            this.level = level;
            this.node = node;
        }
    }
    
    
    public List<Integer> rightSideView2(TreeNode root){
    	List<Integer> res = new ArrayList<>();
    	rightSideViewRec(root, res, 0);
    	return res;
    } 
    
    public void rightSideViewRec(TreeNode cur, List<Integer> res, int depth){
    	if(cur == null) return;
    	
    	if(res.size() == depth) res.add(cur.val);
    	rightSideViewRec(cur.right, res, depth + 1);
    	rightSideViewRec(cur.left, res, depth + 1);
    }
}
