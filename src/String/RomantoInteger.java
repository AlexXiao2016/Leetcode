package String;

public class RomantoInteger {
	public int romanToInt(String s) {
		int sum = 0;
		for(int i = s.length() - 1; i >= 0; i--){
			char c = s.charAt(i);
			switch(c){
			case 'I':
				sum += (sum >= 5 ? -1 : 1);
				break;
			case 'V':
				sum += 5;
				break;
			case 'X':
				sum += 10 * (sum > 50 ? -1 : 1);
				break;
			case 'L':
				sum += 50;
				break;
			case 'C':
				sum += 100 * (sum > 500 ? -1 : 1);
				break;
			case 'D':
				sum += 500;
				break;
			case 'M':
				sum += 1000;
				break;
			}
		}
		
		return sum;
	}
}
