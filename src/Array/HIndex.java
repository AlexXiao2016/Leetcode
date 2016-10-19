package Array;

public class HIndex {
	public static int hIndex(int[] citations) {
		if(citations == null || citations.length == 0){
			return 0;
		}
		int length = citations.length;
		int count[] = new int[length + 1];
		for(int i = 0; i < length; i++){
			if(citations[i] > length){
				count[length]++;
			}else{
				count[citations[i]]++;
			}
		}
		
		int res = 0;
		for(int i = length; i >= 0; i--){
			res += count[i];
			if(res >= i){
				return i;
			}
		}
		
		return 0;		
	}
	
	public static void main(String args[]){
		int nums[] = {3, 0, 6, 1, 5};
		System.out.println(hIndex(nums));
	}
}
