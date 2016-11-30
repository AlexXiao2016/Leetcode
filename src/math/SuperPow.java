package math;
import java.util.*;

public class SuperPow {
	public int superPow(int a, int[] b) {
		if(a == 0 || a == 1337 || b == null || b.length == 0) return 0;
		
		if(a == 1) return 1;
		if(a > 1337) return superPow(a % 1337, b);
		List<Integer> index = findLoop(a);
		int rem = modBy(b, index.size());
		rem = rem == 0? index.size() : rem;
		return index.get(rem - 1);
	}
	
	
	private List<Integer> findLoop(int a){
		List<Integer> res = new ArrayList<>();
		boolean set[] = new boolean[1337];
		int rem = a % 1337;
		while(!set[rem]){
			set[rem] = true;
			res.add(rem);
			rem = (rem * a) % 1337;
		}
		return res;
	}
	
	private int modBy(int[] b, int size){
		int rem = 0;
		for(int i = 0; i < b.length; i++){
			rem = (rem * 10 + b[i]) % size;
		}
		return rem;
	}
	
	public static void main(String args[]){
		SuperPow sp = new SuperPow();
		int b[] = {1,2,3,4,5,6,7,8,9};
		System.out.print(sp.superPow(5, b));
	}
}
