package backtracking;
import java.util.*;

public class GeneralizedAbbreviation {
	public List<String> generateAbbreviations(String word){
        List<String> ret = new ArrayList<String>();
        backtrack(ret, word, 0, "", 0);

        return ret;
    }

    private void backtrack(List<String> ret, String word, int pos, String cur, int count){
        if(pos==word.length()){
            if(count > 0) cur += count;
            ret.add(cur);
        }
        else{
            backtrack(ret, word, pos + 1, cur, count + 1);
            backtrack(ret, word, pos+1, cur + (count>0 ? count : "") + word.charAt(pos), 0);
        }
    }
    
    public static void main(String args[]){
    	GeneralizedAbbreviation ag = new GeneralizedAbbreviation();
    	for(String str: ag.generateAbbreviations("backtracking")){
    		System.out.println(str);
    	}
    }
}
