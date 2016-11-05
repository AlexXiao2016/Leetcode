package string;

public class StringtoInteger {
	public int myAtoi(String str) {
        if(str.isEmpty()){
            return 0;
        }
        int i = 0, sign = 1, base = 0;
        while(str.charAt(i) == ' '){
            i++;
        }
        if(str.charAt(i) == '+' || str.charAt(i) == '-'){
            sign = str.charAt(i++) == '+' ? 1 : -1;
        }
        
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while(i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9'){
            if(base > max / 10 || (base == max / 10 && str.charAt(i) > '7')){
                return sign == 1? max : min;
            }
            base = base * 10 + str.charAt(i++) - '0';
        }
        return base * sign;
    }
}
