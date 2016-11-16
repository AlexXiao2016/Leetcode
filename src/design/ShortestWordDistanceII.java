package design;
import java.util.*;

public class ShortestWordDistanceII {
	
	HashMap<String, List<Integer>> map;
	
	public ShortestWordDistanceII(String[] words) {
		map = new HashMap<>();
		
		for(int i = 0; i < words.length; i++){
			List<Integer> list = map.get(words[i]);
			if(list == null){
				list = new ArrayList<>();
			}
			
			list.add(i);
			map.put(words[i], list);
		}
	}

	public int shortest(String word1, String word2) {
		List<Integer> list1 = map.get(word1);
		List<Integer> list2 = map.get(word2);
		
		int min = Integer.MAX_VALUE;
		for(Integer i : list1){
			for(Integer j : list2){
				if(Math.abs(i - j) < min){
					min = Math.abs(i - j);
				}
			}
		}
		
		return min;
	}
	
	public static void main(String args[]){
		String s[] = {"a","c", "b", "a"};
		ShortestWordDistanceII sd = new ShortestWordDistanceII(s);
		System.out.println(sd.shortest("a", "b"));
	}
}
