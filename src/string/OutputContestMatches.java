package string;
import java.util.*;

public class OutputContestMatches {
	public static String findContestMatch(int n) {
        List<String> list = new ArrayList<>();
        for(int i = 1; i <= n; i++){
            list.add(String.valueOf(i));
        }
        
        while(list.size() != 1){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < list.size() / 2; i++){
                temp.add("(" + list.get(i) + "," + list.get(list.size() - 1 - i) + ")");
            }
            list = temp;
        }
        
        return list.get(0);
        
        
        
    }
	
	public static void main(String args[]){
		System.out.println(findContestMatch(4));
	}
	
}
