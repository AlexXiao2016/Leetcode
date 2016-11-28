package graph;
import java.util.*;

public class CloneGraph {

	class UndirectedGraphNode {
		int label;
		List<UndirectedGraphNode> neighbors;
		UndirectedGraphNode(int x) { 
			label = x; 
			neighbors = new ArrayList<UndirectedGraphNode>(); 
		}
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		if(node == null) return node;		
		Queue<UndirectedGraphNode> queue = new LinkedList<>();
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
		UndirectedGraphNode root = new UndirectedGraphNode(node.label);
		map.put(node.label, root);
		queue.offer(node);
		UndirectedGraphNode cur = root, newRoot = root, newNode = root;
		while(!queue.isEmpty()){
			cur = queue.poll();
			newRoot = map.get(cur.label);
			for(UndirectedGraphNode temp : cur.neighbors){
				if(map.containsKey(temp.label)){
					newNode = map.get(temp.label);
				}else{
					newNode = new UndirectedGraphNode(temp.label);
					map.put(temp.label, newNode);
					queue.offer(temp);
				}
				newRoot.neighbors.add(newNode);
			}
		}
		return root;
	}
	
	public UndirectedGraphNode cloneGraphDFS(UndirectedGraphNode node) {		
		HashMap<Integer, UndirectedGraphNode> map = new HashMap<>();
		return dfs(node, map);
	}
	
	public UndirectedGraphNode dfs(UndirectedGraphNode node, HashMap<Integer, UndirectedGraphNode> map){
		if(node == null) return null;
		
		if(map.containsKey(node.label)){
			return map.get(node.label);
		}
		
		UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
		map.put(node.label, clone);
		for(UndirectedGraphNode neighbor : node.neighbors){
			clone.neighbors.add(dfs(neighbor, map));
		}
		
		return clone;
	}
}
