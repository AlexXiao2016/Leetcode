package tree;

/**
 * Created by xiaoping on 7/15/17.
 */
public class SerializeAndDeserializeBST {

    private String spliter = ",";

    public String serialize(TreeNode root){
        StringBuilder sb = new StringBuilder();
        buildString(root, sb);
        return sb.toString();
    }

    private void buildString(TreeNode node, StringBuilder sb){
        if(node == null)    return;
        sb.append(node.val).append(spliter);
        buildString(node.left, sb);
        buildString(node.right, sb);
    }

    public TreeNode deSerialize(String data){
        if(data.length() == 0)  return null;

        String[] nodes = data.split(spliter);
        int[] pos = {0};

        return buildTree(nodes, pos, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private  TreeNode buildTree(String[] data, int[] pos, int min, int max){
        if(pos[0] == data.length)    return null;

        int val = Integer.valueOf(data[pos[0]]);
        if(val < min || val > max)  return null;
        TreeNode root = new TreeNode(val);

        pos[0]++;
        root.left = buildTree(data, pos, min, val);
        root.right = buildTree(data, pos, val, max);

        return root;
    }

    public static void main(String[] args){
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(6);
        TreeNode r3 = new TreeNode(4);
        TreeNode l2 = new TreeNode(2);
        TreeNode r2 = new TreeNode(7);

        root.left = l1;
        root.right = r1;
        l1.left = l2;
        r1.right = r2;
        l1.right = r3;

        SerializeAndDeserializeBST sd = new SerializeAndDeserializeBST();
        System.out.println(sd.serialize(root));
        TreeNode node = sd.deSerialize("5,3,2,4,6,7,");
        StringBuilder sb = new StringBuilder();
        sd.buildString(node, sb);
        System.out.println(sb);
    }
}
