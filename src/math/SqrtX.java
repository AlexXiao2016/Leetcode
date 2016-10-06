package math;

public class SqrtX {
	public int mySqrt(int x) {
		if(x == 0 || x == 4){
			return x / 2;
		}
		if(x < 4){
			return 1;
		}

		int left = 1, right = x / 2;
		while(true){
			int mid = left + (right - left) / 2;
			if(mid > x / mid){
				right = mid - 1;
			}else{
				if(mid + 1 > x / (mid + 1)){
					return mid;
				}
				left = mid + 1;
			}
		}
	}
}
