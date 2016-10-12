package hashTable;

import java.util.*;

public class RepeatedDNASequences {
	public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> original = new HashSet<>();
        HashSet<String> repeated = new HashSet<>();
        
        for(int i = 0; i + 10 <= s.length(); i++){
            String temp = s.substring(i, i + 10);
            if(original.add(temp) == false){
                repeated.add(temp);
            }
        }
        return new ArrayList<String>(repeated);
    }
}
