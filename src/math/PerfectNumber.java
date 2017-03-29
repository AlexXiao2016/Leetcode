package math;

public class PerfectNumber {
	public static boolean checkPerfectNumber(int num) {

		int sum = 1;
		for(int i = 2; i <= Math.sqrt(num); i++){
			if(num % i == 0){
				sum += i;
				sum += num / i;
			}

			if(sum > num){
				return false;
			}
		}

		if(sum == num){
			return true;
		}

		return false;
	}
	
	public static void main(String args[]){
		checkPerfectNumber(28);
	}
}
