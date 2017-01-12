package hashTable;

import java.util.*;

public class SortCharactersByFrequency {
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();

		char[] sArray = s.toCharArray();

		for(Character ch : sArray) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}
		
		PriorityQueue<CharFrequency> queue = new PriorityQueue<>((a, b) -> b.count - a.count);
		
		for(Character ch : map.keySet()){
			queue.add(new CharFrequency(ch, map.get(ch)));
		}
		
		String result = "";
		while(!queue.isEmpty()){
			result += getString(queue.poll());
		}
		
		return result;
	}
	
	private String getString(CharFrequency cf){
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < cf.count; i++){
			sb.append(cf.ch);
		}
		return sb.toString();
	}

	private class CharFrequency {
		char ch;
		int count;

		public CharFrequency(char ch, int count) {
			this.ch = ch;
			this.count = count;
		}
	}
}
