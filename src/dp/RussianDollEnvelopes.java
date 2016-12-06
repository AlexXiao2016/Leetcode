package dp;
import java.util.*;

public class RussianDollEnvelopes {
	//Sort the array. Ascend on width and descend on height if width are same.
	//Find the longest increasing subsequence based on height.
	//Since the width is increasing, we only need to consider height.
	//[3, 4] cannot contains [3, 3], so we need to put [3, 4] before [3, 3] 
	//when sorting otherwise it will be counted as an increasing number if the order is [3, 3], [3, 4]
	
	public int maxEnvelopes(int[][] envelopes) {
		if(envelopes == null || envelopes.length == 0 || envelopes[0].length == 0) return 0;
		
		Arrays.sort(envelopes, new Comparator<int[]>(){
			@Override
			public int compare(int[] a, int[] b){
				if(a[0] == b[0]){
					return b[1] - a[1];
				}
				return a[0] - b[0];
			}
		});
		
		int dp[] = new int[envelopes.length];
		int len = 0;
		for(int[] envelope : envelopes){
			int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
			if(index <  0){
				index = -(index + 1);
			}
			dp[index] = envelope[1];
			if(index == len){
				len++;
			}
		}
		
		return len;
	}
	
	public static void main(String args[]){
		
	}
	
}
