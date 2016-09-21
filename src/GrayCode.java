import java.util.*;


public class GrayCode {
	public List<Integer> grayCode(int n) {
		List<Integer> list = new ArrayList<>();
		list.add(0);
		
		int mask = 1;
		for(int i = 1; i <= n; i++){
			for(int j = list.size() - 1; j >= 0; j--){
				list.add(list.get(j) | mask );
			}
			mask <<= 1;
		}
		
		return list;
	}
	
	
	public static void main(String args[]){
		GrayCode gc = new GrayCode();
		System.out.println(gc.grayCode(3));
	}
}
