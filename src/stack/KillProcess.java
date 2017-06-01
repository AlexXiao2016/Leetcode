package stack;

import java.util.*;

public class KillProcess {
	public static List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(int i = 0; i < ppid.size(); i++){
            if(!map.containsKey(ppid.get(i))){
                map.put(ppid.get(i), new HashSet<>());
            }
            map.get(ppid.get(i)).add(pid.get(i));            
        }
        
        List<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(kill);
        while(!stack.isEmpty()){
            int cur = stack.pop();
            res.add(cur);
            Set<Integer> tmp = map.get(cur);
            if(tmp == null) continue;
            stack.addAll(tmp);
        }
        
        return res;
    }
	
	public static void main(String args[]){
		Integer ppid[] = {3, 0, 5, 3};
		Integer pid[] = {1, 3, 10, 5};
		
		killProcess(Arrays.asList(pid), Arrays.asList(ppid), 5);
	}
}
