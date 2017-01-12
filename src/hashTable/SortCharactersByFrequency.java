package hashTable;

import java.util.*;

public class SortCharactersByFrequency {
	public String frequencySort(String s) {
		Map<Character, Integer> map = new HashMap<>();

		char[] sArray = s.toCharArray();

		for (Character ch : sArray) {
			map.put(ch, map.getOrDefault(ch, 0) + 1);
		}

		PriorityQueue<CharFrequency> queue = new PriorityQueue<>((a, b) -> b.count - a.count);

		for (Character ch : map.keySet()) {
			queue.add(new CharFrequency(ch, map.get(ch)));
		}

		String result = "";
		while (!queue.isEmpty()) {
			result += getString(queue.poll());
		}

		return result;
	}

	private String getString(CharFrequency cf) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < cf.count; i++) {
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

	public String frequencySort2(String s) {
		if (s.length() < 3)
			return s;
		int max = 0;
		int[] map = new int[256];
		for (char ch : s.toCharArray()) {
			map[ch]++;
			max = Math.max(max, map[ch]);
		}
		String[] buckets = new String[max + 1]; // create max buckets
		for (int i = 0; i < 256; i++) { // join chars in the same bucket
			String str = buckets[map[i]];
			if (map[i] > 0)
				buckets[map[i]] = (str == null) ? "" + (char) i : (str + (char) i);
		}
		StringBuilder strb = new StringBuilder();
		for (int i = max; i >= 0; i--) { // create string for each bucket.
			if (buckets[i] != null)
				for (char ch : buckets[i].toCharArray())
					for (int j = 0; j < i; j++)
						strb.append(ch);
		}
		return strb.toString();
	}
	
	public static void main(String args[]){
		SortCharactersByFrequency scbf = new SortCharactersByFrequency();
		scbf.frequencySort2("tree");
	}
}
