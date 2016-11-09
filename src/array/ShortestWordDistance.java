package array;

public class ShortestWordDistance {
	public int shortestDistance(String[] words, String word1, String word2) {
        int result = Integer.MAX_VALUE;
        int index1 = -1, index2 = -1;
        
        for(int i = 0; i < words.length; i++){
            if(words[i].equals(word1)){
                index1 = i;
                if(index2 >= 0){
                    result = Math.min(result, i - index2);
                }
            }
            if(words[i].equals(word2)){
                index2 = i;
                if(index1 >= 0){
                    result = Math.min(result, i - index1);
                }
            }
        }
        
        return result;
    }
}
