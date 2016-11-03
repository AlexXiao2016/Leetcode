package array;

import java.util.Arrays;

public class FirstUniqueCharacterinaString {
	public static int firstUniqChar(String s) {
		int[] count = new int[26];
		char[] sArr = s.toCharArray();
		Arrays.fill(count, -1);
		
		for(int i = 0; i < sArr.length; i++){
			int index = sArr[i] - 'a';
			if(count[index] == -1){
				count[index] = i;
			}else{
				count[index] = -2;
			}
		}
		
		int res = sArr.length;
		for(int i = 0; i < 26; i++){
			if(count[i] >= 0 && res > count[i]){
				res = count[i];
			}
		}
		
		return res == sArr.length ? -1 : res;
	}
	
	public static void main(String args[]){
		firstUniqChar("leetcode");
	}
}
