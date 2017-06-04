package string;

import java.util.*;

public class SplitConcatenatedStrings {
	public static String splitLoopedString(String[] strs) {
		if (strs == null || strs.length == 0)
			return "";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < strs.length; i++) {
			String reverse = new StringBuilder(strs[i]).reverse().toString();
			sb.append(strs[i].compareTo(reverse) > 0 ? strs[i] : reverse);
		}

		String source = sb.toString();
		char max = 'a';
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < source.length(); i++) {
			char ch = source.charAt(i);
			if (max == ch)
				list.add(i);
			if (ch > max) {
				max = ch;
				list.clear();
				list.add(i);
			}
		}

		String res = "";
		for (int i = 0; i < list.size(); i++) {
			res = source.substring(list.get(i)) + source.substring(0, list.get(i));
			for (int j = i + 1; j < list.size(); j++) {
				String target = source.substring(list.get(j)) + source.substring(0, list.get(j));
				res = res.compareTo(target) > 0 ? res : target;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		
		
	}
}
