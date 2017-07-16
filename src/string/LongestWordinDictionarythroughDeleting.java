package string;
import java.util.*;

/**
 * Created by xiaoping on 7/15/17.
 */
public class LongestWordinDictionarythroughDeleting {

    public String findLongestWord(String s, List<String> d) {
        if(s == null || s.length() == 0 || d.size() == 0)   return "";

        int max = 0;
        List<String> res = new ArrayList<>();
        for(String dic : d){
            if(isSubSeq(s, dic) && dic.length() >= max){
                if(dic.length() > max){
                    res.clear();
                }
                res.add(dic);
                max = dic.length();
            }
        }

        if(res.size() > 0) {
            Collections.sort(res);
            return res.get(0);
        }
        return "";
    }

    private boolean isSubSeq(String s, String d){
        if(s.length() < d.length()) return false;

        int j = 0;
        for(int i = 0; i < s.length(); i++){
            if(d.charAt(j) == s.charAt(i)){
                j++;
            }
            if(j == d.length()) return true;
        }

        return false;
    }

    public static void main(String[] args){
        LongestWordinDictionarythroughDeleting ld = new LongestWordinDictionarythroughDeleting();
        String s = "apple";
        String[] dict = {"zxc","vbn"};
        List<String> list = Arrays.asList(dict);
        System.out.println(ld.findLongestWord(s, list));
    }
}
