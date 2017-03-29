package math;

public class ComplexNumberMultiplication {
	
	public static String complexNumberMultiply(String a, String b) {
        int index1 = a.indexOf('+');
        int a1 = index1 == 0 ? 0 : Integer.valueOf(a.substring(0, index1));
        int b1 = Integer.valueOf(a.substring(index1 + 1, a.length() - 1));
        
        int index2 = a.indexOf('+');
        int a2 = index2 == 0 ? 0 : Integer.valueOf(b.substring(0, index2));
        int b2 = Integer.valueOf(b.substring(index2 + 1, b.length() - 1));
        
        int finalA = a1 * a2 - b1 * b2;
        int finalB = a1 * b2 + a2 * b1;
        
        StringBuilder sb = new StringBuilder();
        sb.append(finalA);
        sb.append("+");
        sb.append(finalB);
        sb.append("i");
        return sb.toString();
    }
	
	public static void main(String args[]){
		String a = "1+-1i";
		String b = "0+0i";
		System.out.println(complexNumberMultiply(a, b));
	}
}
