package array;

public class HIndexII {
	public int hIndex(int[] citations) {
		if(citations == null || citations.length == 0){
            return 0;
        }
        int length = citations.length;
        int low = 0, high = length - 1;
        
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(citations[mid] >= length - mid){
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        
        return length - low;
	}
}
