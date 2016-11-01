
public class ValidPerfectSquare {
	public static boolean isPerfectSquare(int num) {
		if(num == 1) {
			return true;
		}
		
		int low = 2, high = num / 2;
		while(low <= high){
			long mid = low + (high - low) / 2;
			if(mid * mid == num){
				return true;
			}else if(mid * mid < num){
				low = (int) mid + 1;
			}else{
				high = (int) mid - 1;
			}
		}
		
		return false;
	}
	
	
	public static boolean isPerfectSquare1(int num) {
		int sum = 0;
		
		for(int i = 0; sum <= num; i++){
			sum += 2 * i + 1;
			if(sum == num){
				return true;
			}
		}
		
		return false;
	}
	
	public static void main(String args[]){
		System.out.println(isPerfectSquare(2147483647));
	}
}
