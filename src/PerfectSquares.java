
public class PerfectSquares {
	public static int numSquares(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 0;
		
		for(int i = 1; i <= n; i++){
			int square = Integer.MAX_VALUE;
			for(int j = 1; j * j <= i; j++){
				square = Math.min(square, dp[i - j * j] + 1);
			}
			dp[i] = square;
		}
		
		return dp[n];
	}
}
