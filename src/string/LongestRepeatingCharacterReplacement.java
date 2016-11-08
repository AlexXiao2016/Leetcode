package string;

public class LongestRepeatingCharacterReplacement {
	public static int characterReplacement(String s, int k) {
		int count[] = new int[26];
		int max = 0;
		int start = 0;
		for(int end = 0; end < s.length(); end++){
			max = Math.max(max, ++count[s.charAt(end) - 'A']);
			if(max + k <= end - start){
				count[s.charAt(start++) - 'A']--;
			}
		}
		return s.length() - start;
	}
	
	public static void main(String args[]){
		String s = "ABAA";
		System.out.println(characterReplacement(s, 0));
		
	}
}
