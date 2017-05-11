package hashTable;
import java.util.*;

public class SubstringwithConcatenationofAllWords {
	public List<Integer> findSubstring(String s, String[] words) {
		List<Integer> res = new ArrayList<>();
		if (s == null || words == null)
			return res;

		HashMap<String, Integer> map = new HashMap<>();
		for (int i = 0; i < words.length; i++) {
			map.put(words[i], map.getOrDefault(words[i], 0) + 1);
		}

		int m = words.length, n = words[0].length();
		for (int i = 0; i <= s.length() - m * n; i++) {
			HashMap<String, Integer> temp = new HashMap<>(map);

			int k = m, j = i;
			while (k > 0) {
				String key = s.substring(j, j + n);
				if (!map.containsKey(key) || temp.get(key) < 1)
					break;
				temp.put(key, map.get(key) - 1);
				k--;
				j += n;
			}
			if (k == 0) {
				res.add(i);
			}
		}
		return res;
	}
}
