package string;

public class ZigZagConversion {
	public static String convert(String s, int numRows) {
        if(numRows <= 1){
            return s;
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= numRows; i++){
        	//the start position of each line
            int start = i - 1;
            while(start  < s.length()){
            	//append char of each line
                sb.append(s.charAt(start));
                
                if(i > 1 && i < numRows){
                	//except the first line and the last line, we have an extra char 
                	//calculate the position for the extra char
                	int index = start + 2 * numRows - 2 - 2 * (i - 1); 
                	if(index > 0 && index < s.length()) sb.append(s.charAt(index));
                }
                //In the same line, calculate the position for next char 
                start += 2 * numRows - 2;
            }
        }
        return sb.toString();
    }
	
	public static void main(String args[]){
		System.out.println(convert("PAYPALISHIRING", 3));
	}
}
