package dp;

public class BestTimetoBuyandSellStockIV {
	public int maxProfit(int k, int[] prices) {
		if(prices == null || prices.length == 0) return 0;
		
		int maxProfit = 0;
		if(k >= prices.length / 2){
			for(int i = 1; i < prices.length; i++){
				if(prices[i] > prices[i - 1]){
					maxProfit += prices[i] - prices[i - 1];
				}
			}
			return maxProfit;
		}
		
		int[][] dp = new int[k + 1][prices.length];
		for(int i = 1; i <= k; i++){
			int curHold = dp[i - 1][0] - prices[0];
			for(int j = 1; j < dp[0].length; j++){
				dp[i][j] = Math.max(dp[i][j - 1], prices[j] + curHold);
				curHold = Math.max(curHold, dp[i - 1][j] - prices[j]);
			}
		}
		
		return dp[k][prices.length - 1];
	}
}
