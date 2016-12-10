package string;

import java.util.*;

public class FindAllAnagramsinaString {
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<Integer>();
		if (s == null || s.length() == 0  || p == null || p.length() == 0 || s.length() < p.length())
			return result;

		char pc[] = p.toCharArray();
		int map[] = new int[26];
		for (int i = 0; i < pc.length; i++) {
			map[pc[i] - 'a']++;
		}

		int left = 0, right = 0;
		int count = p.length();
		
		while (right < s.length()) {
			if (map[s.charAt(right) - 'a'] > 0) {
				count--;
			}
			map[s.charAt(right) - 'a']--;
			right++;

			if (count == 0) {
				result.add(left);
			}

			if (right - left == p.length()) {
				if (map[s.charAt(left) - 'a'] >= 0) {
					count++;
				}
				map[s.charAt(left) - 'a']++;
				left++;
			}
		}
		return result;
	}

	public static void main(String args[]) {
		FindAllAnagramsinaString faas = new FindAllAnagramsinaString();
		faas.findAnagrams("cbaebabacd", "abc");
	}
}
