package string;

public class ValidWordAbbreviation {
	public static boolean validWordAbbreviation(String word, String abbr) {
		int i = 0, j = 0;
		while(i < word.length() && j < abbr.length()){
			if(word.charAt(i) == abbr.charAt(j)){
				i++;
				j++;
				continue;
			}
			char c = abbr.charAt(j);
			if(c <= '0' || c > '9'){
				return false;
			}
			int start = j;
			while(j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9'){
				j++;
			}
			int count = Integer.valueOf(abbr.substring(start, j));
			i += count;
		}
		return i == word.length() && j == abbr.length();
	}
	
	public static void main(String args[]){
		System.out.println(validWordAbbreviation("a", "01"));
	}
}
