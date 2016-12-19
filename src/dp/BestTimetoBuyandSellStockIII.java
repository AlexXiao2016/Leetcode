package dp;

public class BestTimetoBuyandSellStockIII {
	public int maxProfit(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int price : prices){
        	hold1 = Math.max(hold1, -price);
        	release1 = Math.max(release1, price + hold1);
        	hold2 = Math.max(hold2, release1 - price);
        	release2 = Math.max(release2, price + hold2);
        }
        return release2;
    }
}
