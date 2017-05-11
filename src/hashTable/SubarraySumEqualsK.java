package hashTable;

import java.util.HashMap;

public class SubarraySumEqualsK {
	public static int subarraySum(int[] nums, int k) {
		int sum = 0, result = 0;

		HashMap<Integer, Integer> map = new HashMap<>();
		map.put(0, 1);

		for (int num : nums) {
			sum += num;

			int key = sum - k;
			if (map.containsKey(key)) {
				result += map.get(key);
			}

			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}

		return result;
	}

	public static void main(String args[]) {
		int nums[] = { 1, 2, 3, 2, 1 };
		System.out.print(subarraySum(nums, 6));
	}

}
