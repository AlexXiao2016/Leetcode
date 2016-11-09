package string;
import java.util.*;

public class FlipGame {
	public List<String> generatePossibleNextMoves(String s) {
		List<String> list = new ArrayList<>();
		if(s == null || s.length() < 2){
			return list;
		}

		for(int i = 0; i < s.length() - 1; i++){
			if(s.substring(i, i + 2).equals("++")){
				StringBuilder sb = new StringBuilder();
				sb.append(s.substring(0, i));
				sb.append("--");
				sb.append(s.substring(i + 2));
				list.add(sb.toString());
			}
		}
		return list;
	}
}
