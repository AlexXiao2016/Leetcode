import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent {
	public List<Integer> topKFrequent(int[] nums, int k) {
		if(nums == null || nums.length == 0 || k <= 0){
			return null;
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i < nums.length; i++){
			if(map.containsKey(nums[i])){
				map.put(nums[i], map.get(nums[i]) + 1);
			}else{
				map.put(nums[i], 1);
			}
		}
		
		PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
		pq.addAll(map.entrySet());
		
		List<Integer> list = new ArrayList<Integer>();
		for(int i = 0; i < k; i++){
			list.add(pq.poll().getKey());
		}

		return list;
	}
	
		

}
