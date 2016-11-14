package bitmanipulation;

public class SingleNumberII {
	public int singleNumber(int[] nums) {
		int one = 0, two = 0;
		for(int i = 0; i < nums.length; i++){
			one = (one ^ nums[i]) & ~two;
			two = (two ^ nums[i]) & ~one;			
		}

		return one;
	}

	public int singleNumber2(int[] nums){
		int result = 0;
		for (int i = 0; i < 32; i++) {
			int count = 0;
			for (int j = 0; j < nums.length; j++) {
				count += ((nums[j] >> i) & 1);
			}
			result |= ((count % 3) << i);
		}
		return result;
	}
	
	public static void main(String args[]){
		SingleNumberII sn = new SingleNumberII();
//		
//		int[] nums = {1,2,3,2,2,1,1} ;
//		sn.singleNumber2(nums);
		
		int num = 10;
		System.out.println(~num);
	}
}
