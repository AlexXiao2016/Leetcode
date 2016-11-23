package graph;
import java.util.*;

public class CourseSchedule {
	public boolean canFinishBFS(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses]; // i -> j
	    int[] indegree = new int[numCourses];
	    
	    for (int i=0; i<prerequisites.length; i++) {
	        int ready = prerequisites[i][0];
	        int pre = prerequisites[i][1];
	        if (matrix[pre][ready] == 0)
	            indegree[ready]++; //duplicate case
	        matrix[pre][ready] = 1;
	    }
	    
	    int count = 0;
	    Queue<Integer> queue = new LinkedList<>();
	    for (int i=0; i<indegree.length; i++) {
	        if (indegree[i] == 0) queue.offer(i);
	    }
	    while (!queue.isEmpty()) {
	        int course = queue.poll();
	        count++;
	        for (int i=0; i<numCourses; i++) {
	            if (matrix[course][i] != 0) {
	                if (--indegree[i] == 0)
	                    queue.offer(i);
	            }
	        }
	    }
	    return count == numCourses;
	}
	
	
	public boolean canFinishDFS(int numCourses, int[][] prerequisities){
		if(numCourses == 0 || prerequisities == null || prerequisities.length == 0 || prerequisities[0].length == 0) {
			return true;
		}
		
		List<List<Integer>> courses = new ArrayList<>();
		for(int i = 0; i < numCourses; i++){
			courses.add(new ArrayList<Integer>());
		}
		
		for(int i = 0; i < prerequisities.length; i++){
			courses.get(prerequisities[i][1]).add(prerequisities[i][0]);
		}
		
		int visited[] = new int[numCourses];
		
		for(int i = 0; i < numCourses; i++){
			if(!dfs(i, courses, visited)) return false;
		}
		
		return true;
	}
	
	public boolean dfs(int course, List<List<Integer>> courses, int visited[]){
		visited[course] = 1;
		
		List<Integer> eligibleCourses = courses.get(course);
		
		for(int i = 0; i < eligibleCourses.size(); i++){
			int eligibleCourse = eligibleCourses.get(i);
			
			if(visited[eligibleCourse] == 1) return false;
			if(visited[eligibleCourse] == 0){ // not visited
				if(!dfs(eligibleCourse, courses, visited)) return false;
			}
		}
		
		visited[course] = 2;
		return true;
	}
}
