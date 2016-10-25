package array;

import java.util.*;

public class FindKPairswithSmallestSums {
	public static List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		if(nums1.length == 0 || nums2.length == 0 || k == 0){
			return new ArrayList<int[]>();
		}
		if(k > nums1.length * nums2.length){
			k = nums1.length * nums2.length;
		}
		List<int[]> result = new ArrayList<>();
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] + b[1] - a[0] - a[1]);
		
		for(int i = 0; i < nums1.length; i++){
			for(int j = 0; j < nums2.length; j++){
				if(pq.size() < k){
					pq.add(new int[]{nums1[i], nums2[j]});
				}else{
					int[] temp = pq.peek();
					if(temp[0] + temp[1] > nums1[i] + nums2[j]){
						pq.poll();
						pq.add(new int[]{nums1[i], nums2[j]});
					}else{
						break;
					}
				}
			}
		}
		
		while(!pq.isEmpty()){
			int[] temp = pq.poll();
			result.add(new int[]{temp[0], temp[1]});
		}
		
		return result;
	}
	
	public static void main(String args[]){
		int[] nums1 = {1,1,2};
		int[] nums2 = {1,2,3};
		List<int[]> result = kSmallestPairs(nums1, nums2, 2);
		System.out.println();
	}
}	
