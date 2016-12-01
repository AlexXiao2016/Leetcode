package dp;

public class GuessNumberHigherorLowerII {
	public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return solve(dp, 1, n);
    }
	
	private int solve(int[][] dp, int lower, int upper){
		if(lower >= upper) return 0;
		if(dp[lower][upper] != 0) return dp[lower][upper];
		
		int res = Integer.MAX_VALUE;
		for(int i = lower; i <= upper; i++){
			int temp = i + Math.max(solve(dp, lower, i - 1), solve(dp, i + 1, upper));
			res = Math.min(res, temp);
		}
		dp[lower][upper] = res;
		return res;
	}
	
	
	public static void main(String args[]){
		GuessNumberHigherorLowerII gnhl = new GuessNumberHigherorLowerII();
		gnhl.getMoneyAmount(2);
	}
}
