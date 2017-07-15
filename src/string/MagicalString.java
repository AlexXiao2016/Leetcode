package string;

public class MagicalString {
	public int magicalString(int n) {
		if (n <= 0)
			return 0;

		int[] arr = new int[n];
		arr[0] = 1;
		if(n >= 2) arr[1] = 2;

		int pre = 1, i = 1, count = 1, start = 1;
		while(i < n) {
			int j = 0;
			pre = pre == 1 ? 2 : 1;
			while (j++ < arr[start] && i < n) {
				arr[i] = pre;
				if (arr[i] == 1) {
					count++;
				}
				i++;
			}
			start++;			
		}
		
		for(i = 0; i < arr.length; i++){
			System.out.print(arr[i] + " ");
		}

		return count;
	}
	
	public static void main(String args[]){
		MagicalString ms = new MagicalString();
		ms.magicalString(21);
	}
}
