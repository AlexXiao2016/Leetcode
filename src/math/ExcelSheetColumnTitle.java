package math;

public class ExcelSheetColumnTitle {
	public static String convertToTitle(int n) {
		String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

		StringBuilder sb = new StringBuilder();
		while(n > 0){
			sb.append(s.charAt((n - 1) % 26));			
			n = (n - 1) / 26;
		}
		
		return sb.reverse().toString();
	}
	
	public static void main(String args[]){
		System.out.println(convertToTitle(28));
	}
}
