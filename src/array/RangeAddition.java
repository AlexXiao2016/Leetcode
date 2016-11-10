package array;

public class RangeAddition {
	public static int[] getModifiedArray(int length, int[][] updates) {
        int[] result = new int[length];
        if(updates == null || updates.length == 0 || updates[0].length == 0){
            return result;
        }
        
        for(int[] update : updates){
            int start = update[0];
            int end = update[1];
            int value = update[2];
            
            result[start] += value;
            
            if(end < length - 1){
                result[end + 1] -= value;
            }
        }
        
        int sum = 0;
        for(int i = 0; i < length; i++){
            sum += result[i];
            result[i] = sum;
        }
        
        return result;
    }
	
	
	public static void main(String args[]){
		int[][] update = {{1, 3, 2}, {2, 4, 3}, {0, 2, -2}};
		
		getModifiedArray(5, update);
	} 
}
