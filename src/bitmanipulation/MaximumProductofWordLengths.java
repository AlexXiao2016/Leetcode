package bitmanipulation;

public class MaximumProductofWordLengths {
	public static int maxProduct(String[] words) {
		if(words == null || words.length <= 1){
			return 0;
		}
		
		int[] bits = new int[words.length];
		for(int i = 0; i < words.length; i++){
			int value = 0;
			for(int j = 0; j < words[i].length(); j++){
				value |= 1 << (words[i].charAt(j) - 'a');
			}
			bits[i] = value;
		}
		
		int max = 0;
		for(int i = 0; i < words.length; i++){
			for(int j = i + 1; j < words.length; j++){
				if((bits[i] & bits[j]) == 0) {
					max = Math.max(max, words[i].length() * words[j].length());
				}
			}
		}
		
		return max;
	}
	
	public static void main(String args[]){
		String words[] = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
		System.out.println(maxProduct(words));		
	}
}
