package graph;
import java.util.*;

public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
		int course[] = new int[numCourses];
		List<List<Integer>> adjs = new ArrayList<>();
		
		for(int i = 0; i < numCourses; i++){
			adjs.add(new ArrayList<>());
		}
		
		for(int[] edge : prerequisites){
			course[edge[0]]++;
			adjs.get(edge[1]).add(edge[0]);
		}
		
		return bfs(course, adjs);
	}
	
	public int[] bfs(int[] course, List<List<Integer>> adjs){
		int order[] = new int[course.length];
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 0; i < course.length; i++){
			if(course[i] == 0){
				queue.offer(i);
			}
		}
		
		int visited = 0;
		while(!queue.isEmpty()){
			int from = queue.poll();
			order[visited++] = from;
			for(int to : adjs.get(from)){
				course[to]--;
				if(course[to] == 0) queue.offer(to);
			}
		}
		
		return visited == course.length? order : new int[0];
	}
	
	public int[] findOrderDFS(int numCourses, int[][] prerequisites){
		int result[] = new int[numCourses];
		List<List<Integer>> adj = new ArrayList<>();
		
		for(int i = 0; i < numCourses; i++){
			adj.add(new ArrayList<>());
		}
		
		for(int i = 0; i < prerequisites.length; i++){
			adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
		}
		boolean visited[] = new boolean[numCourses];
		Stack<Integer> stack = new Stack<>();
		for(int i = 0; i < numCourses; i++){
			if(!dfs(adj, i, stack, visited, new boolean[numCourses])){
				return new int[0];
			}
		}
		int i = 0; 
		while(!stack.isEmpty()){
			result[i++] = stack.pop();
		}
		
		return result;
	}
	
	
	private boolean dfs(List<List<Integer>> adj, int v, Stack<Integer> stack, boolean[] visited, boolean[] isLoop){
		if(visited[v]) return true;
		if(isLoop[v]) return false;
		isLoop[v] = true;
		
		for(Integer i : adj.get(v)){
			if(!dfs(adj, i, stack, visited, isLoop)) return false;
		}
		
		visited[v] = true;
		stack.push(v);
		return true;
	}
	
}
