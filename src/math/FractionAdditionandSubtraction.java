package math;

public class FractionAdditionandSubtraction {
	public static void main(String args[]){
		String str = "7/8+8/9-2/3";
		String res[] = str.split("(?=[-,+])");
		for(String s : res){
			System.out.print(s + " ");
		}
	}
}
