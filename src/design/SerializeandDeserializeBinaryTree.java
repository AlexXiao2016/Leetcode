package design;
import java.util.*;

public class SerializeandDeserializeBinaryTree {
	public String serialize(TreeNode root) {
		if(root == null) return "";
		Queue<TreeNode> temp = new LinkedList<>();
		temp.offer(root);
		StringBuilder sb = new StringBuilder();
		while(!temp.isEmpty()){
			TreeNode node = temp.poll();
			if(node == null){
				sb.append("# ");
				continue;
			}
			sb.append(node.val + " ");
			temp.offer(node.left);
			temp.offer(node.right);

		}
		return sb.toString();
	}

	public TreeNode deserialize(String data) {
		if(data.isEmpty()) return null;
		String[] values = data.split(" ");
		TreeNode root = new TreeNode(Integer.valueOf(values[0]));
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		for(int i = 1; i < values.length; i++){
			TreeNode node = queue.poll();
			if(!values[i].equals("#")){
				TreeNode left = new TreeNode(Integer.valueOf(values[i]));
				node.left = left;
				queue.offer(left);
			}

			if(!values[++i].equals("#")){
				TreeNode right = new TreeNode(Integer.valueOf(values[i]));
				node.right = right;
				queue.offer(right);
			}
		}
		return root;
	}
}	

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
