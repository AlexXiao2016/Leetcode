package backtracking;

import java.util.*;

public class BinaryWatch {
	public static List<String> readBinaryWatch(int num) {
		List<String> res = new ArrayList<String>();
		int hours[] = {8, 4, 2, 1};
		int mins[] = {32, 16, 8, 4, 2, 1};
		
		for(int i = 0; i <= num; i++){
			List<Integer> list1 = generateDigit(hours, i);
			List<Integer> list2 = generateDigit(mins, num - i);
			
			for(int num1 : list1){
				if(num1 > 12){
					continue;
				}
				for(int num2 : list2){
					if(num2 > 60){
						continue;
					}
					res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
				}
			}
		}
		return res;
	}
	
	private static List<Integer> generateDigit(int[] nums, int count){
		List<Integer> res = new ArrayList<>();
		generateDigitHelper(nums, count, 0, 0, res);
		return res;
	}
	
	public static void generateDigitHelper(int[] nums, int count, int pos, int sum, List<Integer> list){
		if(count == 0){
			list.add(sum);
			return;
		}
		for(int i = pos; i < nums.length; i++){
			generateDigitHelper(nums, count - 1, i + 1, sum + nums[i], list);
		}
	}
	
	public static void main(String args[]){
		readBinaryWatch(7);
	}
	
}
