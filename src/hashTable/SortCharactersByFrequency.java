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

	private String frequencySort2(String s) {
		if (s == null || s.length() < 3)
			return s;

		int map[] = new int[256];
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			map[s.charAt(i)]++;
			max = Math.max(map[s.charAt(i)], max);
		}

		String bucket[] = new String[max + 1];
		for (int i = 0; i < 256; i++) {
			String str = bucket[map[i]];
			if (map[i] > 0) {
				bucket[map[i]] = (str == null ? "" + (char) i : (str + (char) i));
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = max; i >= 0; i--) {
			String str = bucket[i];
			if (str != null) {
				for (char c : str.toCharArray()) {
					for (int j = 0; j < i; j++) {
						sb.append(c);
					}
				}
			}
		}

		return sb.toString();
	}

	public static void main(String args[]) {
		SortCharactersByFrequency scbf = new SortCharactersByFrequency();
		scbf.frequencySort2("tree");
		
	}
}
