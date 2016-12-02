package graph;
import java.util.*;

public class ReconstructItinerary {
	public List<String> findItinerary(String[][] tickets) {
		List<String> res = new ArrayList<>();
		if(tickets == null || tickets.length == 0 || tickets[0].length == 0){
			return res;
		}
		
		HashMap<String, PriorityQueue<String>> map = new HashMap<>();
		for(String ticket[] : tickets){
			if(!map.containsKey(ticket[0])) map.put(ticket[0], new PriorityQueue<>());
			map.get(ticket[0]).offer(ticket[1]);
		}
		
		String curr = "JFK";
		Stack<String> stack = new Stack<>();
		for(int i = 0; i < tickets.length; i++){
			while(!map.containsKey(curr) || map.get(curr).isEmpty()){
				stack.push(curr);
				curr = res.remove(res.size() - 1);
			}
			res.add(curr);
			curr = map.get(curr).poll();
		}
		
		stack.push(curr);
		while(!stack.isEmpty()) res.add(stack.pop());
		return res;
	}
	
	public static void main(String args[]){
		String[][] tickets = {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}};
		ReconstructItinerary ri = new ReconstructItinerary();
		for(String str : ri.findItinerary(tickets)){
			System.out.print(str + " ");
		}
	}
}
