package dp;

public class PaintHouse {
	public int minCost(int[][] costs) {
		if(costs == null || costs.length == 0 || costs[0].length != 3){
			return 0;
		}
		
		int lastR = costs[0][0];
		int lastG = costs[0][1];
		int lastB = costs[0][2];
		
		for(int i = 1; i < costs.length; i++){
			int curR = Math.min(lastG, lastB) + costs[i][0];
			int curG = Math.min(lastR, lastB) + costs[i][1];
			int curB = Math.min(lastR, lastG) + costs[i][2];
			lastR = curR;
			lastG = curG;
			lastB = curB;
		}
		
		return Math.min(lastR, Math.min(lastG, lastB));
	}
}
