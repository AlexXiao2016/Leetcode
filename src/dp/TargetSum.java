package dp;

public class TargetSum {

	public static int findTargetSumWays(int[] nums, int s) {
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}

		if (sum < s || (sum + s) % 2 != 0)
			return 0;

		sum = (sum + s) / 2;
		int[] dp = new int[sum + 1];
		dp[0] = 1;

		for (int num : nums) {
			for (int i = sum; i >= num; i--) {
				dp[i] += dp[i - num];
			}
			for (int i = 0; i <= sum; i++) {
				System.out.print(dp[i] + "\t");
			}
			System.out.println();
		}

		return dp[sum];
	}

	public static void main(String args[]) {
		int[] nums = { 1, 1, 1, 1, 1 };

		findTargetSumWays(nums, 3);
	}

}
