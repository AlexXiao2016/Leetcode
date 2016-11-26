package string;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		if(s == null || s.length() == 0){
			return null;
		}

		if(s.length() == 1){
			return s;
		}

		String longest = "";
		for(int i = 0; i < s.length(); i++){
			String temp = findLongest(s, i, i);
			if(temp.length() > longest.length()){
				longest = temp;
			}

			temp = findLongest(s, i, i + 1);
			if(temp.length() > longest.length()){
				longest = temp;
			}
		}
		return longest;
	}	

	public String findLongest(String s, int start, int end){
		while(start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)){
			start--;
			end++;
		}
		return s.substring(start + 1, end);
	}

	public static int longestPalindromes(String s) {

		int[] counter = new int[128];
		for(int i = 0; i < s.length(); i++){
			counter[s.charAt(i)]++;
		}

		int odd = 0;
		int length = 0;
		for(int i = 0; i < counter.length; i++){
			if(counter[i] > 0 && counter[i] % 2 == 0){
				length += counter[i];
			}else if(counter[i] > 0){
				odd = 1;
				length += (counter[i] - 1);
			}
		}

		return odd == 1? length + 1 : length;
	}

	public static void main(String args[]){
		longestPalindromes("abccccdd");
	} 
}
