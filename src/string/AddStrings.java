package string;

public class AddStrings {
	public static String addStrings(String num1, String num2) {
        if(num1 == null || num2 == null){
            return null;
        }
        
        if(num1.length() < num2.length()){
            String temp = num1;
            num1 = num2;
            num2 = temp;
        }
        int longLen = num1.length();
        int shortLen = num2.length();
        
        StringBuilder sb = new StringBuilder();
        int curr = 0, carry = 0, sum = 0;
        int j = shortLen - 1;
        for(int i = longLen - 1; i >= 0; i--){
            if(j >= 0){
                sum = num1.charAt(i) - '0' + (int)num2.charAt(j) - '0' + carry;
            }else{
                sum = num1.charAt(i) - '0' + carry;
            }
            curr = sum % 10;
            carry = sum / 10;
            sb.insert(0, String.valueOf(curr));
            j--;
        }
        if(carry == 1){
            sb.insert(0, "1");
        }
        return sb.toString();
    }
}
