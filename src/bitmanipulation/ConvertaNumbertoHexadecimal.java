package bitmanipulation;

public class ConvertaNumbertoHexadecimal {
	public static String toHex(int num) {
		String[] map = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "a", "b", "c", "d", "e", "f"};
		
		if(num == 0) return "0";
		String result = "";
		while(num != 0){
			result = map[num & 15] + result;
			num = num >>> 4;
		}
		
		return result;
	}
	
	
	public static void main(String args[]){
		System.out.println(toHex(-1));
	}
}
