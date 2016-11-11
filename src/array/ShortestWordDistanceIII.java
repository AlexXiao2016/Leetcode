package array;

public class ShortestWordDistanceIII {
	public static int shortestWordDistance(String[] words, String word1, String word2) {
		int index1 = -1, index2 = -1, distance = Integer.MAX_VALUE;
		for(int i = 0; i < words.length; i++){
			if(words[i].equals(word1)){
				if(word1.equals(word2) && index1 >= 0){
					distance = Math.min(distance, i - index1);
				}
				index1 = i;
				if(index2 >= 0){
					distance = Math.min(distance, index1 - index2);
				}
			}
			if(!word1.equals(word2) && words[i].equals(word2)){
				index2 = i;
				if(index1 >= 0){
					distance = Math.min(distance, index2 - index1);
				}
			}
		}
		
		return distance;
	}
	
	public static void main(String args[]){
		String[]  words = {"a", "a"};		
		int res = shortestWordDistance(words, "a", "a");
		System.out.println(res);
	}	
}
