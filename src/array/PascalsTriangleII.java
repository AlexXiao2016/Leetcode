package array;

import java.util.*;

public class PascalsTriangleII {
	public static List<Integer> getRow(int rowIndex) {
		List<Integer> res = new ArrayList<>();
		res.add(1);
		for(int i = 1; i <= rowIndex; i++){
			for(int j = i - 1; j >= 1; j--){
				int temp = res.get(j - 1) + res.get(j);
				res.set(j, temp);
			}
			res.add(1);
		}
		return res;
	}
	
	public static void main(String args[]){
		for(int i : getRow(5)){
			System.out.print(i + " ");
		}
	}
}
