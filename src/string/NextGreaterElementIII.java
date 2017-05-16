package string;

import java.util.*;

public class NextGreaterElementIII {
	public static int nextGreaterElement(int n) {
		char[] num = String.valueOf(n).toCharArray();

		int i, j;
		for (i = num.length - 1; i > 0; i--) {
			if (num[i] > num[i - 1])
				break;
		}

		if (i == 0)
			return -1;

		int min = i, val = num[i - 1];
		for (j = i + 1; j < num.length; j++) {
			if (num[j] <= num[min] && num[j] > val) {
				min = j;
			}
		}

		char temp = num[i - 1];
		num[i - 1] = num[min];
		num[min] = temp;

		Arrays.sort(num, i, num.length);

		return Integer.parseInt(new String(num));

	}
	
	public static void main(String args[]){
		System.out.println(nextGreaterElement(52976843));
	}
}
