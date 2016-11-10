package string;

public class StrobogrammaticNumber {
	public boolean isStrobogrammatic(String num) {
		String original = "00 11 88 696";
		for(int i = 0, j = num.length() - 1; i <= j; i++, j--){
			if(!original.contains(num.charAt(i) + "" + num.charAt(j))){
				return false;
			}
		}
		return true;
	}
}
